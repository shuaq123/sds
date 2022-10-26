package dome.web.oem.ServiceImp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

//import com.example.demo.model.base.ResultSet;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.base.JwtUtils;
import com.github.pagehelper.PageHelper;
import dome.web.oem.Service.adminService;
import dome.web.oem.mapper.AdminMapper;
import dome.web.oem.mapper.adminMappere;
import dome.web.oem.mapper.adminRoleLinkMapper;
import dome.web.oem.mapper.adminRoleMapper;
import dome.web.oem.model.admin;
import dome.web.oem.model.adminRole;
import dome.web.oem.model.adminRoleLink;
import dome.web.oem.model.base.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//import java.sql.ResultSet;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class adminServiceImp implements adminService {


    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private adminMappere AdminMappere;
    @Autowired
    private adminRoleLinkMapper AdminRoleLinkMapper;
    @Autowired
    private adminRoleMapper AdminRoleMapper;

    @Override
    public List list() {
        List<Map<String, Object>> a = adminMapper.adminlist();
//        System.out.println(a.get(1).values()+"read");
//        System.out.println(a.get(1).keySet()+"read");
//        System.out.println(a.get(1).get("VerifyTimes"));
        for (Map<String, Object> e : a){
            System.out.println(e);
        }
        return a;
    }

    @Override
    public ResultSet addAadmin(admin a,Integer roid) {

        if(StringUtils.isBlank(a.getAgencyid())) return ResultSet.fail("缺少机构id");
        if(StringUtils.isBlank(a.getUsername())) return ResultSet.fail("请输入用户名");
        if(StringUtils.isBlank(a.getPassword())) return ResultSet.fail("请输入密码");
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        a.setCreatedate(dateFormat.format(date));
        a.setIsdefauif(0);
        a.setStatus(1);
        QueryWrapper<admin> userWrapper = new QueryWrapper<>();
        userWrapper.eq("userName", a.getUsername());
        List<admin> countAdmin = AdminMappere.selectList(userWrapper);
        if(countAdmin.size()>0) return ResultSet.fail("用户名已存在");
        QueryWrapper<admin> moblieIs = new QueryWrapper<>();
        moblieIs.eq("moblie", a.getMoblie());
        List<admin> user = AdminMappere.selectList(moblieIs);
        if(user.size()>0) return ResultSet.fail("手机号已存在");
        int A = AdminMappere.insert(a);
        Integer adminid = a.getId();
        if(A>0){
            adminRoleLink role = new adminRoleLink();
            role.setAdminid(adminid);
            role.setRoleid(roid);
            int code = AdminRoleLinkMapper.insert(role);
            if(code>0) return ResultSet.success("添加成功");

        }




        return ResultSet.fail("添加失败");
    }

    @Override
    public String editAdmin(Integer adminid,admin a) {

        admin Admin = AdminMappere.selectById(adminid);
        a.setId(adminid);

        int code = AdminMappere.updateById(a);

        if (code>0) return "编辑成功";

        return "编辑失败";
    }

    @Override
    public List<admin> getadminList(String name,Integer pagename,Integer pagesize) {

        PageHelper.startPage(pagename, pagesize);
        List<admin> adminlists = AdminMappere.seleAdminList(name);
        for (admin Am:adminlists){
            List<String> list1 = new ArrayList<>();
            QueryWrapper<adminRoleLink> roleL = new QueryWrapper<>();
            roleL.eq("adminId", Am.getId());
            List<adminRoleLink> roleList = AdminRoleLinkMapper.selectList(roleL);
            List<Integer> roleArr = roleList.stream().map(s->s.getRoleid()).collect(Collectors.toList());
            for (Integer r:roleArr){
                adminRole rl = AdminRoleMapper.selectById(r);
                list1.add(rl.getRolename());
            }
            Am.setRole(list1);

        }
        return adminlists;
    }

    @Override
    public String delAdmin(Integer adminid) {
        int a= AdminMappere.deleteById(adminid);

        if (a>0){
            QueryWrapper<adminRoleLink> delt = new QueryWrapper<>();
            delt.eq("adminId",adminid);
            AdminRoleLinkMapper.delete(delt);

            return "删除成功";
        }
        return "删除失败";
    }


    @Override
    public int insert(admin entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteById(admin entity) {
        return 0;
    }

    @Override
    public int updateById(admin entity) {
        return 0;
    }

    @Override
    public int update(admin entity, Wrapper<admin> updateWrapper) {
        return 0;
    }

    @Override
    public admin selectById(Serializable id) {
        return null;
    }


    @Override
    public int delete(Wrapper queryWrapper) {
        return 0;
    }





    @Override
    public Long selectCount(Wrapper queryWrapper) {
        return null;
    }

    @Override
    public List selectList(Wrapper queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper queryWrapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> selectMapsPage(IPage page, Wrapper queryWrapper) {
        return null;
    }

    @Override
    public IPage selectPage(IPage page, Wrapper queryWrapper) {
        return null;
    }

    @Override
    public List selectByMap(Map columnMap) {
        return null;
    }

    @Override
    public List selectBatchIds(Collection idList) {
        return null;
    }

    @Override
    public int deleteBatchIds(Collection idList) {
        return 0;
    }

    @Override
    public int deleteByMap(Map columnMap) {
        return 0;
    }
}
