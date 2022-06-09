package ch13.domain_userInfo.dao.oracle;

import ch13.domain_userInfo.dao.UserInfoDao;
import ch13.domain_userInfo.UserInfo;

public class UserInfoOracleDao implements UserInfoDao {
    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("insert domain_userInfo.dao.oracle.UserInfoOracleDao userID = " + userInfo.getUserId());
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("update domain_userInfo.dao.oracle.UserInfoOracleDao userID = " + userInfo.getUserId());
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("delete domain_userInfo.dao.oracle.UserInfoOracleDao userID = " + userInfo.getUserId());
    }
}
