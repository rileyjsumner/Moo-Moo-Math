package Questions;
/**
 * @author samue_schei780
 */
import com.Beans.QuestionBean;
import com.dao.AnswersDao;
import java.util.Random;
public class Questions {
    static Random random = new Random();
    public static QuestionBean getNewQuestion(int UserId, int grade,int lesson){
        int a,b,c;
        QuestionBean bean= new QuestionBean();
        bean.Grade= grade;
        bean.Lesson = lesson;
        switch(grade){
            case 1:
                switch(lesson){
                    case 1:
                        a = random.nextInt(3);
                        switch(a)
                        {
                            case 0:
                                bean.Title="Next Number";
                                b = random.nextInt(100);
                                // What number comes after x?
                                bean.HTML="<p>What number comes after "+b+"?</p>\n";
                                bean.Apply(true, "TEXT");
                                b++;
                                AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(b),2);
                                break;
                            case 1:
                                bean.Title="Previous Number";
                                b = random.nextInt(100);
                                // What number comes after x?
                                bean.HTML="<p>What number comes before "+b+"?</p>\n";
                                bean.Apply(true, "TEXT");
                                b--;
                                AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(b),3);
                                break;
                            case 2:
                                bean.Title="Counting Intervals";
                                c = random.nextInt(5) + 2;
                                b = random.nextInt(4) + 1;
                                bean.HTML = "<p>When counting by " + c + "'s, what number comes after "+(c*b)+"? </p>\n";
                                bean.Apply(true, "TEXT");
                                c=c*(b+1);
                                AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(c), 4);
                                break;
                            case 3:
                                bean.Title="Counting Patterns";
                                b = random.nextInt(100);
                                c = random.nextInt(9) + 1;
                                bean.HTML = "<p>What number comes next in the sequence? \n" + b + ", " + (b + c) + ", " + (b + c * 2) + ", " + (b + c * 3) + ", " + (b + c * 4) + "</p>\n";
                                bean.Apply(true, "TEXT");
                                c = (b + c * 5);
                                AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(c), 5);
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