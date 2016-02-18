package com.Beans;
public class HelpBean {
    public String Question;
    public int Grade;
    public int Lesson;
    public String Title;
    public String CorrectAns;
    public String UserAnswer;
    public String Help;
    public HelpBean(String question,int grade,int lesson, String title, String correct, String help){
        Question= question;
        Grade= grade;
        Lesson = lesson;
        Title=title;
        CorrectAns = correct;
        UserAnswer = "";
        Help = help;
    }
    public HelpBean(){
        Question= "";
        Grade= 0;
        Lesson = 0;
        Title="";
        CorrectAns = "";
    }
    public String GetHelp(){
        return Help;
    }
    public String GetAnswer(){
        return CorrectAns;
    }
    public String GetUserAnswer(){
        return UserAnswer;
    }
    public String GetQuestion(){
        return Question;
    }
    public String GetTitle(){
        return Title;
    }
    public boolean isTest(){
        return false;
    }
    public String GetMode(){
        return "Help";
    }
    public int GetGrade(){
        return Grade;
    }
    public int GetLesson(){
        return Lesson;
    }
}