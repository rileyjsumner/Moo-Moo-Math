package com.dao;

import com.Bits.QuestionBit;
import com.DbUtil.DbUtil;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionDao {
    public static QuestionBit getQuestion(int id){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        QuestionBit bit=new QuestionBit();
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM questions WHERE Id = ?");
            preparedStatement.setInt(1, id);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                bit.Id=id;
                bit.Grade=set.getInt(2);
                bit.Lesson=set.getInt(3);
                bit.Points=set.getInt(4);
                bit.Text=set.getString(5);
                bit.Answer=set.getString(6);
                bit.HelpType=set.getInt(7);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bit;
    }
    public static void newQuestion(int grade,int lesson,int points,String text,String answer,int helpType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("INSERT INTO questions (Grade, Lesson, Points, QuestionTxt, Answer, HelpType) values(?,?,?,?,?,?)");
            preparedStatement.setInt(1, grade);
            preparedStatement.setInt(2, lesson);
            preparedStatement.setInt(3, points);
            preparedStatement.setString(4, text);
            preparedStatement.setString(5, answer);
            preparedStatement.setInt(6, helpType);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateQuestion(int id,int grade,int points,int lesson,String text,String answer,int helpType){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("UPDATE questions SET Points = ? Grade = ?, Lesson = ?, QuestionTxt = ?, Answer = ?, HelpType = ? WHERE Id = ?");
            preparedStatement.setInt(1, points);
            preparedStatement.setInt(2, grade);
            preparedStatement.setInt(3, lesson);
            preparedStatement.setString(4, text);
            preparedStatement.setString(5, answer);
            preparedStatement.setInt(6, helpType);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void deleteQuestion(int id){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("DELETE FROM questions WHERE Id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
