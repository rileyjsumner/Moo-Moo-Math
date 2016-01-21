package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

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
        System.out.println("DOGET");
        String action = request.getParameter("action");
        if (action==null){
        	RequestDispatcher view = request.getRequestDispatcher("/Login.jsp");
            view.forward(request, response);
        }
        
        System.out.println("ACTION IS: " + action);
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()){
        	System.out.println(names.nextElement());
        }
        //action = action.trim();
        if (action.equalsIgnoreCase("login")){
        	forward="/Login.jsp";
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
            try {
                preparedStatement = con.prepareStatement("SELECT * from progress WHERE UserId=0");
                //preparedStatement.setString(1, gr+ls);
                //preparedStatement.setString(2, gr+ls);
                ResultSet set= preparedStatement.executeQuery();
                set.next();
                int id = set.getInt("11");
                System.out.println("1.1= "+id);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Parameters start with 1
            
            switch(grade){
                case 1:
                    switch(lesson){
                        case 2:
                            
                    }
                    break;
            }
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
    	String forward="/Fail.jsp";
    	System.out.println("DOPOST");
    	String action = request.getParameter("action");
    	System.out.println("---------\naction = "+action);
    	Enumeration<String> names = request.getParameterNames();
    	while(names.hasMoreElements()){
        	System.out.println(names.nextElement());
        }
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