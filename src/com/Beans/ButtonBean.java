package com.Beans;
import java.util.ArrayList;
import java.util.List;
import Util.Util;
/**
 * @author owner
 */
public class ButtonBean {
    public int grades=0;
    public List<List<String>> lessons;
    public ButtonBean(){
        lessons = Util.createArrayList(Util.createArrayList("COUNTING","OTHER"),Util.createArrayList("HHHHHMMMMMM"));
        
    }
    public ButtonBean(int _grades){
        grades = _grades;
    }
    public int GetGrades(){
        return grades;
    }
    
    public String GetData(){
        String ret="";
        for(int i=0;i<lessons.size();i++){
            ret+="\t\t\tcase "+(i+1)+":\n"
                    + "\t\t\t\treturn [";
            for(int j=0;j<(lessons.get(i)).size();j++){
                if(j!=0){ret+=",";}
                ret+="\""+(lessons.get(i)).get(j)+"\"";
            }
            ret+="];\n"
               + "\t\t\t\tbreak;\n";
        }
        return ret;
    }
}