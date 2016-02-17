package com.dao;

import com.DbUtil.DbUtil;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnswersDao {
    public static void safeCreateAnswer(int userid, int grade,int lesson, String answer, int pageType){
        if(!hasAnswer(userid,grade,lesson)){
            newAnswer(userid,grade,lesson,answer, pageType);
        }
        else{
            updateAnswer(userid,grade,lesson,answer, pageType);
        }
    }
    public static void updateAnswer(int userid, int grade,int lesson, String correct, int pageType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("UPDATE answers SET CorrectAnswer = ?, ansType = ? WHERE UserId = ? AND Grade = ? AND Lesson = ?");
            preparedStatement.setString(1, correct);
            preparedStatement.setInt(2, pageType);
            preparedStatement.setInt(3, userid);
            preparedStatement.setInt(4, grade);
            preparedStatement.setInt(5, lesson);
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
    public static int getPageType(int userid, int grade,int lesson){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT ansType FROM answers WHERE UserId = ? AND Grade = ? AND Lesson = ?");
            preparedStatement.setInt(1, userid);
            preparedStatement.setInt(2, grade);
            preparedStatement.setInt(3, lesson);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return set.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnswersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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
    public static void newAnswer(int userid, int grade,int lesson,String answer, int pageType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("INSERT INTO answers (UserId,Grade,Lesson,CorrectAnswer,ansType) values(?,?,?,?,?)");
            preparedStatement.setInt(1, userid);
            preparedStatement.setInt(2, grade);
            preparedStatement.setInt(3, lesson);
            preparedStatement.setString(4, answer);
            preparedStatement.setInt(5, pageType);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnswersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
