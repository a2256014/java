package ch13.domain_userInfo.dao;

import ch13.domain_userInfo.UserInfo;

public interface UserInfoDao {
    void insertUserInfo(UserInfo userInfo);
    void updateUserInfo(UserInfo userInfo);
    void deleteUserInfo(UserInfo userInfo);
}
