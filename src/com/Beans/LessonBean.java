package com.Beans;
import java.util.*;
public class LessonBean {
    public int mode;
    public List<String> Lessons;
    public LessonBean(List<String> lessons){
        int mode = 0;
        Lessons = lessons;
    }
    public LessonBean(){
        int mode = 0;
    }
    public void AddLesson(String lesson){
        Lessons.add(lesson);
    }
    public String GetLesson(int lesson){
        return Lessons.get(lesson);
    }
}