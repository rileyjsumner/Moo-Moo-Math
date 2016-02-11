package com.Beans;
public class LessonBean {
    public String HTML;
    public LessonBean(String html,int grade,int lesson){
        HTML = html;
        this.Apply(true,true,grade,lesson);
    }
    public LessonBean(String html){
        HTML = html;
    }
    public LessonBean(){
        HTML = "";
    }
    public String GetData(){
        return HTML;
    }
    public String GetLesson(){
        return HTML;
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
            HTML+="\n<input type=\"button\" style=\"background-color:#FFDAB9; border: 4px solid #E7C6A5\" onclick=\"document.location.href='UserController?action=lessonDone&lesson="+grade+"."+lesson+"'\" value=\"Next\"/>";
            HTML+="\n</div>";
        }
    }
}