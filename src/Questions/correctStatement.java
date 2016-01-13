package Questions;

import static Questions.Converter;

public class correctStatement 
{
    public static void correctInt(int x, int y)
    {
        if (x == y)
        {
            System.out.println("Correct!");
            addPoints(10);
        }
        else
        {System.out.println("Incorrect. The correct answer is " + x);}
    }
    public static void correctDouble(double x2, double y2)
    {
        if (x2 == y2)
        {
            System.out.println("Correct!");
            addPoints(10);
        }
        else
        {System.out.println("Incorrect. The correct answer is " + x2);}
    }
    public static void correctString(String x1, String y1)
    {
        if (x1.equals(y1))
        {
            System.out.println("Correct!");
            addPoints(10);
        }
        else
        {System.out.println("Incorrect. The correct answer is " + x1);}
    }
}
