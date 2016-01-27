package com.Beans;
import java.util.*;
public class LessonBean {
    public int mode;
    public List<String> Lessons;
    public int stage;
    public int Lesson;
    public LessonBean(List<String> lessons){
        mode = 0;
        stage =0;
        Lesson = 0;
        Lessons = lessons;
    }
    public void SetLesson(int lesson){
        Lesson = lesson;
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
    public String GetLessons(){
        String returnStr
                = "<input type=\"hidden\" name=\"myHiddenField\" id=\"LessonOn\" value=\"-1\" />\n"
                + "<script>\n"
                + "function GetLesson(lesson){\n"
                + "\tswitch(lesson){\n";
        int z = Lessons.size()-1;
        for(int i=0;i<z;i++){
            returnStr
                +="\t\tcase "+i+":\n"
                + "\t\t\treturn '"+Lessons.get(i)+"';\n";
        }
        returnStr
                +="\t}\n"
                + "\tdocument.location.href=\"UserController?action=lessonDone&lesson="+Lesson+"\""
                + "}\n"
                + "function NextLesson(){\n"
                + "\tvar g= 1+parseInt(document.getElementById(\"LessonOn\").value);\n"
                + "\tdocument.getElementById(\"kek1\").innerHTML = GetLesson(g);\n"
                + "\tdocument.getElementById(\"LessonOn\").value = g;\n"
                + "}\n"
                + "</script>\n"
                + "<p id = 'kek1'></p>\n"
                + "<input type = \"button\" style = \"background-color:#FF0000; border: 4px solid #E00000\" onclick = \"NextLesson()\" value = \"1st Grade\"/>";
        return returnStr;
    }
}