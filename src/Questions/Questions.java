package Questions;
/**
 * @author samue_schei780
 */
import com.Beans.QuestionBean;
import com.dao.AnswersDao;
import java.util.Random;
public class Questions {
    static Random random = new Random();
    public static QuestionBean getNewQuestion(int grade,int lesson){
        QuestionBean bean= new QuestionBean();
        switch(grade){
            case 1:
                switch(lesson){
                    case 1:
                        bean.Title="Next Number";
                        int a = random.nextInt(100);
                        // What number comes after x?
                        bean.HTML="<p>What number comes after "+a+"?</p>\n";
                        bean.Apply(true, "TEXT", grade, lesson);
                        AnswersDao.safeCreateAnswer(1, grade, lesson, Integer.toString(a+1));
                        break;
                }
            case 2:
                switch(lesson){
                    
                }
                break;
            case 3:
                switch(lesson){
                    
                }
                break;
            case 4:
                switch(lesson){
                    
                }
                break;
            case 5:
                switch(lesson){
                    
                }
                break;
            default:
                
        }
    bean.Grade=grade;
    bean.Lesson =lesson;
    return bean;
    }
}