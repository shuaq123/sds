package dome.web.oem.ServiceImp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;


import com.example.base.JwtUtils;
import com.example.demo.model.base.data.PageInfo;

import com.github.pagehelper.PageHelper;
import dome.web.oem.Service.usersServers;
import dome.web.oem.mapper.UsersMapper;
import dome.web.oem.mapper.imgAllMapper;
import dome.web.oem.model.base.ResultSet;
import dome.web.oem.model.base.Users;
import dome.web.oem.model.base.imgAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class usersServiceImp implements usersServers {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private dome.web.oem.mapper.imgAllMapper imgAllMapper;


    @Override
    public String insertUser(Users u, MultipartFile uploadFile) throws Exception{
        // 获取上传的文件名
        if(uploadFile != null) {
            String fileName = uploadFile.getOriginalFilename();
            // 获得文件后缀名例如.png
//        String lastName = fileName.substring(fileName.lastIndexOf("."));
            File directory = new File("E:\\data", fileName);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            uploadFile.transferTo(directory);
            u.setProfilepicture("file:///E:/data/" + fileName);
        }
        Map<String,Object> l = new HashMap<>();
        l.put("agencyid",u.getAgencyid());
        l.put("name",u.getName());
        Users user1 = new Users();
        user1.setName(u.getName());
        System.out.println(user1);
        int s = usersMapper.selectCount(user1);
        if (s>0) return "用户名已存在";
        if(StringUtils.isNotBlank(u.getCreatedate())){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date= simpleDateFormat.parse(u.getCreatedate());
        }else {
            //获取当前时间
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            u.setCreatedate(df.format(date));
        }


        u.setPassword(DigestUtils.md5Hex(u.getPassword()));
        int code = usersMapper.insert(u);
        if (code > 0) return "添加成功";
        else {
            return "添加失败";
        }
    }

    @Override
    public String edituser(Integer k,Users u) {
        int a = usersMapper.updateByPrimaryKeySelective(u);
        if(a == 1) return "编辑成功";
        return "编辑失败";
    }

    @Override
    public List<Users> getUsersList(PageInfo page) {
        PageHelper.startPage(page.getPagenum(), page.getPagesize());
        List<Users> usersList = usersMapper.selectAll();
        List<Users> userli = usersList.stream().filter(u -> u.getName().equals("刘子健33") ).collect(Collectors.toList());

        return usersList;
    }

    @Override
    public String delUser(Integer userId) {
        int code = usersMapper.deleteByPrimaryKey(userId);
        if (code == 1) return "删除成功";
        else return  "删除失败";
    }

    @Override
    public String UploadFiles(MultipartFile[] uploadFile) {
        String path = this.getClass().getResource("").getPath();;
        String Path = path.replaceAll("ServiceImp","model/base/data");
        System.out.println(Path);
        for (MultipartFile f:uploadFile){
            // 获取上传的文件名
            String fileName = f.getOriginalFilename();
            System.out.println(fileName);
            // 获得文件后缀名例如.png
            String lastName = fileName.substring(fileName.lastIndexOf("."));
            File directory = new File("E:\\data",fileName);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            try {
                f.transferTo(directory);
                imgAll imgs = new imgAll();
                imgs.setImgname(fileName);
                imgs.setAddress("E:\\data"+fileName);
                int i = imgAllMapper.insert(imgs);
                System.out.println(i);

            }catch (Exception e){
                return "上传失败";
            }

        }



        return "上传成功";
    }

    @Override
    public ResultSet Login(Users u) {
        Map<String,Object>  map = new HashMap();
        map.put("name",u.getName());
        List<Users> us =usersMapper.selectListOe(map);
        if(us == null || us.size() == 0) return ResultSet.fail("用户不存在");
        if(!us.get(0).getPassword().equals(u.getPassword())) return ResultSet.success("密码错误");
        System.out.println(us.get(0));
        map.put("id",us.get(0).getId());
        String token = new JwtUtils().createJwt(String.valueOf(us.get(0).getId()),us.get(0).getName(),us.get(0).getAgencyid(),map);
        if(token != null){
            HashMap<String,String> list = new HashMap<String,String>();
            list.put("token",token);
            list.put("状态","登录成功");
            return ResultSet.success(list);
        }
        HashMap<String,String> list = new HashMap<String,String>();
        list.put("token",token);
        list.put("状态","失败");
        return ResultSet.success(list);
    }

    @Override
    public String BatchEditor(Users u) {

            Integer a = usersMapper.BatchEditor(u);
            System.out.println(a);
            if(a>0){
                return "编辑成功";
            }
        return "编辑失败";
    }


    @Override
    public int insert(Users entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteById(Users entity) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int delete(Wrapper<Users> queryWrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        return 0;
    }

    @Override
    public int updateById(Users entity) {
        return 0;
    }

    @Override
    public int update(Users entity, Wrapper<Users> updateWrapper) {
        return 0;
    }

    @Override
    public Users selectById(Serializable id) {
        return null;
    }

    @Override
    public List<Users> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<Users> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public Long selectCount(Wrapper<Users> queryWrapper) {
        return null;
    }

    @Override
    public List<Users> selectList(Wrapper<Users> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<Users> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<Users> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Users>> P selectPage(P page, Wrapper<Users> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<Users> queryWrapper) {
        return null;
    }
}









