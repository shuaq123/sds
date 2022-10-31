package dome.web.oem.controlle.exam;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.base.uploadFiles;
import com.example.modle.ExamList;
import com.example.modle.studentExam;
import com.example.service.serviceDao.studentExamDao;
import dome.web.oem.model.base.ResultSet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Api("学员考试")
@RestController
@RequestMapping("/exam")
public class StudentExam {

    @Autowired
    private studentExamDao studentexamDao;


    @ApiOperation(value = "创建考试",httpMethod="POST")
    @PostMapping("/add")
    public ResultSet addExam(@ApiIgnore studentExam exam, HttpServletRequest request, MultipartFile uploadFile) throws IOException {


        if(StringUtils.isBlank(exam.getExamname())) return ResultSet.success("考试名称不能为空");
        if(StringUtils.isBlank(exam.getParticulars())) return ResultSet.success("详情不能为空");
        if(StringUtils.isBlank(exam.getStarttime())) return ResultSet.success("考试开始时间不能为空");
        if(StringUtils.isBlank(exam.getEndtime())) return ResultSet.success("考试结束时间不能为空");
        if(exam.getSimid() == null) return ResultSet.success("请选择要考试的试卷");
        if(exam.getIssroce() == null) return ResultSet.success("是否显示分值");

        String imgurl = new uploadFiles().uploadImg(uploadFile);
        if (imgurl.equals("上传失败")) return ResultSet.fail("上传失败");
        exam.setCovertitle(imgurl);

        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        exam.setCreatortime(df.format(date));


        return ResultSet.success(studentexamDao.examadd(exam));
    }
    @SneakyThrows
    @ApiOperation(value = "查询考试",httpMethod="GET")
    @GetMapping("/get")
    public ResultSet getExam(ExamList examlist,HttpServletRequest request) throws ParseException {



        return ResultSet.success(studentexamDao.examalist(examlist));
    }
}
