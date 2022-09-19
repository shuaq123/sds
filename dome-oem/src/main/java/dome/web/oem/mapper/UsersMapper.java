package dome.web.oem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import dome.web.oem.model.base.Users;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UsersMapper extends Mapper<Users> {

    List<Users> selectListOe(Map u);
//    List<Users> selectListOe(Users u,@Param("agencyid") int agencyid);

    int updateStatus(Users u );

    @Select("SELECT COUNT(1) FROM users WHERE group_id = #{groupid}")
    Integer seletcountgroup(Users u);

    Integer BatchEditor(Users u);


}




