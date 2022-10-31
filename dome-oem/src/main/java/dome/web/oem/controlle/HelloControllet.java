//package dome.web.oem.controlle;
//
//import dome.web.oem.Service.adminService;
//import dome.web.oem.controlle.rides.RedisService;
//import dome.web.oem.controlle.rides.RedisUtil;
//import dome.web.oem.mapper.adminMappere;
//import dome.web.oem.mapperLocal.Act;
//import dome.web.oem.model.adminInfo;
//import dome.web.oem.model.base.ResultSet;
////import dome.web.oem.model.base.go.OldProductactivity;
//import dome.web.oem.model.base.go.b2_productactivity;
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import java.sql.SQLException;
//import java.util.List;
//
//@Api("测试接口")
//@RestController
//@RequestMapping("/api")
//public class HelloControllet {
//
//    /*
//    @RestController 标志这是一个控制器
//    @ResponseBody 会包装返回结果
//    @RequestMapping 是匹配前台请求路径的
//     */
//    @Autowired
//    private adminService AdminService;
//    @Autowired
//    private Act actMapper;
//    @Autowired
//    private adminMappere AdminMappere;
//    @Autowired
//    private RedisUtil redisUtil;
//
//    @ResponseBody
//    @RequestMapping("/hello")
//    public List hello(){
//        return AdminService.list();
//    }
//
//    @GetMapping("/hello2/{adminName}")
//    public ResultSet adminlist(adminInfo admin, HttpServletRequest request, @PathVariable("adminName") String adminName){
//        System.out.println(request.getHeader("token"));
//        System.out.println(adminName);
//        System.out.println(admin.getAdminName());
//
//        return ResultSet.success(AdminService.list());
//    }
//
//    @GetMapping("/act")
//    public ResultSet adminlist(HttpServletRequest request, b2_productactivity act) throws SQLException {
//
////        b2_productactivity as = actMapper.selectByPrimaryKey("2883");
////
////        List<String> arr1 = JSONArray.parseArray(as.getJoinproduct(),String.class);
////
////        List<String> list1 = new ArrayList<>();
////
////        for(String J:arr1){
////
////            list1.add(JSON.parseObject(J).get("productId").toString());
////        }
////
////        admin AdminInfo = new admin();
////        List<admin> adminList = AdminMappere.selectAll();
////        System.out.println(adminList);
////        redisUtil.set("agenId","asdasdadasdasd");
////        String a = (String) redisUtil.get("liu");
////        redisUtil.expire("liu",10);
////        long c = redisUtil.getExpire("liu");
//        boolean e = redisUtil.expire("agenId", 10);
//        long d = redisUtil.getExpire("agenId");
//
//        if (e) {
//            System.out.println(d);
//            if (d < -1) {
//                return ResultSet.success("缓存过期");
//            }
//        } else {
//
//            return ResultSet.success(d);
//        }
//
//        return ResultSet.success("1123");
//
//
//    }
//}
