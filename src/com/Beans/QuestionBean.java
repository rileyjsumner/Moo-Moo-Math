package com.Beans;
/**
 * @author samue_schei780
 */
public class QuestionBean {
    public String HTML;
    public QuestionBean(){
        HTML = "";
    }
    public QuestionBean(String html){
        HTML = html;
    }
    public void Apply(boolean standard,String returning ,int grade, int lesson){
        if(standard){
            HTML = "\n<div align = \"center\">\n"+HTML+"\n</div>";
        }
        if(returning.equals("TEXT")){
            HTML+="<form action = \"UserController\">\n"
                    + "ANSWER: <input type=\"text\" name=\"answer\"\n"
                    + "<input type =\"hidden\" name=\"grade\" value="+grade+"."+lesson+">\n"
                    + "</form>";
        }
    }
    public String GetData(){
        return HTML;
    }
}