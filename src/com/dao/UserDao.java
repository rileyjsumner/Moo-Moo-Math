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
}
