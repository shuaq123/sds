package dome.web.oem.controlle.userControllet;

import cn.hutool.core.io.resource.ClassPathResource;

import cn.hutool.core.io.resource.Resource;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;



import com.example.demo.model.base.data.PageInfo;

import dome.web.oem.Service.usersServers;
import dome.web.oem.mapper.UsersMapper;
import dome.web.oem.model.base.ResultSet;
import dome.web.oem.model.base.Users;
import dome.web.oem.model.base.go.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Api("用户")
@RestController
@RequestMapping("/api")
public class UserInfo {

    @Autowired
    private usersServers UsersServer;
    @Autowired
    private UsersMapper Usersmapper;




    @ApiOperation(value = "添加用户",httpMethod="POST")
    @PostMapping("/register/users")
    public ResultSet InsUsers(@ApiIgnore Users u, HttpServletRequest request, MultipartFile uploadFile) throws Exception {
        if(StringUtils.isBlank(u.getName())) return ResultSet.fail("名称不能为空");
        if(StringUtils.isBlank(u.getPassword())) return ResultSet.fail("密码不能为空");
        if (u.getName().length() > 10) return ResultSet.fail("字符长度不能大于10");
        return ResultSet.success(UsersServer.insertUser(u,uploadFile));
    }
    @ApiOperation(value = "编辑用户",httpMethod="POST")
    @PostMapping("/edit/users")
    public ResultSet EditUsers(Integer userid,HttpServletRequest request, Users u){
        return ResultSet.success(UsersServer.edituser(userid,u));
    }

    @ApiOperation(value = "用户列表",httpMethod="GET")
    @GetMapping("/get/users")
    public ResultSet GetUsers(HttpServletRequest request, PageInfo page){

        return ResultSet.success(UsersServer.getUsersList(page));
    }

    @ApiOperation(value = "上传图片",httpMethod="POST")
    @PostMapping("/uploadFile")
//    上传图片
    public ResultSet uploadFile(MultipartFile[] uploadFile,HttpServletRequest request) {
        System.out.println(uploadFile);
        return ResultSet.success(UsersServer.UploadFiles(uploadFile));

    }

    @ApiOperation(value = "删除用户",httpMethod="GET")
    @GetMapping("/del/users/{userId}")
    public ResultSet DelUsers(HttpServletRequest request,@PathVariable("userId") Integer userId)
    {
        System.out.println(userId);
        return ResultSet.success(UsersServer.delUser(userId));
    }

    @ApiOperation(value = "导入用户",httpMethod="GET")
    @PostMapping("/ImportUser")
    public ResultSet ImportUser(MultipartFile file) throws IOException {
        Student studentListener = new Student();
        Integer Line = 0;
        EasyExcel.read(file.getInputStream(), Users.class, studentListener).sheet().doRead();

        if(studentListener.getStudentList().size()>0){
            for (Users uk:studentListener.getStudentList()){
                Line += 1;
                if(StringUtils.isBlank(uk.getPassword())) continue;
                Users ue = new Users();
                ue.setName(uk.getName());
                ue.setPassword(uk.getPassword());
                int a = Usersmapper.insertSelective(ue);
                System.out.println("这是表第"+Line+"行数据");
            }
        }
        return ResultSet.success("导入成功") ;

    }
    @ApiOperation(value = "登录",httpMethod="POST")
    @PostMapping("/login")
//    上传图片
    public ResultSet login(Users u,HttpServletRequest request) {
        if(StringUtils.isBlank(u.getName())) return ResultSet.fail("用户名不能为空");
        if(StringUtils.isBlank(u.getPassword())) return ResultSet.fail("密码不能为空");
        return UsersServer.Login(u);

    }
    @ResponseBody
    @PostMapping("/export/file")
//   导出学员
    public ResultSet exportFile(PageInfo p, HttpServletResponse response) throws IOException, URISyntaxException {
        p.setPagenum(1);
        p.setPagesize(10);
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(date));
        String data1 =df.format(date).replaceAll(" ","-").replaceAll(":","-");
        String E = "D:\\模块数据"+data1+".xls";
        System.out.println(E);
//        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/模板.xls");
        File file = new File(E);
        file.createNewFile();
        System.out.println(file);
        System.out.println("-----------------------");
        List<Users> usersList = UsersServer.getUsersList(p);
        for (Users us:usersList){
            System.out.println(us);
        }
        System.out.println("-----------------------");
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("统计信息", "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName+ ".xls");

        //新建ExcelWriter
        ExcelWriter excelWriter = EasyExcel.write(file).build();
        //获取archSheet对象
        WriteSheet archSheet = EasyExcel.writerSheet(0, "农合信息档案").head(Users.class).build();
        //获取参合人员信息,向archSheet写入数据
        excelWriter.write(usersList, archSheet);
//
        //关闭流
        excelWriter.finish();
        HashMap<String,String> map =  new HashMap<>();
        map.put("url",E);
        map.put("mes","导出成功");
        return ResultSet.success(map);


    }

    @ApiOperation(value = "批量编辑",httpMethod="GET")
    @GetMapping("/bulkEditor")
//    批量编辑
    public ResultSet bulkEditor(Users u,HttpServletRequest request) throws ParseException {


        //当前时间挫
        long startDate = System.currentTimeMillis();
        System.out.println(startDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long endDate = simpleDateFormat.parse("2024-09-25 15:00:00").getTime();
        //时间戳转换成天数
        System.out.println((endDate-startDate)/ (1000 * 60 * 60 * 24));
        //当前时间毫秒的时间戳转换为日期
        Date millisecondDate= new Date(endDate-startDate);
        System.out.printf("%tF %<tT%n",millisecondDate);
        if(u.getUserIdList().size()==0) return ResultSet.success("请选择要用户");

        return ResultSet.success(UsersServer.BatchEditor(u));

    }


}
