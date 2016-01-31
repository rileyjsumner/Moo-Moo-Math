package com.Beans;
public class LessonBean {
    public int mode;
    public String Lesson;
    public LessonBean(String lesson){
        mode = 0;
        Lesson = lesson;
    }
    public LessonBean(){
        mode = 0;
        Lesson = "";
    }
    public String GetLesson(){
        return Lesson;
    }
    public void AddLine(String Line){
        Lesson+="<p>"+Line+"</p>";
    }
    public void Apply(boolean CustomNextBtn){
        if(!CustomNextBtn){
            
        }
    }
    /*
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
    }*/
}