package com.example.test.mapper;

import com.example.test.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    List<UserInfo> getUserInfoList(@Param("fullName") String fullName,
                                   @Param("page") int page,
                                   @Param("limit") int limit); // 用like concat(%,#{fullName},%)实现姓名的模糊查询
    int getUserInfoListCount();
    UserInfo getUserInfoById(@Param("userId") String userId);
    int addUserInfo(@Param("userInfo") UserInfo userInfo);
    int updateUserInfo(@Param("userInfo") UserInfo userInfo);
    int deleteUserInfo(@Param("userId") String userId);
}
