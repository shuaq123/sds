package dome.web.oem.controlle.userControllet;


import com.example.base.JwtUtils;
import dome.web.oem.Service.adminRoleService;
import dome.web.oem.Service.adminService;
import dome.web.oem.model.admin;
import dome.web.oem.model.adminRole;
import dome.web.oem.model.base.ResultSet;
import dome.web.oem.model.base.Users;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@Api("管理员")
@RestController
@RequestMapping("/admin")
public class adminControllet {

    @Autowired
    private adminService AdminService;

    @Autowired
    private adminRoleService AdminRoleService;


    @ApiOperation(value = "添加管理员",httpMethod="POST")
    @PostMapping("/add")
    public ResultSet addAdmin(@ApiIgnore admin a, HttpServletRequest request,@RequestParam("role") Integer roid) throws Exception {
        Claims cl = new JwtUtils().parseJwt(request.getHeader("token"));

        a.setAgencyid(cl.get("sub",String.class));

        return AdminService.addAadmin(a,roid);
    }
    @ApiOperation(value = "编辑管理员",httpMethod="POST")
    @PostMapping("/edit")
    public ResultSet editAdmin(@ApiIgnore @RequestParam("adminid") Integer adminid, HttpServletRequest request,admin a) throws Exception {
        return ResultSet.success(AdminService.editAdmin(adminid,a));
    }

    @ApiOperation(value = "添加角色",httpMethod="POST")
    @PostMapping("/add/role")
    public ResultSet addAdminRole(HttpServletRequest request,@ApiIgnore adminRole ro) throws Exception {

        return ResultSet.success(AdminRoleService.addRole(ro));
    }
    @ApiOperation(value = "添加角色",httpMethod="POST")
    @GetMapping("/get/admin")
    public ResultSet getAdmin(HttpServletRequest request,String name,Integer pageName,Integer pagesize) throws Exception {

        System.out.println(name);
        System.out.println(pageName);
        System.out.println(pagesize);

        return ResultSet.success(AdminService.getadminList(name,pageName,pagesize));
    }
    @GetMapping("/delAadmin")
    public ResultSet delAadmin(HttpServletRequest request,Integer adminid) throws Exception {
        return ResultSet.success(AdminService.delAdmin(adminid));

    }

}
