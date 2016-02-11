package com.dao;

import com.DbUtil.DbUtil;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgressDao {
    public static int getProgress(int userid, int grade,int lesson){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Progress FROM progress WHERE UserId = ? AND Grade = ? AND Lesson = ?");
            preparedStatement.setInt(1, userid);
            preparedStatement.setInt(2, grade);
            preparedStatement.setInt(3, lesson);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return set.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public static void SetProgress(int userid, int grade,int lesson,int value){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("UPDATE progress SET Progress=? WHERE UserId = ? AND Grade= ? AND Lesson = ?");
            preparedStatement.setInt(1, value);
            preparedStatement.setInt(2, userid);
            preparedStatement.setInt(3, grade);
            preparedStatement.setInt(4, lesson);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean HasProgress(int userid, int grade, int lesson){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Id FROM progress WHERE UserId = ? AND Grade = ? AND Lesson = ?");
            preparedStatement.setInt(1, userid);
            preparedStatement.setInt(2, grade);
            preparedStatement.setInt(3, lesson);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static boolean NewProgress(int userid, int grade, int lesson){
        if(!HasProgress(userid,grade,lesson)){
            Connection con =DbUtil.getConnection();
            PreparedStatement preparedStatement;
            try {
                preparedStatement = con.prepareStatement("INSERT INTO progress(Grade, Lesson, UserId) values(?,?,?)");
                preparedStatement.setInt(1, grade);
                preparedStatement.setInt(2, lesson);
                preparedStatement.setInt(3, userid);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return false;
    }
}
