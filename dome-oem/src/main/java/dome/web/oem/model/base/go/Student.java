package dome.web.oem.model.base.go;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;


import dome.web.oem.model.base.Users;
import lombok.Getter;

/**
 * 学生读取类
 *
 * @author CL
 *
 */
public class Student extends AnalysisEventListener<Users> {

    @Getter
    private List<Users> studentList = new ArrayList<Users>();

    public Student() {
        super();
        studentList.clear();
    }

    /**
     * 每一条数据解析都会调用
     */
    @Override
    public void invoke(Users User, AnalysisContext context) {
        studentList.add(User);
    }

    /**
     * 所有数据解析完成都会调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        studentList.forEach(System.out::println);
    }

}