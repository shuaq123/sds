package dome.web.oem.model.base;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ExcelIgnoreUnannotated
@Data
@Table(name="users")
//@Tablename("bg_users")
public class Users implements Serializable {

    @Id
    @TableId(value = "id",type = IdType.AUTO)
    @GeneratedValue(generator = "JDBC")
//    @ExcelIgnore //导出时忽略该字段
    @Column(name="id")//用来标识实体类中属性与数据库字段的对应关系
    private Integer id;
    @ExcelProperty(value = "用户名" ,index = 0)
    @Column(name="name")
    private String name;
    @ExcelProperty(value = "密码",index = 1)
    @Column(name="Password")
    private String password;
    @ExcelIgnore //导出时忽略该字段
    @Column(name="AgencyId")
    private String agencyid;
    @ExcelIgnore //导出时忽略该字段
    @Column(name="CreateDate")
    private String createdate;
    @ExcelIgnore //导出时忽略该字段
    @Column(name="Remark")
    private String remark;
    @ExcelIgnore //导出时忽略该字段
    @Column(name="age")
    private String age;
    @ExcelIgnore //导出时忽略该字段
    @Column(name="profilepicture")
    private String profilepicture;
    @ExcelIgnore //导出时忽略该字段
    @Column(name="group_id")
    private Integer groupid;
    private List<Integer> userIdList;

}
