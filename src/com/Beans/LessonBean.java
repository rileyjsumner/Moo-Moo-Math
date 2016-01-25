package com.Beans;
import java.util.*;
public class LessonBean {
    public int mode;
    public List<String> Lessons;
    public int stage;
    public LessonBean(List<String> lessons){
        mode = 0;
        stage =0;
        Lessons = lessons;
    }
    public LessonBean(){
        mode = 0;
        Lessons = new ArrayList<>();
        System.out.println("HERE!! MADE");
    }
    public void AddLesson(String lesson){
        Lessons.add(lesson);
    }
    public String GetNextLesson(){
        if(stage < Lessons.size()){
            stage+=1;
            System.out.println("Stage = "+(stage-1));
            System.out.println(Lessons.get(stage-1));
            return Lessons.get(stage-1);
        }
        System.out.println("DONE");
        return "DONE";
    }
    public String GetLesson(int lesson){
        return Lessons.get(lesson);
    }
}