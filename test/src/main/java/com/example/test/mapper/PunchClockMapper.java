package com.example.test.mapper;

import com.example.test.entity.PunchClock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PunchClockMapper {
    List<PunchClock> getPunchClockList(@Param("fullName") String fullName, @Param("page") int page, @Param("limit") int limit);
    int getPunchClockListCount();
}
