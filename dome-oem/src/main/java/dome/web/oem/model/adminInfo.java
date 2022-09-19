package dome.web.oem.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class adminInfo implements Serializable {

    private Integer adminId;
    private String adminName;

}
