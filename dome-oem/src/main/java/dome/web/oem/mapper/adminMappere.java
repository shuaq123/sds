package dome.web.oem.mapper;


import dome.web.oem.model.admin;
import dome.web.oem.model.base.data.BaseMapper;

import java.util.List;


public interface adminMappere extends BaseMapper<admin> {

    List<admin> seleAdminList(String name);

}
