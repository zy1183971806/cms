package com.example.shiordomo.sys.vo;

import com.example.shiordomo.sys.domain.Loginfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginfoVo extends Loginfo {
    public  static  final  Long  seriaVersionUID  =  1L;

    private Integer page = 1;
    private Integer limit = 10;
    //批量删除id数组
    private Integer[] ids;
    //日期格式转化
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date    startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date    endTime;
}
