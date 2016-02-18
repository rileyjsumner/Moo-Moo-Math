package com.dao;

import com.DbUtil.DbUtil;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnswersDao {
    public static void safeCreateAnswer(int userid, int grade,int lesson, String answer, String question, int pageType){
        if(!hasAnswer(userid,grade,lesson)){
            newAnswer(userid,grade,lesson,answer,question, pageType);
        }
        else{
            updateAnswer(userid,grade,lesson,answer,question, pageType);
        }
    }
    public static void updateAnswer(int userid, int grade,int lesson, String correct,String question, int pageType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("UPDATE answers SET CorrectAnswer = ?,QuestionTxt = ?, AnswerType = ? WHERE UserId = ? AND Grade = ? AND Lesson = ?");
            preparedStatement.setString(1, correct);
            preparedStatement.setString(2, question);
            preparedStatement.setInt(3, pageType);
            preparedStatement.setInt(4, userid);
            preparedStatement.setInt(5, grade);
            preparedStatement.setInt(6, lesson);
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
            preparedStatement = con.prepareStatement("SELECT AnswerType FROM answers WHERE UserId = ? AND Grade = ? AND Lesson = ?");
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
    public static String getQuestion(int userid, int grade,int lesson){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT QuestionTxt FROM answers WHERE UserId = ? AND Grade = ? AND Lesson = ?");
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
    public static void newAnswer(int userid, int grade,int lesson,String answer, String question, int pageType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("INSERT INTO answers (UserId,Grade,Lesson,CorrectAnswer,QuestionTxt,AnswerType) values(?,?,?,?,?,?)");
            preparedStatement.setInt(1, userid);
            preparedStatement.setInt(2, grade);
            preparedStatement.setInt(3, lesson);
            preparedStatement.setString(4, answer);
            preparedStatement.setString(5, question);
            System.out.println(pageType);
            preparedStatement.setInt(6, pageType);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnswersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
