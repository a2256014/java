package ch13.web_userInfo;

import ch13.domain_userInfo.UserInfo;
import ch13.domain_userInfo.dao.UserInfoDao;
import ch13.domain_userInfo.dao.mysql.UserInfoMySqlDao;
import ch13.domain_userInfo.dao.oracle.UserInfoOracleDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserInfoClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("fastCampus/ch13/DB.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String dbType = prop.getProperty("DBTYPE");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("1234");
        userInfo.setUserName("김도균");
        userInfo.setPassword("1234567");
        UserInfoDao userInfoDao = null;

        if(dbType.equals("ORACLE")){
            userInfoDao = new UserInfoOracleDao();
        }
        else if(dbType.equals("MYSQL")){
            userInfoDao = new UserInfoMySqlDao();
        }
        else{
            System.out.println("db error");
        }

        if(userInfoDao!=null){
            userInfoDao.insertUserInfo(userInfo);
            userInfoDao.updateUserInfo(userInfo);
            userInfoDao.deleteUserInfo(userInfo);
        }
    }
}
