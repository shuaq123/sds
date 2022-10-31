package com.example.base;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

@RegisterMapper
public interface MyBatchUpdateMapperr<T> {

    /**
     * 自定义，根据id批量修改 foreach 效率其实很可观.
     * 注意：
     * 1、该方法返回不了被修改成功的条数：0-》全部未修改成功 1—》全部修改成功or部分修改成功
     * 2、使用这个方法需要关闭防火墙（若有）-》spring.datasource.druid.filters中不能又wall参数
     * 3、sql url中需要有     &allowMultiQueries=true     参数
     *
     * @param var1
     * @return 0-》全部未修改成功 1—》全部修改成功or部分修改成功
     */
    @UpdateProvider(
            type = MyBatchUpdateProviderr.class,
            method = "dynamicSQL"
    )
    int updateBatchByPrimaryKeySelective(@Param("list") List<T> var1);

    /**
     * 方法作用同上(字段全量更新)
     * @param var1
     * @return
     */
    @UpdateProvider(
            type = MyBatchUpdateProviderr.class,
            method = "dynamicSQL"
    )
    int updateBatchByPrimaryKey(@Param("list") List<T> var1);
}
