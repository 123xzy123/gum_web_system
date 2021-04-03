package com.example.test.entity;

import java.sql.Timestamp;

public class OpenCourseEnroll { // 公开课预约
    private int courseEnrollId; // 公开课预约流水号
    private int courseId; // 公开课程编号
    private String wxId; // 预约者的微信号
    private String fullName; // 预约顾客的姓名
    private String phoneNumber; // 预约顾客的手机号
    private Timestamp enrollTime;  // 预约记录生成的时间


}
