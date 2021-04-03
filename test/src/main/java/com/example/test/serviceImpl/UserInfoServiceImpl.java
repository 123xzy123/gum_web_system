package com.example.test.serviceImpl;

import com.example.test.entity.UserInfo;
import com.example.test.mapper.UserInfoMapper;
import com.example.test.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUserInfoList(String fullName, int page, int limit) {
        return userInfoMapper.getUserInfoList(fullName, page, limit);
    }

    @Override
    public int getUserInfoListCount() {
        return userInfoMapper.getUserInfoListCount();
    }

    @Override
    public UserInfo getUserInfoById(String userId) {
        return userInfoMapper.getUserInfoById(userId);
    }

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoMapper.addUserInfo(userInfo);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public int deleteUserInfo(String userId) {
        return userInfoMapper.deleteUserInfo(userId);
    }
}
