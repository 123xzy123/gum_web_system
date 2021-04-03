package com.example.test.serviceImpl;

import com.example.test.entity.CoachInfo;
import com.example.test.mapper.CoachInfoMapper;
import com.example.test.service.CoachInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachInfoServiceImpl implements CoachInfoService {
    @Autowired
    private CoachInfoMapper coachInfoMapper;

    @Override
    public List<CoachInfo> getCoachInfoList(String fullName, int page, int limit) {
        return coachInfoMapper.getCoachInfoList(fullName, page, limit);
    }

    @Override
    public int getCoachInfoCount() {
        return coachInfoMapper.getCoachInfoCount();
    }

    @Override
    public CoachInfo getCoachInfoById(String coachId) {
        return coachInfoMapper.getCoachInfoById(coachId);
    }

    @Override
    public int addCoachInfo(CoachInfo coachInfo) {
        return coachInfoMapper.addCoachInfo(coachInfo);
    }

    @Override
    public int updateCoachInfo(CoachInfo coachInfo) {
        return coachInfoMapper.updateCoachInfo(coachInfo);
    }

    @Override
    public int deleteCoachInfo(String coachId) {
        return coachInfoMapper.deleteCoachInfo(coachId);
    }
}
