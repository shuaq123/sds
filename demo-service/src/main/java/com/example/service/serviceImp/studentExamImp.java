package com.example.service.serviceImp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.modle.ExamList;
import com.example.modle.studentExam;
import com.example.service.serviceDao.studentExamDao;


import com.github.pagehelper.PageHelper;
import oem.example.mapper.studentExamMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class studentExamImp implements studentExamDao {


    @Autowired
    private studentExamMapper studentexamMapper;


    @Override
    public String examadd(studentExam exam) {

        int code = studentexamMapper.insertSelective(exam);
        if(code>0) return "添加成功";

        System.out.println(exam);

        return "添加失败";
    }

    @Override
    public List<ExamList> examalist(ExamList examlist) throws ParseException {
        if (examlist.getPagenum() != null && examlist.getPagesize() != null){

            PageHelper.startPage(examlist.getPagenum(),examlist.getPagesize());
            List<studentExam> examArr = studentexamMapper.studentexamlist();
            ExamList examInfo = new ExamList();
            List<ExamList> examlistarr = new ArrayList<>();
            for (studentExam e:examArr){
                examInfo.setExamname(e.getExamname());
                examInfo.setCreatortime(e.getCreatortime());
                examInfo.setIsnotread(0);
                examInfo.setIsread(0);
                //获取当前时间
                Date date=new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentTime = df.format(date);
                System.out.println("当前时间"+currentTime);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long curren = simpleDateFormat.parse(currentTime).getTime();
//                开始时间
                String startTime = e.getStarttime();
                long getstarttime = simpleDateFormat.parse(startTime).getTime();
//                结束时间
                String endTime = e.getEndtime();
                long endtime = simpleDateFormat.parse(endTime).getTime();
                if(getstarttime <= curren && curren <= endtime){
                    examInfo.setExamstate(1);
                }else {
                    examInfo.setExamstate(0);
                }
                examlistarr.add(examInfo);


            }

            return examlistarr;

        }



        return null;
    }


    @Override
    public int insert(Object entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteById(Object entity) {
        return 0;
    }

    @Override
    public int delete(Wrapper queryWrapper) {
        return 0;
    }

    @Override
    public int updateById(Object entity) {
        return 0;
    }

    @Override
    public int update(Object entity, Wrapper updateWrapper) {
        return 0;
    }

    @Override
    public Object selectById(Serializable id) {
        return null;
    }

    @Override
    public Long selectCount(Wrapper queryWrapper) {
        return null;
    }

    @Override
    public List selectList(Wrapper queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper queryWrapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> selectMapsPage(IPage page, Wrapper queryWrapper) {
        return null;
    }

    @Override
    public IPage selectPage(IPage page, Wrapper queryWrapper) {
        return null;
    }

    @Override
    public List selectByMap(Map columnMap) {
        return null;
    }

    @Override
    public List selectBatchIds(Collection idList) {
        return null;
    }

    @Override
    public int deleteBatchIds(Collection idList) {
        return 0;
    }

    @Override
    public int deleteByMap(Map columnMap) {
        return 0;
    }
}
