package com.Beans;
public class HelpBean {
    public String Question;
    public int Grade;
    public int Lesson;
    public String Title;
    public String CorrectAns;
    public HelpBean(String question,int grade,int lesson, String title, String correct){
        Question= question;
        Grade= grade;
        Lesson = lesson;
        Title=title;
        CorrectAns = correct;
    }
    public HelpBean(){
        Question= "";
        Grade= 0;
        Lesson = 0;
        Title="";
        CorrectAns = "";
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