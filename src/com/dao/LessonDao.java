package com.dao;

import com.Beans.LessonBean;
import com.DbUtil.DbUtil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LessonDao {
    public static LessonBean getLesson(int grade,int lesson,int page){
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
                    lessonbean.Apply(standard, customBtn);
                    return lessonbean;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new LessonBean("<p>ERROR 404: Page Not Found</p>",true);
    }
    public static int getLessons(int grade,int lesson){
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
    
}
