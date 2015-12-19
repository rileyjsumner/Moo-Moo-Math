package Tutorial;

public class findKeyword 
{
    public static int findKeyword(String statement, String goal, int startPos) // Find Keyword 
    {
        String phrase = statement.trim();
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
            while (psn >= 0) 
            {
                String before = " ", after = " "; 
                    if (psn > 0)
                    {before = phrase.substring (psn - 1, psn).toLowerCase();}
                    if (psn + goal.length() < phrase.length())
                    {after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();}

                    if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))
                        && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
                    {return psn;}
                psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
            }
        return -1;
    }
    public static int findKeyword(String statement, String goal) // Find Keyword
    {return findKeyword (statement, goal, 0);}
}
