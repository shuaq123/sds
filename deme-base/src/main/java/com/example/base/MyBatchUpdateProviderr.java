package com.example.base;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.annotation.Version;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;
import tk.mybatis.mapper.version.VersionException;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName MyBatchUpdateProvider
 * @Author yannuodong
 * @Date 2021-07-05
 */
public class MyBatchUpdateProviderr extends MapperTemplate {

    public MyBatchUpdateProviderr(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String updateBatchByPrimaryKeySelective(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        //开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append("<trim prefix=\"set\" suffixOverrides=\",\">");

        //获取全部列
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        String columnName = columnList.stream().filter(EntityColumn::isId).map(entityColumn -> entityColumn.getEntityField().getName()).collect(Collectors.toList()).get(0);
        String primaryKey = columnList.stream().filter(EntityColumn::isId).map(entityColumn -> entityColumn.getColumn()).collect(Collectors.toList()).get(0);
        for (EntityColumn column : columnList) {
            /*if (column.isId()) {
                System.out.println(column.getEntityField().getName());
            }*/
            if (!column.isId() && column.isUpdatable()) {
                sql.append("  <trim prefix=\""+column.getColumn()+" =case\" suffix=\"end,\">");
                sql.append("    <foreach collection=\"list\" item=\"i\" index=\"index\">");
                sql.append("      <if test=\"i."+column.getEntityField().getName()+"!=null\">");
                sql.append("         when "+ primaryKey +" = #{i."+ columnName +"} then #{i."+column.getEntityField().getName()+"}");
                sql.append("      </if>");
                sql.append("    </foreach>");
                sql.append("  </trim>");
            }
        }

        sql.append("</trim>");
        sql.append("WHERE");
        sql.append(" " + primaryKey +" IN ");
        sql.append("<trim prefix=\"(\" suffix=\")\">");
        sql.append("<foreach collection=\"list\" separator=\", \" item=\"i\" index=\"index\" >");
        sql.append("#{i." + columnName + "}");
        sql.append("</foreach>");
        sql.append("</trim>");
        return sql.toString();
    }

    public String updateBatchByPrimaryKey(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        //开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append("<trim prefix=\"set\" suffixOverrides=\",\">");

        //获取全部列
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        String columnName = columnList.stream().filter(EntityColumn::isId).map(entityColumn -> entityColumn.getEntityField().getName()).collect(Collectors.toList()).get(0);
        String primaryKey = columnList.stream().filter(EntityColumn::isId).map(entityColumn -> entityColumn.getColumn()).collect(Collectors.toList()).get(0);
        for (EntityColumn column : columnList) {
            /*if (column.isId()) {
                System.out.println(column.getEntityField().getName());
            }*/
            if (!column.isId() && column.isUpdatable()) {
                sql.append("  <trim prefix=\""+column.getColumn()+" =case\" suffix=\"end,\">");
                sql.append("    <foreach collection=\"list\" item=\"i\" index=\"index\">");
                sql.append("       when "+ primaryKey +" = #{i."+ columnName +"} then #{i."+column.getEntityField().getName()+"}");
                sql.append("    </foreach>");
                sql.append("  </trim>");
            }
        }

        sql.append("</trim>");
        sql.append("WHERE");
        sql.append(" " + primaryKey +" IN ");
        sql.append("<trim prefix=\"(\" suffix=\")\">");
        sql.append("<foreach collection=\"list\" separator=\", \" item=\"i\" index=\"index\" >");
        sql.append("#{i." + columnName + "}");
        sql.append("</foreach>");
        sql.append("</trim>");
        return sql.toString();
    }

    /**
     * 需要重写SqlHelper中的方法，因为SqlHelper的useVersion在foreach中不能用。
     *
     * @param entityClass
     * @param entityName
     * @param useVersion
     * @return
     */
    private String wherePKColumns(Class<?> entityClass, String entityName, boolean useVersion) {
        StringBuilder sql = new StringBuilder();
        boolean hasLogicDelete = SqlHelper.hasLogicDeleteColumn(entityClass);
        sql.append("<where>");
        Set<EntityColumn> columnSet = EntityHelper.getPKColumns(entityClass);
        Iterator var6 = columnSet.iterator();

        while (var6.hasNext()) {
            EntityColumn column = (EntityColumn) var6.next();
            sql.append(" AND ").append(column.getColumnEqualsHolder(entityName));
        }

        if (useVersion) {
            sql.append(whereVersion(entityClass, entityName));
        }

        if (hasLogicDelete) {
            sql.append(SqlHelper.whereLogicDelete(entityClass, false));
        }

        sql.append("</where>");
        return sql.toString();
    }

    private String whereVersion(Class<?> entityClass, String entityName) {
        Set<EntityColumn> columnSet = EntityHelper.getColumns(entityClass);
        boolean hasVersion = false;
        String result = "";
        Iterator var4 = columnSet.iterator();

        while (var4.hasNext()) {
            EntityColumn column = (EntityColumn) var4.next();
            if (column.getEntityField().isAnnotationPresent(Version.class)) {
                if (hasVersion) {
                    throw new VersionException(entityClass.getCanonicalName() + " 中包含多个带有 @Version 注解的字段，一个类中只能存在一个带有 @Version 注解的字段!");
                }
                hasVersion = true;
                result = " AND " + column.getColumnEqualsHolder(entityName);
            }
        }

        return result;
    }
}
