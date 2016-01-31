package com.Servlet;

import com.Beans.LessonBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Questions.Converter;
import com.DbUtil.DbUtil;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserController extends HttpServlet {
    Converter converter;
    private static final long serialVersionUID = 1L;
    
    public UserController() {
        super();
        converter=new Converter();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        if (action==null){
        	RequestDispatcher view = request.getRequestDispatcher("/Login.jsp");
            view.forward(request, response);
        }
        
        System.out.println("Get action is: " + action);
        if (action.equalsIgnoreCase("login")){
        	forward="/Login.jsp";
        }
        else if (action.equalsIgnoreCase("lessonDone")){
            String lesson = request.getParameter("lesson");
            Connection con = DbUtil.getConnection();
            PreparedStatement preparedStatement;
            int Newlesson = Integer.parseInt(lesson);
            lesson = Integer.toString(Newlesson);
            try{
                
                preparedStatement = con.prepareStatement("INSERT INTO progress (Intro) VALUES (0) WHERE UserId = 0");
                //preparedStatement.setString(1, lesson);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                RequestDispatcher view = request.getRequestDispatcher("Login-Failed");
                view.forward(request, response);
                forward="/Home.jsp";
                return;
            }
            forward="/Home.jsp";
        }
        else if (action.equalsIgnoreCase("lesson")){
            String lessonstring = request.getParameter("lesson");
            String gr = lessonstring.substring(0, 1);
            String ls = lessonstring.substring(2, 3);
            System.out.println(gr);
            System.out.println(ls);
            int grade = Integer.parseUnsignedInt(gr);
            int lesson = Integer.parseUnsignedInt(ls);
            Connection con = DbUtil.getConnection();
            PreparedStatement preparedStatement;
            int id =0;
            try {
                preparedStatement = con.prepareStatement("SELECT * FROM progress WHERE UserId = ?");
                preparedStatement.setInt(1, 0);
                ResultSet set= preparedStatement.executeQuery();
                set.next();
                id = set.getInt("11");
                if(id < 101){
                    grade = 0;
                    System.out.println("TO INTRO!");
                }
                else{
                    id = set.getInt(gr+ls);
                    System.out.println(gr+"."+ls+" = "+id);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                RequestDispatcher view = request.getRequestDispatcher("Login-Failed");
                view.forward(request, response);
                return;
            }
            if(id<0){
                LessonBean lessonbean = new LessonBean();
                switch(grade){
                    case 0:
                        switch(id){
                            case -4:
                                lessonbean.Lesson = "Welcome to Oh Dang Studios! Math Tutorials.These Guides will help you learn Maths skills form grades 1-5.";
                                break;
                            case -3:
                                lessonbean.Lesson = "Each Section will be broken down into three Parts. The first part is the Lesson. It is inteneded to teach you key concepts from the lesson.";
                                break;
                            case -2:
                                lessonbean.Lesson = "The second part is the free practice area. This allows you to apply what you learned in the lesson. If you make a mistake, It will take you back to a quick reminder about that question type, then let you try again.";
                                break;
                            case -1:
                                lessonbean.Lesson = "Once you are consistent enough, You will be taken to the Test section, to test your knowledge of the material. You will be scored out of 100, but random bonus questions are available, so be alert!";
                                break;
                        }
                        break;
                    case 1:
                        switch(lesson){
                            case 1:
                                lessonbean.Lesson ="";
                                break;
                            case 2:
                                lessonbean.Lesson = "Do other stuff";
                                break;
                        }
                }
                request.setAttribute("lesson", lessonbean);
            }
        }
        RequestDispatcher view = request.getRequestDispatcher("/lesson.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String forward="/Fail.jsp";
    	String action = request.getParameter("action");
    	System.out.println("Post action is: " + action);
    	if(action.equals("LoginForm")){
            forward="/Login.jsp";
            String Username=request.getParameter("User name");
            String Password = request.getParameter("password");
            Connection con= DbUtil.getConnection();
            try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("SELECT Userid from users WHERE Username=? AND Password=?");
            // Parameters start with 1
            preparedStatement.setString(1, Username);
            preparedStatement.setString(2, Password);
            ResultSet set= preparedStatement.executeQuery();
            try{
                set.next();
                int id = set.getInt(1);
                preparedStatement = con
                    .prepareStatement("SELECT Password from users WHERE Userid=?");
                // Parameters start with 1
                preparedStatement.setInt(1, id);
                set = preparedStatement.executeQuery();
                set.next();
                String Real_Password = set.getString(1);
                if(Password.equals(Real_Password)){

                    forward="/Home.jsp";
                }

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    forward="/Login.jsp";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    		
    	}
    	else if(action.equals("CreateAccount")){
            String Username=request.getParameter("User Name");
            String Password = request.getParameter("Password");
            String FName = request.getParameter("First Name");
            String LName = request.getParameter("Last Name");
            System.out.println("Got here");
            Connection con= DbUtil.getConnection();
            try {
                PreparedStatement preparedStatement = con
                        .prepareStatement("INSERT INTO users (Userid, Username, Password, Points) values (?, ?, ?, ?);");
                // Parameters start with 1
                System.out.println("Got here");
                preparedStatement.setInt(1, 0);
                preparedStatement.setString(2, Username);
                preparedStatement.setString(3, Password);
                preparedStatement.setInt(4, 0);
                System.out.println("Got here");
                preparedStatement.executeUpdate();
                System.out.println("Got here");
                
            } catch (SQLException e) {
                e.printStackTrace();
            };
            forward="/Correct.jsp";
    	}
    	RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}