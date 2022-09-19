package dome.web.oem.ServiceImp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

//import com.example.demo.model.base.ResultSet;
import dome.web.oem.Service.adminService;
import dome.web.oem.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//import java.sql.ResultSet;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;



@Service
public class adminServiceImp implements adminService {


    @Autowired
    private AdminMapper adminMapper;


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
    public int insert(Object entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteById(Object entity) {
        return 0;
    }

    @Override
    public int delete(Wrapper queryWrapper) {
        return 0;
    }

    @Override
    public int updateById(Object entity) {
        return 0;
    }

    @Override
    public int update(Object entity, Wrapper updateWrapper) {
        return 0;
    }

    @Override
    public Object selectById(Serializable id) {
        return null;
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
