package com.example.test.service;

import com.example.test.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> getUserInfoList(String fullName, int page, int limit); // 用like concat(%,#{fullName},%)实现姓名的模糊查询
    int getUserInfoListCount();
    UserInfo getUserInfoById(String userId);
    int addUserInfo(UserInfo userInfo);
    int updateUserInfo(UserInfo userInfo);
    int deleteUserInfo(String userId);
}
