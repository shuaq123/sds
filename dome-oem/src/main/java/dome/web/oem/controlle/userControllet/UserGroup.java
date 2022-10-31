//package dome.web.oem.controlle.userControllet;
//
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
////import com.example.base.HttpUtils;
//
//
//import com.example.base.JwtUtils;
//import com.example.base.LoginCheck;
//import dome.web.oem.Service.UsersGroup.userGroupServers;
//import dome.web.oem.model.base.ResultSet;
//import dome.web.oem.model.base.usersgroup.userGroupModel;
//import io.jsonwebtoken.Claims;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
//
//
//
//@RestController
//@RequestMapping("/api")
//public class UserGroup {
//
//    @Autowired
//    private userGroupServers userGroupServer;
//    @ApiOperation(value = "添加用户分组",httpMethod="POST")
//    @PostMapping("/add/usergroup")
//    public ResultSet AddUserGroup(HttpServletRequest request, userGroupModel group){
//        if(StringUtils.isBlank(group.getGroupname())) return ResultSet.fail("分组名称不能为空");
//        return ResultSet.success(userGroupServer.addgroup(group));
//    }
//    @GetMapping("/get/usergroup")
//    public ResultSet getUserGroup(HttpServletRequest request){
//
//        return ResultSet.success(userGroupServer.getUserGroup());
//    }
//}
