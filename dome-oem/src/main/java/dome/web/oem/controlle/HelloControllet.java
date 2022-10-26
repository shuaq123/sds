package dome.web.oem.controlle;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dome.web.oem.Service.adminService;
import dome.web.oem.mapper.Act;
import dome.web.oem.model.adminInfo;
import dome.web.oem.model.base.ResultSet;
//import dome.web.oem.model.base.go.OldProductactivity;
import dome.web.oem.model.base.go.b2_productactivity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Api(description = "用户增删改查接口")
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
    @Autowired
    private Act actMapper;
    @Autowired
    private DataSource dataSource;


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

    @GetMapping("/act")
    public ResultSet adminlist(HttpServletRequest request, b2_productactivity act) throws SQLException {

        b2_productactivity as = actMapper.selectById(2883);

        List<String> arr1 = JSONArray.parseArray(as.getJoinproduct(),String.class);

        List<String> list1 = new ArrayList<>();

        for(String J:arr1){

            list1.add(JSON.parseObject(J).get("productId").toString());
        }
        System.out.println(list1);
        return ResultSet.success(list1);
    }

}
