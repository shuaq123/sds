package dome.web.oem.model.base;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Table(name="img_gather")
public class imgAll implements Serializable {
    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @GeneratedValue(generator = "JDBC")
    @Column(name="id")//用来标识实体类中属性与数据库字段的对应关系
    private Integer id;

    @Column(name="imgName")
    private String imgname;

    @Column(name="address")
    private String address;

}
