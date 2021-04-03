package com.example.test.mapper;

import com.example.test.entity.CoachInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CoachInfoMapper {
    List<CoachInfo> getCoachInfoList(@Param("fullName") String fullName,
                                     @Param("page") int page,
                                     @Param("limit") int limit);
    int getCoachInfoCount();
    CoachInfo getCoachInfoById(@Param("coachId") String coachId);
    int addCoachInfo(@Param("coachInfo") CoachInfo coachInfo);
    int updateCoachInfo(@Param("coachInfo") CoachInfo coachInfo);
    int deleteCoachInfo(@Param("coachId") String coachId);
}
