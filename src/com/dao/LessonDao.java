package com.dao;

import com.Beans.ButtonBean;
import com.Beans.LessonBean;
import com.DbUtil.DbUtil;

import java.awt.color.*;
import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
            preparedStatement.setInt(2, page);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                LessonBean bean = new LessonBean();
                bean.AddLine(set.getString(1));
                bean.Apply(set.getInt(2)==1, set.getInt(3)==1);
                return bean;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgressDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new LessonBean("<p>ERROR 404: Page Not Found</p>",true);
    }
    public static ButtonBean getButtonBean(int GradeSelected){
        List<String> lessons = new ArrayList<>();
        ButtonBean bean = new ButtonBean();
        int grades = getGrades();
        bean.HTML = "<div class = \"content\">\n"+
                  "\t<div class = \"text-center\">\n"
                + "\t\t<div class = \"col-md-12\">\n"
                + "\t\t\t<p></p>";
        for(int i=1;i<=grades;i++){
            
        }
                "\t\t\t";
        return bean;
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