package com.dao;

import com.Beans.GeneralBean;
import com.Bits.UserBit;
import com.DbUtil.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {
    public static int GetUserId(String Username){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT UserId FROM users WHERE Username = ?");
            preparedStatement.setString(1, Username);
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
    public static List<UserBit> GetAllUsers(){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        List<UserBit> users = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM users");
            ResultSet set = preparedStatement.executeQuery();
            UserBit user;
            while(set.next()){
                user = new UserBit();
                user.UserId = set.getInt(1);
                user.UserName = set.getString(2);
                user.FirstName = set.getString(3);
                user.LastName = set.getString(4);
                user.Password = set.getString(5);
                user.Email = set.getString(6);
                user.Role = set.getInt(7);
                users.add(user);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    public static boolean SafeAddUser(String Username,String Name,String LastName,String Email,String Password){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT UserId FROM users WHERE Username = ?");
            preparedStatement.setString(1, Username);
            ResultSet set = preparedStatement.executeQuery();
            if(!set.first()){
                AddUser(Username, Name, LastName, Email, Password);
                return true;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static void AddUser(String Username,String Name,String LastName,String Email,String Password){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("INSERT INTO users (Username,Name,LastName,Email,Password) values(?,?,?,?,?)");
            preparedStatement.setString(1, Username);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, LastName);
            preparedStatement.setString(4, Email);
            preparedStatement.setString(5, Password);
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int GetRole(String Username,String Password){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Role FROM users WHERE Username = ? AND Password = ?");
            preparedStatement.setString(1, Username);
            preparedStatement.setString(2, Password);
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
