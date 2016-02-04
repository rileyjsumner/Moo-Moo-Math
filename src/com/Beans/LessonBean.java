package com.Beans;
public class LessonBean {
    public int mode;
    public String Lesson;
    public LessonBean(String lesson,boolean onlylesson){
        mode = 0;
        Lesson = lesson;
        this.Apply(true,true);
    }
    public LessonBean(String lesson){
        mode = 0;
        Lesson = lesson;
    }
    public LessonBean(){
        mode = 0;
        Lesson = "";
    }
    public String GetData(){
        return Lesson;
    }
    public String GetLesson(){
        return Lesson;
    }
    public void AddLine(String Line){
        Lesson+="\n<p>"+Line+"</p>";
    }
    public void Apply(boolean customBtn, boolean standard){
        if(standard){
            Lesson = "\n<div align = \"center\">\n"+Lesson+"\n</div>";
        }
        if(!customBtn){
            Lesson+="\n<div align = \"center\">";
            Lesson+="\n<input type=\"button\" style=\"background-color:#FFDAB9; border: 4px solid #E7C6A5\" onclick=\"document.location.href='UserController?action=lessonDone'\" value=\"Next\"/>";
            Lesson+="\n</div>";
        }
    }
}