package dome.web.oem.Service;


import dome.web.oem.model.admin;
import dome.web.oem.model.base.ResultSet;
import dome.web.oem.model.base.Users;

import java.util.List;

public interface adminService extends BaseService<admin> {

    List list();
    ResultSet addAadmin(admin a,Integer roid);

    String editAdmin(Integer adminid,admin a);

    List<admin> getadminList(String name,Integer pagename,Integer pagesize);

}
