package dome.web.oem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="admin_role_link")
public class adminRoleLink {
    @Id
    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty("管理员id")
    @GeneratedValue(generator = "JDBC")
    @Column(name="id")//用来标识实体类中属性与数据库字段的对应关系
    private Integer id;
    @Column(name="adminId")//用来标识实体类中属性与数据库字段的对应关系
    private Integer adminid;

    @Column(name="roleId")
    private Integer roleid;
}
