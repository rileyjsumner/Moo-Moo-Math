package com.dao;

import com.DbUtil.DbUtil;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {
    public static int AddUser(String Username,String Password){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("INSERT INTO users (Username,Password) values(?,?)");
            preparedStatement.setString(1, Username);
            preparedStatement.setString(1, Password);
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
     public static int CheckUser(String Username,String Password){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Role form users WHERE Username = ? AND Password = ?");
            preparedStatement.setString(1, Username);
            preparedStatement.setString(1, Password);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return set.getInt(1);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
