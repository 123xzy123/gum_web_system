package com.example.test.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Recharge {
    private int rechargeId; // 充值缴费流水号
    private String userId; // 用户id
    private BigDecimal amount; // 充值金额
    private String remark; // 备注(购买的是什么会员，月会员、季会员、年会员)
    private Timestamp rechargeTime; // 充值时间

    public int getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(int rechargeId) {
        this.rechargeId = rechargeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Timestamp rechargeTime) {
        this.rechargeTime = rechargeTime;
    }
}
