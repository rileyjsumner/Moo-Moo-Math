package com.dao;

import com.DbUtil.DbUtil;

import java.sql.*;
import com.Beans.HelpBean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelpDao {
    public static void safeMakeHelp(int userid, int helpType){
        if(hasHelp(userid)){
            updateHelp(userid,helpType);
        }
        else{
            newHelp(userid,helpType);
        }
    }
    public static void updateHelp(int userid, int helpType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("UPDATE userHelp SET HelpType = ? WHERE UserId = ?");
            preparedStatement.setInt(1, helpType);
            preparedStatement.setInt(2, userid);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HelpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void newHelp(int userid, int helpType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("INSERT into userHelp (UserId, HelpType) values (?,?)");
            preparedStatement.setInt(1, userid);
            preparedStatement.setInt(2, helpType);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HelpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean hasHelp(int userid){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Id FROM userhelp WHERE UserId = ?");
            preparedStatement.setInt(1, userid);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HelpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static int setHelp(int userid, int helpType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT HelpType FROM userhelp WHERE UserId = ?");
            preparedStatement.setInt(1, userid);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return set.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HelpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static int getUserHelpType(int userid){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT HelpType FROM userhelp WHERE UserId = ?");
            preparedStatement.setInt(1, userid);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return set.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HelpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static int getUserHelpLesson(int HelpType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Lesson FROM help WHERE Id = ?");
            preparedStatement.setInt(1, HelpType);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return set.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HelpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static int getUserHelpGrade(int HelpType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Grade FROM help WHERE Id = ?");
            preparedStatement.setInt(1, HelpType);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return set.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HelpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static HelpBean getHelpPage(int helpType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM helppages WHERE HelpType = ?");
            preparedStatement.setInt(1, helpType);
            ResultSet set = preparedStatement.executeQuery();
            int grade = getUserHelpGrade(helpType);
            int lesson = getUserHelpLesson(helpType);
            if(set.first()){
                return new HelpBean(AnswersDao.getQuestion(1, grade, lesson),grade,lesson,LessonDao.getLessonText(grade, lesson),AnswersDao.getAnswer(1, grade, lesson));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HelpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new HelpBean();
    }
    public static boolean userNeedsHelp(int userid, int helpType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Id FROM userhelp WHERE UserId = ? AND HelpType = ?");
            preparedStatement.setInt(1, userid);
            preparedStatement.setInt(2, helpType);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HelpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
