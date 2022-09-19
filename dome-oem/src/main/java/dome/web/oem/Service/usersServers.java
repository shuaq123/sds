package dome.web.oem.Service;

import com.example.demo.model.base.data.PageInfo;
import dome.web.oem.model.base.ResultSet;
import dome.web.oem.model.base.Users;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface usersServers extends BaseService<Users> {
    //添加用户
    String insertUser(Users u,MultipartFile uploadFile ) throws Exception;
    String edituser(Integer k,Users u);
    List<Users> getUsersList(PageInfo page);
    String delUser(Integer userId);
//    上传文件
    String UploadFiles(MultipartFile[] uploadFile);
//    用户登录
    ResultSet Login(Users u);

    String BatchEditor(Users u);
}
