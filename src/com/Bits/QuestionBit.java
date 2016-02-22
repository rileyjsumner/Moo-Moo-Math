package com.Bits;
/**
 * @author owner
 */
public class QuestionBit {
    public int Id;
    public int Grade;
    public int Lesson;
    public int Points;
    public int HelpType;
    public String Text;
    public String Answer;
    public QuestionBit(){
        
    }
    public QuestionBit(int id,int grade,int points, int lesson,String text, String answer,int helpType){
        Id=id;
        Grade=grade;
        Points=points;
        Lesson=lesson;
        Text=text;
        Answer=answer;
        HelpType=helpType;
    }
    public int GetId(){
        return Id;
    }
    public int GetGrade(){
        return Grade;
    }
    public int GetHelpType(){
        return HelpType;
    }
    public int GetPoints(){
        return Points;
    }
    public int GetLesson(){
        return Lesson;
    }
    public String GetText(){
        return Text;
    }
    public String GetAnswer(){
        return Answer;
    }
}