package com.Beans;
public class QuestionBean {
    public String HTML;
    public int Grade;
    public int Lesson;
    public String Title;
    public boolean Test;
    public QuestionBean(String html,int grade,int lesson){
        Test =false;
        HTML = html;
        Grade = grade;
        Lesson= lesson;
        this.Apply(true,"TEXT",grade,lesson);
    }
    public QuestionBean(String html){
        HTML = html;
    }
    public QuestionBean(){
        HTML = "";
    }
    public String GetTitle(){
        return Title;
    }
    public String GetData(){
        return HTML;
    }
    public boolean isTest(){
        return Test;
    }
    public String GetMode(){
        if(Test){
            return "Test";
        }
        return "Practice";
    }
    public int GetGrade(){
        return Grade;
    }
    public int GetLesson(){
        return Lesson;
    }
    public void AddLine(String Line){
        HTML+="\n<p>"+Line+"</p>";
    }
    public void Apply(boolean standard,String returning ,int grade, int lesson){
        if(returning.equals("TEXT")){
            HTML+="<form action = \"UserController\">\n"
                    + "<input type=\"text\" name=\"answer\"/>\n"
                    + "<input type =\"hidden\" name=\"action\" value = \"done\"/>\n"
                    + "<input type =\"hidden\" name=\"lesson\" value = \""+grade+"."+lesson+"\"/>\n"
                    + "<input type=\"submit\" name=\"Done\"/>"
                    + "</form>";
        }
        if(standard){
            HTML = "\n<div style = \"font-weight: bold; font-size: 300%;\" align = \"center\">\n"+HTML+"\n</div>";
        }
    }
}