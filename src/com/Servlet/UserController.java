package com.Servlet;

import com.dao.*;
import com.Beans.LessonBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Questions.Converter;
import com.DbUtil.DbUtil;

public class UserController extends HttpServlet {
    Converter converter;
    private static final long serialVersionUID = 1L;
    
    public UserController() {
        super();
    }
    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        HttpSession session = request.getSession();
        session.setAttribute("UserName", "Steve");
        Enumeration<String> h = session.getAttributeNames();
        System.out.println("ELEMENTS:");
        while(h.hasMoreElements()){
            System.out.println(h.nextElement());
            
        }
        System.out.println();
        String action = request.getParameter("action");
        if (action==null){
        	RequestDispatcher view = request.getRequestDispatcher("/Login.jsp");
            view.forward(request, response);
        }
        
        System.out.println("Get action is: " + action);
        if (action.equalsIgnoreCase("login")) {
            
        }
        else if (action.equalsIgnoreCase("home")){
            
        }
        else if (action.equalsIgnoreCase("lessonDone")){
            System.out.println("DONE");
        }
        else if (action.equalsIgnoreCase("lesson")){
            String lessonstring = request.getParameter("lesson");
            String gr = lessonstring.substring(0, 1);
            String ls = lessonstring.substring(2, 3);
            System.out.println(gr);
            System.out.println(ls);
            int grade = Integer.parseUnsignedInt(gr);
            int lesson = Integer.parseUnsignedInt(ls);
            int progress = ProgressDao.getProgress(0, grade, lesson);
            int lessons = LessonDao.getLessonPages(grade, lesson);
            if (progress <= lessons-1){
                LessonBean lessonBean = LessonDao.getLessonPage(grade, lesson, progress+1);
                request.setAttribute("data", lessonBean);
            }
        }
        else {
            forward="/Login.jsp";
        }
        RequestDispatcher view = request.getRequestDispatcher("/lesson.jsp");
        view.forward(request, response);
    }
    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
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
            }
            forward="/Correct.jsp";
    	}
    	RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}