package com.dao;

import com.Bits.EditBit;
import com.Bits.QuestionBit;
import com.DbUtil.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionDao {
    public static List<EditBit> GetQuestion(int UserId){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        List<EditBit> users = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM questions WHERE Id = ?");
            preparedStatement.setInt(1, UserId);
            ResultSet set = preparedStatement.executeQuery();
            if(set.first()){
                users.add(new EditBit("ID",Integer.toString(set.getInt(1)),false));
                users.add(new EditBit("Grade",Integer.toString(set.getInt(2)),true));
                users.add(new EditBit("Lesson",set.getString(3),true));
                users.add(new EditBit("Points",set.getString(4),true));
                users.add(new EditBit("Password",set.getString(5),true));
                users.add(new EditBit("Email",set.getString(6),true));
                users.add(new EditBit("Role",Integer.toString(set.getInt(7)),true));
                
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    public static List<QuestionBit> getAllQuestions(){
        Connection con =DbUtil.getConnection();
        PreparedStatement preparedStatement;
        List<QuestionBit> bits=new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM questions");
            ResultSet set = preparedStatement.executeQuery();
            while(set.next()){
                bits.add(new QuestionBit(set.getInt(1),set.getInt(2),set.getInt(3),set.getInt(4),set.getString(5),set.getString(6),set.getInt(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bits;
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
