package dome.web.oem.model.base.go;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name="b2_productactivity")
public class b2_productactivity implements Serializable {
    @Id
    @TableId(value = "id",type = IdType.AUTO)
    @GeneratedValue(generator = "JDBC")
    @Column(name="id")//用来标识实体类中属性与数据库字段的对应关系
    private Integer id;
    @Column(name="JoinProduct")//用来标识实体类中属性与数据库字段的对应关系
    private String joinproduct;
}
