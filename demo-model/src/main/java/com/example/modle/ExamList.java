package com.example.modle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;


@Data
public class ExamList implements Serializable {

    @ApiModelProperty("考试名称")
    private String examname;

    @ApiModelProperty("创建时间")
    private String creatortime;

    @ApiModelProperty("考试状态")
    private Integer examstate;

    @ApiModelProperty("未批阅")
    private Integer isnotread;

    @ApiModelProperty("已批阅")
    private Integer isread;

    @ApiModelProperty("考试id")
    private Integer id;

    private Integer pagenum;
    private Integer pagesize;
    private List<ExamList> examList;


}
