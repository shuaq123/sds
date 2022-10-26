package dome.web.oem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dome.web.oem.model.adminRoleLink;
//import dome.web.oem.model.base.go.OldProductactivity;
import dome.web.oem.model.base.go.b2_productactivity;
import org.apache.ibatis.annotations.Select;

public interface Act extends BaseMapper<b2_productactivity> {

    @Select("select JoinProduct FROM b2_productactivity WHERE id = 2883")
    String seleArr();

}
