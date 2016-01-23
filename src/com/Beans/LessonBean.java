package com.Beans;

public class LessonBean {
    public int mode;
    public String Lesson;
    public LessonBean(String lesson){
        int mode = 0;
        Lesson = lesson;
    }
    public String GetLesson(){
        return Lesson;
    }
}