package com.example.test.serviceImpl;

import com.example.test.entity.PunchClock;
import com.example.test.mapper.PunchClockMapper;
import com.example.test.service.PunchClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunchClockServiceImpl implements PunchClockService{
    @Autowired
    private PunchClockMapper punchClockMapper;

    @Override
    public List<PunchClock> getPunchClockList(String fullName, int page, int limit) {
        return punchClockMapper.getPunchClockList(fullName, page, limit);
    }

    @Override
    public int getPunchClockListCount() {
        return punchClockMapper.getPunchClockListCount();
    }
}
