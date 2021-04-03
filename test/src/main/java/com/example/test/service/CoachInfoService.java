package com.example.test.service;

import com.example.test.entity.CoachInfo;

import java.util.List;

public interface CoachInfoService {
    List<CoachInfo> getCoachInfoList(String fullName, int page, int limit);
    int getCoachInfoCount();
    CoachInfo getCoachInfoById(String coachId);
    int addCoachInfo(CoachInfo coachInfo);
    int updateCoachInfo(CoachInfo coachInfo);
    int deleteCoachInfo(String coachId);
}
