package com.example.test.entity;

import java.sql.Timestamp;

public class PunchClock { // 去健身房打卡
    private int punchId; // 编号
    private String userId; // 用户编号
    private String fullName; // 用户姓名
    private Timestamp punchTime; // 打卡时间
    private String punchPosition; // 打卡地点

    public int getPunchId() {
        return punchId;
    }

    public void setPunchId(int punchId) {
        this.punchId = punchId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Timestamp getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(Timestamp punchTime) {
        this.punchTime = punchTime;
    }

    public String getPunchPosition() {
        return punchPosition;
    }

    public void setPunchPosition(String punchPosition) {
        this.punchPosition = punchPosition;
    }
}
