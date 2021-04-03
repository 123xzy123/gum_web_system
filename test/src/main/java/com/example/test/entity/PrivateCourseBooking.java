package com.example.test.entity;

import java.sql.Timestamp;

public class PrivateCourseBooking {
    private Integer bookingId; // 私教课程预约流水号
    private String userId; // 用户编号
    private String coachId; // 教练id
    private Timestamp beginTime; // 私教课开始时间
    private Timestamp endTime; // 私教课结束时间
    private String remark; // 备注
    private String userName; // 用户姓名
    private String coachName; // 教练姓名
    PrivateCourseBooking() {}

    public PrivateCourseBooking(Integer bookingId, String userId, String coachId, Timestamp beginTime, Timestamp endTime, String remark) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.coachId = coachId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.remark = remark;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
