package dome.web.oem.controlle;
import dome.web.oem.Service.adminService;
import dome.web.oem.model.adminInfo;
import dome.web.oem.model.base.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloControllet {

    /*
    @RestController 标志这是一个控制器
    @ResponseBody 会包装返回结果
    @RequestMapping 是匹配前台请求路径的
     */
    @Autowired
    private adminService AdminService;


    @ResponseBody
    @RequestMapping("/hello")
    public List hello(){
        return AdminService.list();
    }

    @GetMapping("/hello2/{adminName}")
    public ResultSet adminlist(adminInfo admin, HttpServletRequest request, @PathVariable("adminName") String adminName){
        System.out.println(request.getHeader("token"));
        System.out.println(adminName);
        System.out.println(admin.getAdminName());

        return ResultSet.success(AdminService.list());
    }

}
