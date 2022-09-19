package dome.web.oem.ServiceImp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;




import dome.web.oem.Service.UsersGroup.userGroupServers;
import dome.web.oem.mapper.UsersMapper;
import dome.web.oem.mapper.usergroupDao;
import dome.web.oem.model.base.Users;
import dome.web.oem.model.base.usersgroup.userGroupModel;
import io.swagger.v3.oas.annotations.servers.Servers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class userGroupServersImp implements userGroupServers {

    @Autowired
    private usergroupDao UsergroupDao;
    @Autowired
    private UsersMapper Usersmapper;

    @Override
    public String addgroup(userGroupModel group) {

        int a = UsergroupDao.insertSelective(group);
        if (a==1) return "添加分类成功";
        return "添加失败";
    }

    @Override
    public List<userGroupModel> getUserGroup() {

        userGroupModel Ug = new userGroupModel();
        Ug.setLeve(1);
        List<userGroupModel> usergroup = UsergroupDao.select(Ug);
        ArrayList<userGroupModel> list = new ArrayList<>();
        for(userGroupModel u:usergroup){
            System.out.println(u.getId());
            userGroupModel Ug2 = new userGroupModel();
            Ug2.setPrantid(u.getId());
            List<userGroupModel> usergroup2 = UsergroupDao.select(Ug2);
            u.setChilidenlist(usergroup2);
            for (userGroupModel u2:usergroup2){
                userGroupModel Ug3 = new userGroupModel();
                Ug3.setPrantid(u2.getId());
                List<userGroupModel> usergroup3 = UsergroupDao.select(Ug3);
//                List<Integer> uslist = usergroup3.stream().map(userGroupModel::getId).collect(Collectors.toList());
                for (userGroupModel ug :usergroup3){
                    Users us = new Users();
                    us.setGroupid(ug.getId());
                    Integer num = Usersmapper.seletcountgroup(us) == null?0:Usersmapper.seletcountgroup(us);
                    ug.setStuCount(num);
                }
                u2.setChilidenlist(usergroup3);
            }

        list.add(u);
        }

        return list;
    }

    @Override
    public int insert(userGroupModel entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteById(userGroupModel entity) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int delete(Wrapper<userGroupModel> queryWrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        return 0;
    }

    @Override
    public int updateById(userGroupModel entity) {
        return 0;
    }

    @Override
    public int update(userGroupModel entity, Wrapper<userGroupModel> updateWrapper) {
        return 0;
    }

    @Override
    public userGroupModel selectById(Serializable id) {
        return null;
    }

    @Override
    public List<userGroupModel> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<userGroupModel> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public Long selectCount(Wrapper<userGroupModel> queryWrapper) {
        return null;
    }

    @Override
    public List<userGroupModel> selectList(Wrapper<userGroupModel> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<userGroupModel> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<userGroupModel> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<userGroupModel>> P selectPage(P page, Wrapper<userGroupModel> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<userGroupModel> queryWrapper) {
        return null;
    }
}
