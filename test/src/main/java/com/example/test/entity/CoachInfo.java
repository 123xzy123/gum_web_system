package com.example.test.entity;

public class CoachInfo {
    private String coachId; // 教练id(微信号)
    private String nickName; // 教练昵称(微信昵称)
    private String phoneNumber; // 教练手机号
    private String fullName; // 教练真实姓名
    private String sex; // 教练性别
    private String introduction; // 教练简介
    private Integer star; // 教练星级

    public CoachInfo(String coachId, String nickName, String phoneNumber, String fullName, String sex, String introduction, Integer star) {
        this.coachId = coachId;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.sex = sex;
        this.introduction = introduction;
        this.star = star;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}
