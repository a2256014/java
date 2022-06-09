package ch13.domain_userInfo.dao.mysql;

import ch13.domain_userInfo.UserInfo;
import ch13.domain_userInfo.dao.UserInfoDao;

public class UserInfoMySqlDao implements UserInfoDao {
    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("insert domain_userInfo.dao.mysql.UserInfoMySqlDao userID = " + userInfo.getUserId());
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("update domain_userInfo.dao.mysql.UserInfoMySqlDao userID = " + userInfo.getUserId());
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("delete domain_userInfo.dao.mysql.UserInfoMySqlDao userID = " + userInfo.getUserId());
    }
}
