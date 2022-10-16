package dome.web.oem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dome.web.oem.model.admin;

import java.util.List;


public interface adminMappere extends BaseMapper<admin> {

    List<admin> seleAdminList(String name);

}
