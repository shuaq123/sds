package dome.web.oem.model;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ExcelIgnoreUnannotated
@Data
@Table(name="admin")

public class admin implements Serializable {
    @Id
    @TableId(value = "id",type = IdType.AUTO)
    @GeneratedValue(generator = "JDBC")
    @Column(name="id")//用来标识实体类中属性与数据库字段的对应关系
    private Integer id;
    @ApiModelProperty("管理员名称")
    @Column(name="username")
    private String username;

    @TableField("`Password`")
    @ApiModelProperty("管理员密码")
    @Column(name="Password")
    private String password;
    @ApiModelProperty("所属机构")
    @Column(name="Agencyid")
    private String agencyid;
    @ApiModelProperty("创建时间")
    @Column(name="CreateDate")
    private String createdate;
    @ApiModelProperty("状态")
    @TableField("`Status`")
    @Column(name="Status")
    private Integer status;
    @Column(name="moblie")
    private String Moblie;
    @Column(name="isdefauif")
    private Integer isdefauif;
    //角色
    @TableField(exist = false)
    private List<String> role;

}
