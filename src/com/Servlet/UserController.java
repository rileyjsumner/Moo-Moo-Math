package com.Servlet;

import com.dao.*;
import Questions.Questions;
import com.Beans.*;
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

import com.DbUtil.DbUtil;
import java.util.List;

public class UserController extends HttpServlet {
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
        String forward="/login-failed.html";
        System.out.println();
        String action = request.getParameter("action");
        if (action==null){
            forward = "/login-failed.html";
        }
        
        System.out.println("Get action is: " + action);
        if (action.equalsIgnoreCase("login")) {
            
        }
        else if (action.equals("done") || action.equals("next")){
            String lessonS = request.getParameter("lesson");
            String gr = lessonS.substring(0, 1);
            String ls = lessonS.substring(2, 3);
            int grade = Integer.parseUnsignedInt(gr);
            int lesson = Integer.parseUnsignedInt(ls);
            request.setAttribute("buttons", LessonDao.getButtonBean());
            int prog = ProgressDao.getProgress(1, grade, lesson);
            int max = LessonDao.getLessonPages(grade,lesson);
            System.out.println("MAX:"+max);
            int MaxPractice = LessonDao.getMaxPractice(grade,lesson); System.out.println(MaxPractice + max);
            int helpNeeded=0;
            forward="/lesson.jsp";
            if(action.equals("done")){
                if(prog<max){
                    prog++;
                    ProgressDao.SetProgress(1, grade, lesson, prog);
                }
                else if(prog < MaxPractice + max){
                    String answer = request.getParameter("answer");
                    if(answer.equals(AnswersDao.getAnswer(1, grade, lesson))){
                        prog++;
                        ProgressDao.SetProgress(1, grade, lesson, prog);
                    }
                    else
                    {
                        helpNeeded = AnswersDao.getPageType(1, grade, lesson);
                    }
                }
                else{
                    String answer = request.getParameter("answer");
                    if(answer.equals(AnswersDao.getAnswer(1, grade, lesson))){
                        prog++;
                        ProgressDao.SetProgress(1, grade, lesson, prog);
                    }

                }
            }
            if(prog<max){
                LessonBean bean = LessonDao.getLessonPage(grade, lesson, prog+1);
                request.setAttribute("data", bean);
            }
            else if (prog<MaxPractice + max)
            {
                if (helpNeeded!=0){
                    HelpBean bean;
                    if(HelpDao.hasHelpPage(helpNeeded)){
                        bean = HelpDao.getHelpPage(helpNeeded);
                    }
                    else{
                        bean = new HelpBean();
                        bean.Grade = grade;
                        bean.Lesson = lesson;
                        bean.CorrectAns = AnswersDao.getAnswer(1, grade, lesson);
                        bean.Help = "<p>Sorry, but we couldn't find any help content for that question.</p><p>You might have to try this one on your own.</p>";
                        bean.Title = LessonDao.getLessonText(grade, lesson);
                    }
                    bean.UserAnswer = request.getParameter("answer");
                    request.setAttribute("data", bean);
                    forward = "/help.jsp";
                }
                else{
                    request.setAttribute("data", Questions.getNewQuestion(grade, lesson));
                }
            }
            else{
                request.setAttribute("data", Questions.getNewQuestion(grade, lesson));
            }
            
        }
        else if (action.equalsIgnoreCase("home")){
            request.setAttribute("buttons", LessonDao.getButtonBean());
            forward="/Home.jsp";
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
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