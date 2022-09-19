package dome.web.oem.model.base.usersgroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="user_group")
public class userGroupModel {

    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "分组id")
    @Column(name="id")//用来标识实体类中属性与数据库字段的对应关系
    private Integer id;
    @ApiModelProperty(value = "分组名称")
    @Column(name="groupName")
    private String groupname;
    @ApiModelProperty(value = "层级")
    @Column(name="leve")
    private Integer leve;
    @ApiModelProperty(value = "父级ID")
    @Column(name="prant_id")
    private Integer prantid;
    @ApiModelProperty(value = "子目录")
    private List<userGroupModel> chilidenlist;
    @Transient
    @ApiModelProperty(value = "分组的学员数")
    private Integer StuCount;

}
