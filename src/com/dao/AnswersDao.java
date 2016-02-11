package com.dao;

import com.DbUtil.DbUtil;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnswersDao {
    public static void safeCreateAnswer(int userid, int grade,int lesson, String answer){
        if(!hasAnswer(userid,grade,lesson)){
            newAnswer(userid,grade,lesson,answer);
        }
        else{
            updateAnswer(userid,grade,lesson,answer);
        }
    }
    public static void updateAnswer(int userid, int grade,int lesson, String correct){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("UPDATE answers SET CorrectAnswer = ? WHERE UserId = ? AND Grade = ? AND Lesson = ?");
            preparedStatement.setString(1, correct);
            preparedStatement.setInt(2, userid);
            preparedStatement.setInt(3, grade);
            preparedStatement.setInt(4, lesson);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnswersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void delAnswer(int userid, int grade,int lesson){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("DELETE * FROM answers WHERE UserId = ? AND Grade = ? AND Lesson = ?");
            preparedStatement.setInt(1, userid);
            preparedStatement.setInt(2, grade);
            preparedStatement.setInt(3, lesson);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnswersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean hasAnswer(int userid, int grade,int lesson){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Id FROM answers WHERE UserId = ? AND Grade = ? AND Lesson = ?");
            preparedStatement.setInt(1, userid);
            preparedStatement.setInt(2, grade);
            preparedStatement.setInt(3, lesson);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnswersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static String getAnswer(int userid, int grade,int lesson){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT CorrectAnswer FROM answers WHERE UserId = ? AND Grade = ? AND Lesson = ?");
            preparedStatement.setInt(1, userid);
            preparedStatement.setInt(2, grade);
            preparedStatement.setInt(3, lesson);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return set.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnswersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public static void newAnswer(int userid, int grade,int lesson,String answer){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("INSERT INTO answers (UserId,Grade,Lesson,CorrectAnswer) values(?,?,?,?)");
            preparedStatement.setInt(1, userid);
            preparedStatement.setInt(2, grade);
            preparedStatement.setInt(3, lesson);
            preparedStatement.setString(4, answer);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnswersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
