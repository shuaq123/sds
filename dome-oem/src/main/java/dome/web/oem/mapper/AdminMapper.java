package dome.web.oem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import dome.web.oem.model.base.Users;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
@Mapper
public interface AdminMapper extends BaseMapper<Users> {

    @MapKey("id")
    List<Map<String, Object>> adminlist();

}
