package dome.web.oem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="admin_role")
public class adminRole implements Serializable {
    @Id
    @TableId(value = "roleId",type = IdType.AUTO)
    @GeneratedValue(generator = "JDBC")
    @Column(name="roleId")//用来标识实体类中属性与数据库字段的对应关系
    private Integer roleid;
    @ApiModelProperty("管理员名称")
    @Column(name="roleName")
    private String rolename;
}
