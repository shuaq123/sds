package dome.web.oem.Service.UsersGroup;

import dome.web.oem.Service.BaseService;
import dome.web.oem.model.base.usersgroup.userGroupModel;
import io.swagger.v3.oas.annotations.servers.Servers;

import java.util.List;

public interface userGroupServers extends BaseService<userGroupModel> {

    String addgroup(userGroupModel group);

    List<userGroupModel> getUserGroup();

}
