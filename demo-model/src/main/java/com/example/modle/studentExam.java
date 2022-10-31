package com.example.modle;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name="student_exam")
public class studentExam implements Serializable {
    @Id
    @TableId(value = "examId",type = IdType.AUTO)
    @GeneratedValue(generator = "JDBC")
    @Column(name="examId")//用来标识实体类中属性与数据库字段的对应关系
    private Integer examid;
    @ApiModelProperty("封面名称")
    @Column(name="coverTitle")
    private String covertitle;

    @ApiModelProperty("考试名称")
    @Column(name="examName")
    private String examname;


    @ApiModelProperty("详情")
    @Column(name="particulars")
    private String particulars;
    @ApiModelProperty("考试开始时间")
    @Column(name="startTime")
    private String starttime;

    @ApiModelProperty("结束开始时间")
    @Column(name="endTime")
    private String endtime;

    @ApiModelProperty("实名登记 0关闭 1开启")
    @Column(name="realNameRegistration")
    private String realnameRegistration;

    @ApiModelProperty("试卷ID")
    @Column(name="simId")
    private Integer simid;

    @ApiModelProperty("0不显示题目 1显示题目")
    @Column(name="isSroce")
    private Integer issroce;

    @ApiModelProperty("考试时长")
    @Column(name="examTime")
    private String examtime;

    @ApiModelProperty("创建时间")
    @Column(name="creatorTime")
    private String creatortime;
}
