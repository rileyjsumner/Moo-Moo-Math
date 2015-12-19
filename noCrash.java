package Tutorial;

import java.util.InputMismatchException;
import java.util.Scanner;

public class noCrash 
{
    public static int getInt()
    {
        try
        {
            Scanner ans = new Scanner (System.in);
            return ans.nextInt();
        }
        catch (InputMismatchException e)
        {return (int)(Math.sqrt(-1));}
    }
    public static double getDub()
    {
        try
        {
            Scanner ans = new Scanner (System.in);
            return ans.nextDouble();
        }
        catch (InputMismatchException e)
        {return (Math.sqrt(-1));}
    }
}
