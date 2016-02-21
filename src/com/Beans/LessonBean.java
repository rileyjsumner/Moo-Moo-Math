package com.Beans;
public class LessonBean {
    public String HTML;
    public int Grade;
    public int Lesson;
    public String Title;
    public LessonBean(String html,int grade,int lesson){
        HTML = html;
        Grade = grade;
        Lesson= lesson;
        this.Apply(true,true,grade,lesson);
    }
    public LessonBean(String html){
        HTML = html;
    }
    public LessonBean(){
        HTML = "";
    }
    public String GetTitle(){
        return Title;
    }
    public String GetData(){
        return HTML;
    }
    public String GetMode(){
        return "Lesson";
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
    public void Apply(boolean standard, boolean customBtn ,int grade, int lesson){
        if(standard){
            HTML = "\n<div align = \"center\">\n"+HTML+"\n</div>";
        }
        if(!customBtn){
            HTML+="\n<div align = \"center\">";
            HTML+="\n<input type=\"button\" style=\"background-color:#FFDAB9; border: 4px solid #E7C6A5\" onclick=\"document.location.href='User?action=done&lesson="+grade+"."+lesson+"'\" value=\"Next\"/>";
            HTML+="\n</div>";
        }
    }
}