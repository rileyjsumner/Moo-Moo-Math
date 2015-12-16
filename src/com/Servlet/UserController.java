package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DbUtil.DbUtil;


public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
        System.out.println("ACTION IS: " + action);
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()){
        	System.out.println(names.nextElement());
        }
        //action = action.trim();
        if (action.equalsIgnoreCase("login")){
        	forward="/Login.jsp";
        }
        else if (action.equalsIgnoreCase("LoginForm")){
        	if(request.getParameter("Username")=="Nixon"){
        		forward="/CreateAccount.jsp";
        	}
        	else{
        		forward="/Login.jsp";
        	}
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String forward="";
    	String action = request.getParameter("action");
    	if(action.equals("LoginForm")){
    		String Username=request.getParameter("User name");
    		String Password = request.getParameter("password");
    		Connection con= DbUtil.getConnection();;
    		try {
                PreparedStatement preparedStatement = con
                        .prepareStatement("insert into users(firstname,lastname,dob,email) values (?, ?, ?, ? )");
                // Parameters start with 1
                //preparedStatement.setString(1, user.getFirstName());
                //preparedStatement.setString(2, user.getLastName());
                //preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
                //preparedStatement.setString(4, user.getEmail());
                //preparedStatement.executeUpdate();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
    		
    	}
    	else if(action.equals("Create Account")){
    		String Username=request.getParameter("User name");
    		String Password = request.getParameter("Password");
    		String VPassword = request.getParameter("Verify Password");
    		Connection con= DbUtil.getConnection();
    		try {
                PreparedStatement preparedStatement = con
                        .prepareStatement("insert into users(username,password,Points) values (?, ?, 0 )");
                // Parameters start with 1
                preparedStatement.setString(1, Username);
                preparedStatement.setString(2, Password);
                preparedStatement.executeUpdate();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
    	}
    	RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}