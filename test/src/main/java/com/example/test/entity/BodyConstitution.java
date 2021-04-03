package com.example.test.entity;

import java.sql.Timestamp;

public class BodyConstitution {  // 体质信息
    private int id; // 编号
    private String fullName; // 姓名
    private String userId; // 用户id(微信号)
    private int age; // 用户年龄
    private String sex; // 性别
    private int height; // 身高(cm)
    private float weight; // 体重(kg)
    private int vitalCapacity; // 肺活量(ml)
    private float bodyFatRate; // 体脂率
    private Timestamp updateTime; // 该体质信息测量的时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getVitalCapacity() {
        return vitalCapacity;
    }

    public void setVitalCapacity(int vitalCapacity) {
        this.vitalCapacity = vitalCapacity;
    }

    public float getBodyFatRate() {
        return bodyFatRate;
    }

    public void setBodyFatRate(float bodyFatRate) {
        this.bodyFatRate = bodyFatRate;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
