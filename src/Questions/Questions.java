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
        bean.Grade= grade;
        bean.Lesson = lesson;
        switch(grade){
            case 1:
                switch(lesson){
                    case 1:
                        int kek = random.nextInt(2);
                        switch(kek)
                        {
                            case 0:
                                bean.Title="Next Number";
                                int a = random.nextInt(100);
                                // What number comes after x?
                                bean.HTML="<p>What number comes after "+a+"?</p>\n";
                                bean.Apply(true, "TEXT");
                                a++;
                                AnswersDao.safeCreateAnswer(1, grade, lesson, String.valueOf(a),bean.HTML,2);
                                break;
                            case 1:
                                bean.Title="Counting Intervals";
                                int b = random.nextInt(100);
                                int c = random.nextInt(9) + 1;
                                bean.HTML = "<p>When counting by " + c + "'s, what number comes after "+b+"? </p>\n";
                                bean.Apply(true, "TEXT");
                                b+=c;
                                AnswersDao.safeCreateAnswer(1, grade, lesson, String.valueOf(b), bean.HTML, 3);
                                break;
                            case 2:
                                bean.Title="Counting Patterns";
                                int d = random.nextInt(100);
                                int e = random.nextInt(9) + 1;
                                bean.HTML = "<p>What number comes next in the sequence? \n" + d + ", " + (d + e) + ", " + (d + e * 2) + ", " + (d + e * 3) + ", " + (d + e * 4) + "</p>\n";
                                bean.Apply(true, "TEXT");
                                d = (d + e * 5);
                                AnswersDao.safeCreateAnswer(1, grade, lesson, String.valueOf(d), bean.HTML, 4);
                                break;
                        }
                    case 2:
                        
                    
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
    return bean;
    }
}