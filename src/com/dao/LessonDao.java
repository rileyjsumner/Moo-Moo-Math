package com.dao;

import com.Beans.LessonBean;
import com.DbUtil.DbUtil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LessonDao {
    static LessonBean getLesson(int grade,int lesson,int page){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM lessons");
            ResultSet set = preparedStatement.executeQuery();
            set.next();
            String query = Integer.toString(grade) + Integer.toString(lesson);
            int result;
            int curGrade;
            int curLesson;
            int curPage=0;
            int lessons=0;
            while(set.next()){
                result = set.getInt(1);
                curPage=result%10;
                result= (result-result%10)/10;
                curLesson=result%10;
                result= (result-result%10)/10;
                curGrade=result%10;
                if(curLesson==lesson&&curGrade==grade&&curPage==page){
                    String Lessontxt = set.getString(2);
                    int buffer = set.getInt(3);
                    boolean customBtn,standard;
                    if(buffer==0){customBtn=false;}else{customBtn=true;}
                    buffer = set.getInt(4);
                    if(buffer==0){standard=false;}else{standard=true;}
                    LessonBean lessonbean = new LessonBean();
                    lessonbean.AddLine(Lessontxt);
                    lessonbean.Apply(customBtn, standard);
                    return lessonbean;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new LessonBean("<p>ERROR 404: Page Not Found</p>");
    }
    static int getLessons(int grade,int lesson){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM lessons");
            ResultSet set = preparedStatement.executeQuery();
            set.next();
            String query = Integer.toString(grade) + Integer.toString(lesson);
            int result;
            int curGrade;
            int curLesson;
            int curPage=0;
            int lessons=0;
            while(set.next()){
                result = set.getInt(1);
                curPage=result%10;
                result= (result-result%10)/10;
                curLesson=result%10;
                result= (result-result%10)/10;
                curGrade=result%10;
                if(curLesson==lesson&&curGrade==grade){
                    lessons++;
                }
            }
            return lessons;
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
            return -100;
        }
    }
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
