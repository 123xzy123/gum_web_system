package com.example.test.service;

import com.example.test.entity.PunchClock;

import java.util.List;

public interface PunchClockService {
    List<PunchClock> getPunchClockList(String fullName, int page, int limit);
    int getPunchClockListCount();
}
