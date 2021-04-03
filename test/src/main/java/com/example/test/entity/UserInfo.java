package com.example.test.entity;


import java.sql.Timestamp;

public class UserInfo {
    private String userId; // 用户账号(微信号)
    private String nickName; // 用户昵称(微信昵称)
    private String phoneNumber; // 用户手机号
    private String fullName; // 用户真实姓名
    private String sex; // 用户性别
    private Integer membershipLevel; // 用户会员等级, 0为非会员
    private Timestamp membershipDeadline; // 用户会员到期时间
    public UserInfo() {}
    public UserInfo(String userId, String nickName, String phoneNumber, String fullName, String sex, Integer membershipLevel, Timestamp membershipDeadline) {
        this.userId = userId;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.sex = sex;
        this.membershipLevel = membershipLevel;
        this.membershipDeadline = membershipDeadline;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Integer getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(Integer membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public Timestamp getMembershipDeadline() {
        return membershipDeadline;
    }

    public void setMembershipDeadline(Timestamp membershipDeadline) {
        this.membershipDeadline = membershipDeadline;
    }
}
