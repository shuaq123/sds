package com.example.service.serviceDao;

import com.example.modle.ExamList;
import com.example.modle.studentExam;
import com.example.service.BaseService;

import java.text.ParseException;
import java.util.List;


public interface studentExamDao extends BaseService {


    String examadd(studentExam exam);

    List<ExamList> examalist(ExamList examlist) throws ParseException;




}
