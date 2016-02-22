package Questions;
/**
 * @author samue_schei780
 */
import com.Beans.QuestionBean;
import com.dao.AnswersDao;
import java.util.Random;
import java.util.Arrays;
public class Questions {
    static Random random = new Random();
    public static QuestionBean getNewQuestion(int UserId, int grade,int lesson){
        QuestionBean bean= new QuestionBean();
        bean.Grade= grade;
        bean.Lesson = lesson;
        switch(grade){
            case 1:
                switch(lesson){
                    case 2:
                        int kek = random.nextInt(4);
                        switch(kek)
                        {
                            case 0:
                                bean.Title="Next Number";
                                int a = random.nextInt(100);
                                // What number comes after x?
                                bean.HTML="<p>What number comes after "+a+"?</p>\n";
                                bean.Apply(true, "TEXT");
                                a++;
                                AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(a), 1);
                                break;
                            case 1:
                                bean.Title="Counting Intervals";
                                int b = random.nextInt(10);
                                int c = random.nextInt(9) + 1;
                                b*=c;
                                bean.HTML = "<p>When counting by " + c + "'s, what number comes after "+b+"? </p>\n";
                                bean.Apply(true, "TEXT");
                                b+=c;
                                AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(b), 6);
                                break;
                            case 2:
                                bean.Title="Counting Patterns";
                                int d = random.nextInt(100);
                                int e = random.nextInt(9) + 1;
                                bean.HTML = "<p>What number comes next in the sequence? \n" + d + ", " + (d + e) + ", " + (d + e * 2) + ", " + (d + e * 3) + ", " + (d + e * 4) + "</p>\n";
                                bean.Apply(true, "TEXT");
                                d = (d + (e * 5));
                                AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(d), 6);
                                break;
			     case 3:
				bean.Title="Odd or Even";
				int f = random.nextInt(100) + 1;
				double a1 = f%2;
				boolean a2 = false;
				bean.HTML = "<p>This number is even: (true or false) " + f + "</p>\n";
				bean.Apply(true, "TEXT");
				if (a1 == 0) 
                                {a2 = true;}
				AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(a2), 5);
				break;
                             case 4:
                                bean.Title="Previous Number";
                                int ds = random.nextInt(100);
                                // What number comes after x?
                                bean.HTML="<p>What number comes before "+ds+"?</p>\n";
                                bean.Apply(true, "TEXT");
                                ds--;
                                AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(ds), 2);
                                break;
                        }
			 break;
                    case 1:
			bean.Title="Addition";
			int g = random.nextInt(10) + 10;
			int h = random.nextInt(10);
			bean.HTML = "<p>What is " + g + " + " + h + "?</p>\n";
			bean.Apply(true, "TEXT");
			int i = g + h;
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(i), 1);
			break;
		     case 3:
			bean.Title="Subtraction";
			int j = random.nextInt(10) + 10;
			int k = random.nextInt(10);
			bean.HTML = "<p>What is " + j + " - " + k + "?</p>\n";
			bean.Apply(true, "TEXT");
			int l = j - k;
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(l), 2);
			break;
		    case 4:
			bean.Title="Measurement";
			int n = random.nextInt(19) + 1;
			String a3 = "How many feet can you make with " + n + " inches? ";
			String b3 = "How many centimeters can you make with " + n + " millimeters? ";
			String c3 = "How many tablespoons can you make with " + n + " teaspoons? ";
			String d3 = "How many gallons can you make with " + n + " quarts? ";
			String e3 = "How many quarts can you make with " + n + " pints? ";
			String f3 = "How many pounds can you make with " + n + " ounces? ";
			String[] g3 = {a3, b3, c3, d3, e3, f3};
			int o = random.nextInt(5);
			int p = 0;
			bean.HTML="<p>" + g3[o] + "</p>\n";
			bean.Apply(true, "TEXT");
			if (o == 0){p = n / 12;}
			else if (o == 1){p = n / 10;}
			else if (o == 2){p = n / 3;}
			else if (o == 3){p = n / 4;}
			else if (o == 4){p = n / 2;}
			else if (o == 5){p = n / 16;}
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(p), 0);
			break;
                }
		break;
            case 2:
                switch(lesson){
                    case 1:
			bean.Title = "3 Digit Addition";
			int q = random.nextInt(899) + 100;
			int r = random.nextInt(89) + 10;
			bean.HTML="<p>What is " + q + " + " + r + "?</p>\n";
			bean.Apply(true, "TEXT");
			int s = q + r;
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(s), 1);
			break;
		     case 2:
		     	bean.Title = "3 digit Subtraction";
			int t = random.nextInt(899) + 100;
			int u = random.nextInt(89) + 10;
			bean.HTML="<p>What is " + t + " - " + u + "?</p>\n";
			bean.Apply(true, "TEXT");
			int v = t - u;
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(v), 2);
			break; 
		     case 3:
		     	int hoon = random.nextInt(2);
			switch(hoon)
			{
			     case 0:
				  bean.Title="Counting Intervals";
                                int w = random.nextInt(100);
                                int x = random.nextInt(9) + 1;
                                bean.HTML = "<p>When counting by " + x + "'s, what number comes after "+w+"? </p>\n";
                                bean.Apply(true, "TEXT");
                                w+=x;
                                AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(w), 6);
                                break;
			     case 1:
				  bean.Title="Counting Patterns";
                                int y = random.nextInt(100);
                                int z = random.nextInt(9) + 1;
                                bean.HTML = "<p>What number comes next in the sequence? \n" + y + ", " + (y + z) + ", " + (y + z * 2) + ", " + (y + z * 3) + ", " + (y + z * 4) + "</p>\n";
                                bean.Apply(true, "TEXT");
                                y = (y + z * 5);
                                AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(y), 6);
                                break;
			     case 2:
				  bean.Title="Odd or Even";
				  int aa = random.nextInt(100) + 1;
		  		  double b1 = aa%2;
				  boolean c2 = false;
				  bean.HTML = "<p>This number is even: (true or false) " + aa + "</p>\n";
				  bean.Apply(true, "TEXT");
				  if (b1 == 0) {c2 = true;}
				  AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(c2), 5);
				  break;
			}
			break;
		     case 4:
			bean.Title="Probability";
			int ab = random.nextInt(10);
			int ac = random.nextInt(10);
			int ad = random.nextInt(10);
			int ae = random.nextInt(2);
			String[] h3 = {"red", "blue", "green"};
			String i3 = "I have " + ab + " red marbles, " + ac + " blue marbles, and " + ad + " green marbles. ";
			String j3 = "If I put all the marbles in a bag, What is the probability I pick a " + h3[ae] + " marble?";
			bean.HTML="<p>"+ i3 + "\n" + j3 + "</p>\n";
			bean.Apply(true, "TEXT");
			int af = ab + ac + ad;
			String k3 = null;
			if (ae == 0)
			{k3 = ab + "/" + af;}
			else if (ae == 1)
			{k3 = ac + "/" + af;}
			else if (ae == 2);
			{k3 = ad + "/" + af;}
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(k3), 7);
			break;
                }
                break;
            case 3:
                switch(lesson){
		    case 1:
			bean.Title = "Multiplication";
			int ag = random.nextInt(10);
			int ah = random.nextInt(10);
			bean.HTML="<p>What is " + ag + " x " + ah + "?</p>\n";
			bean.Apply(true, "TEXT");
			int ai = ag * ah;
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(ai), 3);
			break;
		    case 2:
			bean.Title="Division";
			int aj = random.nextInt(10) + 1;
			int ak = random.nextInt(10) + 1;
			int al = aj * ak;
			int[] am = {aj, ak};
			int an = random.nextInt(1);
			bean.HTML="<p>What is " + al + " / " + am[an] + "?</p>\n";
			bean.Apply(true, "TEXT");
			int ao = al / am[an];
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(ao), 4);
			break;
		    case 3:
			bean.Title="Fractions";
			int ap = random.nextInt(4);
			int aq = random.nextInt(4) * ap;
			aq+=3;
			String[] l3 = {"Joe", "Steve", "Billy", "Jack", "Bob", "Ben", "Sarah", "Sally", "Amelia", "Susan", "Madison", "Hannah"};
			String[] m3 = {" cookies", " slices of pizza", " watermelons", " pies", " candies"};
			int ar = random.nextInt(4);
			int as = random.nextInt(11);
			String n3 = null;
			    if (as <= 5) {n3 = "He";}
			    else {n3 = "She";}
			String o3 = l3[as]+" has "+aq+m3[ar]+". "+n3+" eats "+ap+" of them. What fraction did "+n3+" eat?";
			bean.HTML="<p>" + o3 + "</p>\n";
			bean.Apply(true, "TEXT");
			String p3 = ap + "/" + aq;
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(p3), 8);
			break; 
		    case 4:
			int kekhoon = random.nextInt(1);
			switch(kekhoon) {
			    case 0:
				bean.Title="Highest Number";
				int at = random.nextInt(9);
				int au = random.nextInt(9);
				int av = random.nextInt(9);
				int aw = random.nextInt(9);
				int ax = random.nextInt(9);
				int ay = random.nextInt(9);
				bean.HTML="<p>What is the biggest number you can get from these digits?\n" +at+", "+au+", "+av+", "+aw+", "+ax+", "+ay+"</p\n";
				bean.Apply(true, "TEXT");
				int az[] = {at, au, av, aw, ax, ay};
				Arrays.sort(az);
				String q3 = ""+az[0]+az[1]+az[2]+az[3]+az[4]+az[5];
				AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(q3), 13);
				break;
			    /*case 1:
				bean.Title="Guess My Number";
				int ba = random.nextInt(15);
				int bb = random.nextInt(15);
				int bc = ba + bb; int bd = 0;
				    if (ba > bb){bd = ba - bb;}
				    else if (ba < bb){bd = bb - ba;}
				bean.HTML="<p>The sum of 2 numbers is "+bc+". The difference of 2 numbers is "+bd+".\nWhat are the two numbers?</p>\n";
				bean.Apply(true, "TEXT(2)");
				AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(ba)+","+String.valueOf(bb), 0);
				break;*/
			    case 1:
				bean.Title="Guess My Number";
				int be = random.nextInt(150);
				int bf = random.nextInt(10) + 5;
				int bg = random.nextInt(98)-bf;
				int bh = 0;
				if (bg <= 0){bg+=15;}
				int bi = (int)Math.log10(be)+ 1;
				if(be%9==0){bean.HTML="<p>You say me when you count by 9’s. </p>\n";bh=9;}
				else if(be%8==0){bean.HTML="<p>You say me when you count by 8’s. </p>\n";bh=8;}
				else if(be%7==0){bean.HTML="<p>You say me when you count by 7’s. </p>\n";bh=7;}
				else if(be%6==0){bean.HTML="<p>You say me when you count by 6’s. </p>\n";bh=6;}
				else if(be%5==0){bean.HTML="<p>You say me when you count by 5’s. </p>\n";bh=5;}
				else if(be%4==0){bean.HTML="<p>You say me when you count by 4’s. </p>\n";bh=4;}
				else if(be%3==0){bean.HTML="<p>You say me when you count by 3’s. </p>\n";bh=3;}
				else if(be%2==0){bean.HTML="<p>You say me when you count by 2’s. </p>\n";bh=2;}
				else {bean.HTML="<p>I am a prime number. </p>\n"; bh = 3;}
				int bj = be - bh; int bk = be+bh;
				bean.HTML="<p>I am greater than "+bj+", but less than "+bk+".</p>\n";
				bean.Apply(true, "TEXT");
				AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(be), 0);
				break;
			    }
			break;
		    case 5:
			bean.Title="Money";
			int bl =random.nextInt(5);
			int bm =random.nextInt(5);
			int bn =random.nextInt(5);
			int bo =random.nextInt(5);
			double b1 = ((double)(bl * 25) / 100);
			double c1 = ((double)(bm * 10) / 100);
			double d1 = ((double)(bn * 5) / 100);
			double e1 = ((double)(bo) / 100);
			String q3="I have "+bl+" quarter"+(bl>1?"s":"")+", "+bm+" dime"+(bm>1?"s":"")+", "+bn+" nickel"+(bn>1?"s":"")+", and "+bo+" penn"+(bo>1?"ies":"y")+". \n";
			String r3="How many cents do I have?";
			bean.HTML="<p>"+q3+r3+"</p>\n";
			bean.Apply(true, "TEXT");
			double f1 = b1+c1+d1+e1;
			AnswersDao.safeCreateAnswer(UserId, grade,lesson, String.valueOf(f1), 9);
			break;
		    case 6:
			bean.Title="Geometry";
			int bp = random.nextInt(9)+1;
			int bq = random.nextInt(9)+1;
			bean.HTML="<p>A rectangle is "+bp+" inches by "+bq+" inches. What is the area in inches squared?</p>\n";
			bean.Apply(true, "TEXT");
			int br = bp*bq;
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(br), 10);
			break;
                }
                break;
            case 4:
                switch(lesson){
                    case 1:
			bean.Title="Equations";
			int bs = random.nextInt(9) + 1;
			int bt = random.nextInt(9) + 1;
			String[] s3 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
			int bu = random.nextInt(25);
			bean.HTML="<p>What is "+bs+" + "+s3[bu]+" if "+s3[bu]+" = "+bt+"?</p>\n";
			bean.Apply(true, "TEXT");
			int bv = bs+bt;
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(bv), 11);
			break;
		    case 2:
			int hoonkek = random.nextInt(2);
			switch (hoonkek)
			{
			    case 0:
				bean.Title="Place Value";
				int bw = random.nextInt(9);
				int bx = random.nextInt(9);
				int by = random.nextInt(9);
				int bz = random.nextInt(9);
				int ca = random.nextInt(9);
				int cb = random.nextInt(9);
				String t3 = bw+bx+by+"."+bz+ca+cb;
				int cc[] = {bw, bx, by, bz, ca, cb};
				String u3[]={"hundreds", "tens", "ones", "tenths", "hundredths", "thousandths"};
				int cd = random.nextInt(5);
				bean.HTML="<p>"+t3+"\nWhat number is in the "+ u3[cd]+"’s place?";
				bean.Apply(true, "TEXT");
				AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(cc[cd]), 12);
				break;
                            case 1:
                                bean.Title="Greater Than, Less Than";
                                int ce = random.nextInt(9);
                                int cf = random.nextInt(9);
                                int cg = random.nextInt(9);
                                int ch = random.nextInt(9);
                                int ci = random.nextInt(9);
                                int cj = random.nextInt(9);
                                double g1 = ((double)ce/10) + ((double)cf/100) + ((double)cg/1000);
                                g1 = Math.round(g1*1000d);
                                double h1 = ((double)ch/10) + ((double)ci/100) + ((double)cj/1000);
                                h1 = Math.round(h1*1000d);
                                bean.HTML="<p>What number is larger?\n" +g1+ " or " +h1+"</p>\n";
                                bean.Apply(true, "TEXT");
                                boolean d2;
                                if (g1>h1) {d2=true;}
                                else {d2=false;}
                                AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(d2), 13);
                                break;
                          case 2:
                                bean.Title="Greater Than, Less Than";
                                int ck = random.nextInt(9);
                                int cl = random.nextInt(9);
                                int cm = random.nextInt(9);
                                int cn = random.nextInt(9);
                                int co = random.nextInt(9);
                                int cp = random.nextInt(9);
                                double j1 = ((double)ck/10) + ((double)cl/100) + ((double)cm/1000);
                                j1 = Math.round(j1*1000d);
                                double k1 = ((double)cn/10) + ((double)co/100) + ((double)cp/1000);
                                k1 = Math.round(k1*1000d);
                                bean.HTML="<p>What number is smaller?\n" +j1+ " or " +k1+"</p>\n";
                                bean.Apply(true, "TEXT");
                                boolean e2;
                                if (j1>k1) {e2=true;}
                                else {e2=false;}
                                AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(e2), 13);
                                break;
			}
			break;
		    case 3:
			bean.Title="Geometry";
			String v3[] = {"Joe", "Steve", "Billy", "Jack", "Bob", "Ben", "Sarah", "Sally", "Amelia", "Susan", "Madison", "Hannah"};
			int cq = random.nextInt(11);
			int cr = random.nextInt(9) + 1;
			int cs = random.nextInt(19) + 1;
			int ct = random.nextInt(9) + 1;
			int cu = cs * ct;
			int cv = cr * cu;
			String w3 = null;
			if(cq <=5){w3 = "his";}
			else {w3 = "his";}
			String x3 = v3[cq]+" wants to put tile in "+w3+" house. The room is "+cs+ " by "+ct+" feet. Tile is $"+cr+" a square foot. How much will the entire room cost?";
			bean.HTML="<p>"+x3+"</p>\n";
			bean.Apply(true, "TEXT");
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(cv), 10);
			break;
                }
                break;
            case 5:
                switch(lesson){
		    case 1:
			bean.Title="Ratios";
			int cw = random.nextInt(9) + 1;
			int cx = random.nextInt(9) + 1;
			int cy = random.nextInt(9) + 1;
			int cz = random.nextInt(9) + 1;
			boolean[] f2 = {true, false, true, false, true, false, true, false, true};
			int da = random.nextInt(7);
			int db = 0; int dc = 0;
			if (f2[da] == true){db = cy; dc = cy;}
			else {db = cy; dc = cz;}
			int dd = cw * db;
			int de = cx * dc;
			bean.HTML="<p>Are these two ratios equivalent?:\n" + cw+":"+db+" and "+cx+":"+dc+"?</p>\n";
			bean.Apply(true, "TEXT");
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(f2[da]), 14);
			break;
		    case 2:
			bean.Title="Add Decimals";
			int df = random.nextInt(10);
			int dg = random.nextInt(10);
			int dh = random.nextInt(10);
			int di = random.nextInt(10);
			double l1 = df + ((double)dh/10);
			double m1 = dg + ((double)di/10);
			bean.HTML="<p>What is "+l1+" + "+m1+"?</p>\n";
			bean.Apply(true, "TEXT");
			double n1 = l1+m1;
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(n1), 1);
		    case 3:
			bean.Title="Subtract Decimals";
			int dj = random.nextInt(4)+5;
			int dk = random.nextInt(4);
			int dl = random.nextInt(10);
			int dm = random.nextInt(10);
			double o1 = dj + ((double)dl/10);
			double p1 = dk + ((double)dm/10);
			bean.HTML="<p>What is "+o1+" - "+p1+"?</p>\n";
			bean.Apply(true, "TEXT");
			double q1 = p1-o1;
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(q1), 2);
		    case 4:
			bean.Title="Multiply Decimals";
			int dn = random.nextInt(10);
			int dr = random.nextInt(10);
			int dp = random.nextInt(10);
			int dq = random.nextInt(10);
			double r1 = dn + ((double)dp/10);
			double s1 = dr + ((double)dq/10);
			bean.HTML="<p>What is "+r1+" x "+s1+"?</p>\n";
			bean.Apply(true, "TEXT");
			double t1 = r1*s1;
			AnswersDao.safeCreateAnswer(UserId, grade, lesson, String.valueOf(t1), 3);
                }
                break;
            default:
                
        }
    return bean;
    }
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