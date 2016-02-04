package com.dao;

import com.DbUtil.DbUtil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProgressDao {
    static int getProgress(int userid, int grade,int lesson){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM progress WHERE UserId = ?");
            preparedStatement.setInt(1, userid);
            ResultSet set = preparedStatement.executeQuery();
            set.next();
            String query = Integer.toString(grade) + Integer.toString(lesson);
            if (query=="00"){
                query="Intro";
            }
            return set.getInt(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
            return -100;
        }
    }
    static boolean SetProgress(int userid, int grade,int lesson,int value){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("Insert into progress(?) values(?) WHERE UserId = ?");
            String query = Integer.toString(grade) + Integer.toString(lesson);
            preparedStatement.setString(1, query);
            preparedStatement.setInt(2, value);
            preparedStatement.setInt(1, userid);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    static boolean AddUser(int UserId){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("Insert into progress(UserId) values(?)");
            preparedStatement.setInt(1, UserId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
