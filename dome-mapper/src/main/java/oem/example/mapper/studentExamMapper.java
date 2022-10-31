package oem.example.mapper;//package oem.example.mapper;


import com.example.base.BaseMapper;
import com.example.modle.studentExam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


public interface studentExamMapper extends BaseMapper<studentExam> {


    List<studentExam> studentexamlist();

}
