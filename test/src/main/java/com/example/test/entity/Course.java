package com.example.test.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Course {
    private int id; // 课程编号
    private String teacherName; // 课程主讲老师姓名
    private String briefIntroduction; // 课程简介(内容)
    private Timestamp beginTime;  // 课程开始时间
    private Timestamp endTime; // 课程结束时间
    private Integer capacity; // 课程最大人数(容量)
    private BigDecimal price; // 课程价格
    public Course() {}
    public Course(int id, String teacherName, String briefIntroduction, Timestamp beginTime, Timestamp endTime, Integer capacity, BigDecimal price) {
        this.id = id;
        this.teacherName = teacherName;
        this.briefIntroduction = briefIntroduction;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
