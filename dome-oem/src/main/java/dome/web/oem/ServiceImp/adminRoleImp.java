//package dome.web.oem.ServiceImp;
//
//import com.baomidou.mybatisplus.core.conditions.Wrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import dome.web.oem.Service.adminRoleService;
//import dome.web.oem.mapper.adminMappere;
//import dome.web.oem.mapper.adminRoleMapper;
//import dome.web.oem.model.admin;
//import dome.web.oem.model.adminRole;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class adminRoleImp implements adminRoleService {
//
//    @Autowired
//    private adminRoleMapper AdminRoleMapper;
//
//    @Override
//    public String addRole(adminRole ro) {
//
//        QueryWrapper<adminRole> adminrole = new QueryWrapper<>();
//        adminrole.eq("rolename", ro.getRolename());
//        adminRole e = new adminRole();
//        e.setRolename(ro.getRolename());
//        List<adminRole> B = AdminRoleMapper.select(e);
//        if(B.size() > 0) return "角色名已存在";
//        int a =  AdminRoleMapper.insert(ro);
//        if(a>0) return "添加成功";
//        return "添加失败";
//    }
//
//    @Override
//    public int insert(Object entity) {
//        return 0;
//    }
//
//    @Override
//    public int deleteById(Serializable id) {
//        return 0;
//    }
//
//    @Override
//    public int deleteById(Object entity) {
//        return 0;
//    }
//
//    @Override
//    public int delete(Wrapper queryWrapper) {
//        return 0;
//    }
//
//    @Override
//    public int updateById(Object entity) {
//        return 0;
//    }
//
//    @Override
//    public int update(Object entity, Wrapper updateWrapper) {
//        return 0;
//    }
//
//    @Override
//    public Object selectById(Serializable id) {
//        return null;
//    }
//
//    @Override
//    public Long selectCount(Wrapper queryWrapper) {
//        return null;
//    }
//
//    @Override
//    public List selectList(Wrapper queryWrapper) {
//        return null;
//    }
//
//    @Override
//    public List<Map<String, Object>> selectMaps(Wrapper queryWrapper) {
//        return null;
//    }
//
//    @Override
//    public List<Object> selectObjs(Wrapper queryWrapper) {
//        return null;
//    }
//
//    @Override
//    public IPage<Map<String, Object>> selectMapsPage(IPage page, Wrapper queryWrapper) {
//        return null;
//    }
//
//    @Override
//    public IPage selectPage(IPage page, Wrapper queryWrapper) {
//        return null;
//    }
//
//    @Override
//    public List selectByMap(Map columnMap) {
//        return null;
//    }
//
//    @Override
//    public List selectBatchIds(Collection idList) {
//        return null;
//    }
//
//    @Override
//    public int deleteBatchIds(Collection idList) {
//        return 0;
//    }
//
//    @Override
//    public int deleteByMap(Map columnMap) {
//        return 0;
//    }
//}
