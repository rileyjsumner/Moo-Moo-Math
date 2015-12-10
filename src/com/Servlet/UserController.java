package com.Servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
        RequestDispatcher view = request.getRequestDispatcher("/Login.jsp");
        view.forward(request, response);
    }
}