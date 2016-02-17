package com.dao;

import com.Beans.ButtonBean;
import com.Beans.LessonBean;
import com.DbUtil.DbUtil;

import Util.Util;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LessonDao {
    public static LessonBean getLessonPage(int grade,int lesson,int page){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT LessonTxt, Standard, CustomBtn FROM pages WHERE Lesson = ? AND Grade = ? AND Page = ?");
            preparedStatement.setInt(1, lesson);
            preparedStatement.setInt(2, grade);
            preparedStatement.setInt(3, page);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                LessonBean bean = new LessonBean();
                bean.Grade = grade;
                bean.Lesson=lesson;
                bean.Title = getLessonText(grade,lesson);
                bean.AddLine(set.getString(1));
                bean.Apply(set.getInt(2)==1, set.getInt(3)==1,grade,lesson);
                return bean;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new LessonBean("<p>ERROR 404: Page Not Found</p>",0,0);
    }
    public static ButtonBean getButtonBean(){
        ButtonBean bean = new ButtonBean(); 
        bean.grades = getGrades();
        bean.lessons=new ArrayList<>();
        for(int i =1;i<=bean.grades;i++){
            bean.lessons.add(new ArrayList<>());
            for(int j=1;j<=getLessons(i);j++){
                bean.lessons.get(i-1).add(getLessonText(i,j));
            }
        }
        return bean;
    }
    public static int getMaxPages(int grade,int lesson){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT MaxPages FROM lessons WHERE Lesson = ? AND Grade = ?");
            preparedStatement.setInt(1, lesson);
            preparedStatement.setInt(2, grade);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return set.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static int getGrades(){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Grade FROM grades");
            ResultSet set = preparedStatement.executeQuery();
            int grades=0;
            while(set.next()){
                grades++;
            }
            return grades;
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static int getLessons(int grade){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Lesson FROM lessons WHERE Grade = ?");
            preparedStatement.setInt(1, grade);
            ResultSet set = preparedStatement.executeQuery();
            int lessons=0;
            while(set.next()){
                lessons++;
            }
            return lessons;
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static String getLessonText(int grade,int lesson){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT LessonName FROM lessons WHERE Lesson = ? AND Grade = ?");
            preparedStatement.setInt(1, lesson);
            preparedStatement.setInt(2, grade);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                return set.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "{NULL}";
    }
    public static int getLessonPages(int grade,int lesson){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Id FROM pages WHERE Lesson = ? AND Grade = ?");
            preparedStatement.setInt(1, lesson);
            preparedStatement.setInt(2, grade);
            ResultSet set = preparedStatement.executeQuery();
            int pages=0;
            while(set.next()){
                pages++;
            }
            return pages;
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}