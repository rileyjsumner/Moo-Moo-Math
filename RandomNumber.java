package Tutorial;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import static Tutorial.findKeyword.*;
import static Tutorial.correctStatement.*;
import static Tutorial.noCrash.*;
public class RandomNumber 
{
    @SuppressWarnings("null")
    static int points = 0;
    public static void addPoints(int _points)
    {points += _points;}
    
    public static void main (String args[])
    {
        double lesson = 0.0;
        Random num = new Random();
        Scanner ans = new Scanner (System.in);
        Scanner ans2 = new Scanner (System.in);
            int     a,  b,  c,  d,  e,  f,  g,  h,  i,  j,  k,  l,  m,  n,  o,  p,  q,  r,  s,  t,  u,  v,  w,  x,  y,  z;
            String a1, b1, c1, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1, q1, r1, s1, t1, u1, v1, w1, x1, y1, z1;
            double a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n2, o2, p2, q2, r2, s2, t2, u2, v2, w2, x2, y2, z2;
            Fraction a4, b4;
        System.out.print("What lesson are you doing? ");
            lesson = getDub();
            lesson = lesson * 10;
        int learn = (int) lesson;
        switch (learn)
        {
            case 11: // Counting and number patterns
                points = 0;
                while(points < 100)
                {
                    a = num.nextInt(100);
                    c = a + 1;
                    // What number comes after x? 
                    System.out.print("What number comes after " + a + "? ");
                    x = getInt();
                    correctInt(c, x);
                    a = num.nextInt(9) + 1;
                    b = num.nextInt(99) + 1;
                    // When counting by x's, what number comes after y?
                    System.out.print("When counting by " + a + "'s, what number comes after " + b + "? ");
                    z = getInt();
                    c = a + b;
                    correctInt(c, z);
                    a = num.nextInt(100) + 1;
                    b = num.nextInt(10) + 1;
                    // What number comes next? x, y, z, ?
                    System.out.println("What number comes next in the sequence? ");
                    System.out.print(a + ", " + (a + b) + ", " + (a + b * 2) + ", " + (a + b * 3) + ", " + (a + b * 4) + ", ");
                    y = getInt();
                    c = a + b * 5;
                    correctInt(c, y);
                    // Odd or Even?
                    a = num.nextInt(100) + 1;
                    System.out.println("Is this number even? (yes or no) " + a);
                    w1 = ans2.nextLine();
                    w1 = w1.toLowerCase();
                    boolean b3 = a % 2==0;
                        if (b3 == true && w1.equals("yes"))
                        {
                            System.out.println("Correct!");
                            addPoints(10);
                        }
                        else if (b3 == false && w1.equals("no"))
                        {
                            System.out.println("Correct!");
                            addPoints(10);
                        }
                        else
                        {System.out.println("Incorrect");}
                }
            break;
            case 12: // Addition
                points = 0;
                while (points < 100)
                {
                    c = num.nextInt(10) + 10;
                    d = num.nextInt(10);
                    // What is x + y?
                    System.out.print("What is " + c + " + " + d + "? ");
                    v = getInt();
                    e = c + d;
                    correctInt(e, v);
                }
            break;
            case 13: // Subtraction
                points = 0;
                while (points < 100)
                {
                    f = num.nextInt(10) + 10;
                    g = num.nextInt(10);
                    
                    // What is x - y?
                    System.out.print("What is " + f + " - " + g + "? ");
                    v = getInt();
                    h = f - g;
                    correctInt(h, v);
                }
            break;
            case 14: // Geometry
                points = 0;
                while (points < 60)
                {
                    // What shape has n sides?
                    n = num.nextInt(6) + 3;
                    System.out.print("Give me a shape that has " + n + " sides? ");
                    k1 = ans2.nextLine();
                    m1 = k1.substring(0,3);
                    r1 = null;
                    boolean g3 = false;
                    if (n == 3)
                    {
                        if (findKeyword(m1, "tri") >= 0
                            || (findKeyword(m1, "try")) >= 0)
                        {g3 = true; r1 = "triangle";}
                    }
                    else if (n == 4)
                    {
                        if (findKeyword(m1, "squ") >= 0
                            || (findKeyword(m1, "sqw") >= 0)
                            || (findKeyword(m1, "sqa") >= 0)
                            || (findKeyword(m1, "rec")) >= 0)
                        {g3 = true; r1 = "square or rectangle";}
                    }
                    else if (n == 5)
                    {
                        if (findKeyword(m1, "pen") >= 0)
                        {g3 = true; r1 = "pentagon";}
                    }
                    else if (n == 6)
                    {
                        if (findKeyword(m1, "hex") >= 0)
                        {g3 = true; r1 = "hexagon";}
                    }
                    else if (n == 7)
                    {
                        if (findKeyword(m1, "hep") >= 0)
                        {g3 = true; r1 = "heptagon";}
                    }
                    else if (n == 8)
                    {
                        if (findKeyword(m1, "oct") >= 0
                            || (findKeyword(m1, "okt")) >= 0)
                        {g3 = true; r1 = "octagon";}
                    }
                        if (g3 == true)
                        {
                            System.out.println("Correct!");
                            addPoints(10);
                        }
                        else
                        {System.out.println("Incorrect. The correct answer is " + r1);}
                }
            break;
            case 15: // Data and Graphs
                points = 0;
                while (points < 100)
                {
                    
                }
            break;
            case 16: // Measurement
                points = 0;
                while (points < 100)
                {
                    
                }
            case 21: // 3 digit addition
                points = 0;
                while (points < 100)
                {
                    s = num.nextInt(899) + 100;
                    r = num.nextInt(89) + 10;
                    // What is x + y?
                    System.out.print("What is " + s + " + " + r + "? ");
                    q = getInt();
                    g = s + r;
                    correctInt(g, q);
                }
            break;
            case 22: // 3 digit subtraction
                points = 0;
                while (points < 100)
                {
                    s = num.nextInt(899) + 100;
                    r = num.nextInt(98) + 1;
                    // What is x - y?
                    System.out.print("What is " + s + " - " + r + "? ");
                    q = getInt();
                    g = s - r;
                    correctInt(g, q);
                }
            break;
            case 23: // Counting and number patterns
                points = 0;
                while (points < 100)
                {
                    a = num.nextInt(19) + 1;
                    b = num.nextInt(99) + 1;
                    // When counting by x's, what number comes after y?
                    System.out.print("When counting by " + a + "'s, what number comes after " + b + "? ");
                    z = getInt();
                    c = a + b;
                    correctInt(c, z);
                    a = num.nextInt(99) + 1;
                    b = num.nextInt(19) + 1;
                    // What number comes next? x, y, z, ?
                    System.out.println("What number comes next in the sequence? ");
                    System.out.print(a + ", " + (a + b) + ", " + (a + b * 2) + ", " + (a + b * 3) + ", " + (a + b * 4) + ", ");
                    y = getInt();
                    c = a + b * 5;
                    correctInt(c, y);
                    // Odd or Even?
                    a = num.nextInt(100) + 1;
                    System.out.println("Is this number even? (yes or no) " + a);
                    p1 = ans2.nextLine();
                    p1 = p1.toLowerCase();
                    boolean b3 = a % 2==0;
                        if (b3 == true && p1.equals("yes"))
                        {
                            System.out.println("Correct!");
                            addPoints(10);
                        }
                        else if (b3 == false && p1.equals("no"))
                        {
                            System.out.println("Correct!");
                            addPoints(10);
                        }
                        if (b3 == true && p1.equals("no"))
                        {System.out.println("Incorrect. The correct answer is yes");}
                        else if (b3 == false && p1.equals("yes"))
                        {System.out.println("Incorrect. The correct answer is no");}
                        else
                        {System.out.println("Incorrect");}
                }
            break;
            case 24: // Patterns
                points = 0;
                while (points < 100)
                {
                    
                }
            break;
            case 25: // Data and Graphs
                points = 0;
                while (points < 100)
                {
                    
                }
            break;
            case 26: // Probability
                points = 0;
                while (points < 100)
                {
                    a = num.nextInt(10);
                    b = num.nextInt(10);
                    c = num.nextInt(10);
                    d = num.nextInt(2);
                    String[] d3 = {"red", "blue", "green"};
                    x1 = "I have " + a + " red marbles, " + b + " blue marbles, and " + c + " green marbles. ";
                    y1 = "What is the probability I pick a " + d3[d] + " marble? ";
                    System.out.print(x1 + y1);
                    l1 = ans2.nextLine();
                    e = a + b + c;
                    z1 = null;
                        if (d == 0)
                        {z1 = a + "/" + e;}
                        else if (d == 1)
                        {z1 = b + "/" + e;}
                        else if (d == 2)
                        {z1 = c + "/" + e;}
                    correctString(z1, l1);
                }
            break;
            case 31: // Multiplication
                points = 0;
                while (points < 100)
                {
                    f = num.nextInt(10);
                    g = num.nextInt(10);
                    
                    // What is x * y?
                    System.out.print("What is " + f + " * " + g + "? ");
                    v = getInt();
                    h = f * g;
                    correctInt(h, v);
                }
            break;
            case 32: // Division
                points = 0;
                while (points < 100)
                {
                    f = num.nextInt(10) + 1;
                    l = num.nextInt(10) + 1;
                    g = f * l;
                    int[] h3;
                    h3 = new int[2];
                    h3[0] = f;
                    h3[1] = l;
                    x = num.nextInt(1);
                    // What is x / y?
                    System.out.print("What is " + g + " / " + h3[x] + "? ");
                    v = getInt();
                    h = g / h3[x];
                    correctInt(h, v);
                }
            break;
            case 33: // Fractions
                points = 0;
                while (points < 100)
                {
                    a = num.nextInt(4);
                    b = num.nextInt(4) * a;
                    b++; b++; b++;
                    String q3[] = {"Joe", "Steve", "Billy", "Jack", "Bob", "Ben", "Sarah", "Sally", "Amelia", "Susan", "Madison", "Hannah"};
                    String r3[] = {" cookies", " slices of pizza", " watermelons", " pies", " candies"};
                    d = num.nextInt(4);
                    c = num.nextInt(11);
                    v1 = null;
                        if (c <= 5)
                        {v1 = "He";}
                        else
                        {v1 = "She";}
                    g1 = null;
                        if (c <= 5)
                        {g1 = "He";}
                        else
                        {g1 = "She";}
                    q1 = (q3[c] + " has " + b + r3[d] + ". " + v1 + " eats " + a + " of them. What fraction did " + g1 + " eat? ");
                    System.out.print(q1);
                    z1 = ans2.nextLine();
                    x1 = a + "/" + b;
                    correctString(x1, z1);
                }
            break;
            case 34: // Logical Reasoning
                points = 0;
                while (points < 100)
                {
                    a = num.nextInt(9);
                    b = num.nextInt(9);
                    c = num.nextInt(9);
                    d = num.nextInt(9);
                    e = num.nextInt(9);
                    f = num.nextInt(9);
                    // What is the highest number you can make from: a, b, c, d, e, f?
                    a1 = a + " " + b + " " + c + " " + d  + " " + e + " " + f;
                    System.out.print("What is the highest number you can make from these digits?: \n" + a1 + " ");
                    g1 = ans2.nextLine();
                    int h3[] = {a, b, c, d, e, f};
                    Arrays.sort(h3);
                        h = h3[h3.length-1];
                        i = h3[h3.length-2];
                        j = h3[h3.length-3];
                        k = h3[h3.length-4];
                        l = h3[h3.length-5];
                        m = h3[h3.length-6];
                    b1 =  h + "" +  i + j + k + l + m;
                        correctString(g1, b1);
                    n = num.nextInt(15);
                    o = num.nextInt(15);
                    p = n + o;
                    q = 0;
                        if  (n > o)
                        {q = n - o;}
                        else if (n < o)
                        {q = o - n;}
                    // The sum of 2 numbers is x, the difference is y. What are the numbers?
                    System.out.print("The sum of 2 numbers is " + p + ". The difference of the 2 numbers is " + q + ". \nWhat is number 1? ");
                    r = getInt();
                    System.out.print("What is number 2? ");
                    s = getInt();
                        if ((r == n || r == o) && (s == n || s == o))
                        {
                            System.out.println("Correct!");
                            addPoints(10);
                        }
                        else
                        {System.out.println("Incorrect. The correct answers are " + n + " and " + o + ".");}
                    t = num.nextInt(150);
                    u = num.nextInt(10) + 5;
                    v = num.nextInt(98) - u;
                    a = 0;
                        if (v <= 0)
                        {v = v + 10;}
                    // Guess my number
                    w = (int)Math.log10(t) + 1;
                    System.out.print("I am a " + w + "-digit number. ");
                        if(t % 9 == 0)
                        {System.out.print("You say me when you count by 9's. ");a = 9;}
                        else if (t % 8 == 0)
                        {System.out.print("You say me when you count by 8's. ");a = 8;}
                        else if (t % 7 == 0)
                        {System.out.print("You say me when you count by 7's. ");a = 7;}
                        else if (t % 6 == 0)
                        {System.out.print("You say me when you count by 6's. ");a = 6;}
                        else if (t % 5 == 0)
                        {System.out.print("You say me when you count by 5's. ");a = 5;}
                        else if (t % 4 == 0)
                        {System.out.print("You say me when you count by 4's. ");a = 4;}
                        else if (t % 3 == 0)
                        {System.out.print("You say me when you count by 3's. ");a = 3;}
                        else if (t % 2 == 0)
                        {System.out.print("You say me when you count by 2's. ");a = 2;}
                        else
                        {System.out.print("I am a prime number. ");a = 3;}
                    z = t - a;
                    x = t + a;
                    System.out.print("I am greater than " + z + ", but less than " + x + ". ");
                    y = getInt();
                    correctInt(t, y);
                }
            break;
            case 35: // Money
                points = 0;
                while (points < 100)
                {
                    a = num.nextInt(5);
                    b = num.nextInt(5);
                    c = num.nextInt(5);
                    d = num.nextInt(5);
                    q2 = ((double)(a * 25) / 100);
                    n2 = ((double)(b * 10) / 100);
                    e2 = ((double)(c * 5) / 100);
                    r2 = ((double)(d) / 100);
                    j1 = "I have " + a + " quarter" + (a > 1?"s":"") + ", " + b + " dime" + (b > 1?"s":"") + ", " + c + " nickel" + (c > 1?"s":"") + " and " + d + " penn" + (c > 1?"ies":"y") + ". How many cents do I have? ¢";
                    // I have q quarters, d dimes, n nickles, and p pennies. How much do I have?
                    System.out.print(j1);
                    e2 = getDub();
                    f2 = q2 + n2 + e2 + r2;
                    correctDouble(f2, e2);
                }
            break;
            case 36: // Geometry
                points = 0;
                while (points < 100)
                {
                    a = num.nextInt(9) + 1;
                    b = num.nextInt(9) + 1;
                    s1 = "A shape is " + a + " inches by " + b + " inches. What is the area in square inches? ";
                    c = a * b;
                    System.out.print(s1);
                    d = getInt();
                    correctInt(c, d);
                }
            case 41: // Equations
                points = 0;
                while (points < 100)
                {
                    c = num.nextInt(10) + 1;
                    t = num.nextInt(10) + 1;
                    String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
                    h = num.nextInt(25);
                    l = t + c;
                    // What is x + n if n = y?
                    System.out.print("What is " + c + " + " + alpha[h] + " if " + alpha[h] + " = " + t + "? ");
                    e = getInt();
                    correctInt(l, e);
                }
            break;
            case 42: // Adding Fractions
                points = 0;
                a4 = new Fraction();
                b4 = new Fraction();
                while (points < 100)
                {
                    a4.n = num.nextInt(3) + 2;
                    a4.d = num.nextInt(2) + 5;
                    b4.n = num.nextInt(3) + 2;
                    b4.d = num.nextInt(2) + 5;
                    a4.simplify();
                    b4.simplify();
                    System.out.print("What is " + a4.getString() + " + " + b4.getString() + "? ");
                    n1 = ans2.nextLine();
                    o1 = a4.addFrac(b4).getString();
                    correctString(o1, n1);
                }
            case 43: // Subtracting Fractions
                points = 0;
                a4 = new Fraction();
                b4 = new Fraction();
                while (points < 100)
                {
                    a = num.nextInt(4) + 2; a4.n = a;
                    b = num.nextInt(4) + 5; a4.d = b;
                    c = num.nextInt(4) + 1; b4.n = c;
                    d = num.nextInt(4) + 6; b4.d = d;
                    a4.simplify();
                    b4.simplify();
                    o1 = null;
                    if ((a / b) > (c / d))
                    {
                        System.out.print("What is " + a4.getString() + " - " + b4.getString() + "? ");
                        o1 = a4.subFrac(b4).getString();
                    }
                    else if ((a / b) < (c / d))
                    {
                        System.out.print("What is " + b4.getString() + " - " + a4.getString() + "? ");
                        o1 = b4.subFrac(a4).getString();
                    }
                    n1 = ans2.nextLine();
                    correctString(o1, n1);
                }
            case 44: // What's my rule?
                points = 0;
                while (points < 100)
                {
                    r = num.nextInt(39) + 10;
                    s = num.nextInt(39) + 10;
                    t = num.nextInt(39) + 10;
                    y = num.nextInt(39) + 10;
                    z = num.nextInt(39) + 10;
                    n = num.nextInt(10) + 1;
                    boolean[] r3 = {true, false, false, true, false, false, true, false, false, false};
                    b = num.nextInt(9);
                        System.out.println("   in    *   out   ");
                        System.out.println("*******************");
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + r + "   *    " + (r+n) + "    ");}
                        else
                        {System.out.println("    " + r + "   *    " + (r+n) + "    ");}
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + s + "   *    " + (s+n) + "    ");}
                        else
                        {System.out.println("    *    *    " + (s+n) + "    ");}
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + t + "   *    " + (t+n) + "    ");}
                        else
                        {System.out.println("    " + y + "   *    *    ");}
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + z + "   *    " + (z+n) + "    ");}
                        else
                        {System.out.println("    " + z + "   *    *    ");}
                    // What's my rule?
                    System.out.print("What's my rule? +");
                    a = getInt();
                    correctInt(n, a);
                    // What's my rule?
                        System.out.println("   in    *   out   ");
                        System.out.println("*******************");
                        n = num.nextInt(10) + 1;
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + r + "   *    " + (r-n) + "    ");}
                        else
                        {System.out.println("    " + r + "   *    " + (r-n) + "    ");}
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + s + "   *    " + (s-n) + "    ");}
                        else
                        {System.out.println("    *    *    " + (s-n) + "    ");}
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + t + "   *    " + (t-n) + "    ");}
                        else
                        {System.out.println("    " + y + "   *    *    ");}
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + z + "   *    " + (z-n) + "    ");}
                        else
                        {System.out.println("    " + z + "   *    *    ");}
                    System.out.print("What's my rule? -");
                    a = getInt();
                    correctInt(n, a);
                    System.out.println("   in    *   out   ");
                    System.out.println("*******************");
                    r = num.nextInt(8) + 1;
                    s = num.nextInt(8) + 1;
                    t = num.nextInt(8) + 1;
                    y = num.nextInt(9) + 1;
                    z = num.nextInt(8) + 1;
                    n = num.nextInt(10) + 1;
                    b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + r + "   *    " + (r*n) + "    ");}
                        else
                        {System.out.println("    " + r + "   *    " + (r*n) + "    ");}
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + s + "   *    " + (s*n) + "    ");}
                        else
                        {System.out.println("    *   *    " + (s*n) + "    ");}
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + t + "   *    " + (t*n) + "    ");}
                        else
                        {System.out.println("    " + y + "   *    *    ");}
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + z + "   *    " + (z*n) + "    ");}
                        else
                        {System.out.println("    " + z + "   *    *    ");}
                    // What's my Rule?
                    System.out.print("What's my rule? *");
                    a = getInt();
                    correctInt(n, a);
                    System.out.println("   in    *   out   ");
                    System.out.println("*******************");
                    n = num.nextInt(10) + 1;
                    r = num.nextInt(4) + 5;
                    r = r * n;
                    s = num.nextInt(4) + 5;
                    s = s * n;
                    t = num.nextInt(4) + 5;
                    t = t * n;
                    y = num.nextInt(4) + 5;
                    y = y * n;
                    z = num.nextInt(4) + 5;
                    z = z * n;
                    b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + r + "   *    " + (r/n) + "    ");}
                        else
                        {System.out.println("    " + r + "   *    " + (r/n) + "    ");}
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + s + "   *    " + (s/n) + "    ");}
                        else
                        {System.out.println("    *    *    " + (s/n) + "    ");}
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + t + "   *    " + (t/n) + "    ");}
                        else
                        {System.out.println("    " + y + "   *    *    ");}
                        b = num.nextInt(9);
                        if (r3[b] == true)
                        {System.out.println("    " + z + "   *    " + (z/n) + "    ");}
                        else
                        {System.out.println("    " + z + "   *    *    ");}
                    // What's my rule?
                    System.out.print("What's my rule? /");
                    a = getInt();
                    correctInt(n, a);
                }
            break;
            case 45: // Decimals
                points = 0;
                while (points < 100)
                {
                    a = num.nextInt(9);
                    b = num.nextInt(9);
                    c = num.nextInt(9);
                    d = num.nextInt(9);
                    e = num.nextInt(9);
                    f = num.nextInt(9);
                    a1 = a + "" + b + "" + c + "." + d  + "" + e + "" + f;
                    int f3[] = {a, b, c, d, e, f};
                    // What number is in the __ths place?
                    String[] d3 = {"hundreds", "tens", "ones", "tenths", "hundredths", "thousandths"};
                    g = num.nextInt(5);
                    d1 = "What number is in the " + d3[g] + " place? \n" + a1 + ": ";
                    System.out.print(d1);
                    h = getInt();
                        if (f3[g] == h)
                        {
                            addPoints(10);
                            System.out.println("Correct!");
                        }
                        else
                        {System.out.println("Incorrect. The correct answer is " + f3[g]);}
                    i = num.nextInt(9);
                    j = num.nextInt(9);
                    k = num.nextInt(9);
                    l = num.nextInt(9);
                    m = num.nextInt(9);
                    n = num.nextInt(9);
                    a2 = ((double)i/10) + ((double)j/100) + ((double)k/1000);
                    a2 = Math.round(a2 * 1000d);
                    b2 = ((double)l/10) + ((double)m/100) + ((double)n/1000);
                    b2 = Math.round(b2 * 1000d);
                    a2 = a2 / 1000; b2 = b2 / 1000;
                    e1 = "." + i + j + k; h1 = "." + l + m + n;
                    String[] x3 = {"largest", "smallest"};
                    o = num.nextInt(1);
                    i1 = "Which number is the " + x3[o] + "?\n" + e1 + " or " + h1 + " ";
                    // Which number is (largest or smallest)? .xyz or .abc
                    System.out.println(i1);
                    p2 = getDub();
                        if (o == 0 && a2 > b2 && a2 == p2)
                        {
                            addPoints(10);
                            System.out.println("Correct!");
                        }
                        else if (o == 0 && a2 < b2 && b2 == p2)
                        {
                            addPoints(10);
                            System.out.println("Correct!");
                        }
                        else if (o == 1 && a2 < b2 && a2 == p2)
                        {
                            addPoints(10);
                            System.out.println("Correct!");
                        }
                        else if (o == 1 && a2 > b2 && b2 == p2)
                        {
                            addPoints(10);
                            System.out.println("Correct!");
                        }
                        else
                        {System.out.println("Incorrect");}
                }
            case 46: // Geometry
                points = 0;
                while (points < 100)
                {
                    String q3[] = {"Joe", "Steve", "Billy", "Jack", "Bob", "Ben", "Sarah", "Sally", "Amelia", "Susan", "Madison", "Hannah"};
                    a = num.nextInt(11);
                    r1 = q3[a];
                    b = num.nextInt(9) + 1;
                    c = num.nextInt(19) + 1;
                    d = num.nextInt(9) + 1;
                    e = c * d;
                    f = b * e;
                    f1 = null;
                        if (a <= 5)
                        {f1 = "his";}
                        else
                        {f1 = "her";}
                    // (name) wants to put tile in his/her house. The room is x * y. Tile costs $z. How much will the whole room cost?
                    z1 = r1 + " wants to put tile in " + f1 + " living room. The room is " + c + " feet by " + d + " feet. ";
                    y1 = "Tile is $" + b + " a square foot. How much will the entire room cost? $";
                    System.out.print(z1 + y1);
                    l = getInt();
                    correctInt(f, l);
                }
            break;
            case 51: // Ratios
                points = 0;
                while (points < 100)
                {
                    a = num.nextInt(9) + 1;
                    b = num.nextInt(9) + 1;
                    c = num.nextInt(9) + 1;
                    d = num.nextInt(9) + 1;
                    boolean[] j3 = {true, false, true, false, true, false, true, false, true};
                    j = num.nextInt(8) + 1;
                    e = 0;
                    f = 0;
                        if (j3[j] == true)
                        {e = c; f = c;}
                        else if (j3[j] == false)
                        {e = c; f = d;}
                    g = a * e;
                    h = b * f;
                    // is x:y equivalent to a:b?
                    System.out.print("Are these two ratios equivalent?: \n" + a + ":" + g + " and " + b + ":" + h + "? ");
                    c1 = ans2.nextLine();
                        if ((c1.equals(("yes")) && j3[j] == true) || (c1.equals(("no")) && j3[j] == false))
                        {
                            addPoints(10);
                            System.out.println("Correct!");
                        }
                        else if (c1.equals(("yes")) && j3[j] == false)
                        {System.out.println("Incorrect. The correct answer is no");}
                        else if (c1.equals(("no")) && j3[j] == true)
                        {System.out.println("Incorrect. The correct answer is yes");}
                        else
                        {{System.out.println("Incorrect");}}
                    i = num.nextInt(10) * 10;
                    k = num.nextInt(99) + 1;
                    // What is x% of y?
                    System.out.print("What is " + i + "% of " + k + "? ");
                    d2 = getDub();
                    l2 = ((double)(i)/100) * k;
                    g2 = Math.round(l2 * 10d);
                    h2 = d2 * 10;
                    correctDouble(h2, g2);
                }
            break;
            case 52: // Multiply fractions
                points = 0;
                a4 = new Fraction();
                b4 = new Fraction();
                while (points < 100)
                {
                    a4.n = num.nextInt(3) + 2;
                    a4.d = num.nextInt(2) + 5;
                    b4.n = num.nextInt(3) + 2;
                    b4.d = num.nextInt(2) + 5;
                    a4.simplify();
                    b4.simplify();
                    System.out.print("What is " + a4.getString() + " * " + b4.getString() + "? ");
                    n1 = ans2.nextLine();
                    o1 = a4.mulFrac(b4).getString();
                    correctString(o1, n1);
                }
            break;
            case 53: // Divide fractions
                points = 0;
                a4 = new Fraction();
                b4 = new Fraction();
                while (points < 100)
                {
                    a = num.nextInt(4) + 2; a4.n = a;
                    b = num.nextInt(4) + 5; a4.d = b;
                    c = num.nextInt(4) + 1; b4.n = c;
                    d = num.nextInt(4) + 6; b4.d = d;
                    a4.simplify();
                    b4.simplify();
                    t1 = null;
                    if ((a / b) >= (c / d))
                    {
                        System.out.print("What is " + a4.getString() + " / " + b4.getString() + "? ");
                        t1 = a4.divFrac(b4).getString();
                    }
                    else if ((a / b) < (c / d))
                    {
                        System.out.print("What is " + b4.getString() + " / " + a4.getString() + "? ");
                        t1 = b4.divFrac(a4).getString();
                    }
                    t1 = a4.divFrac(b4).getString();
                    u1 = ans2.nextLine();
                    correctString(t1, u1);
                }
            break;
            case 54: // Add Decimals
                points = 0;
                while (points < 100)
                {
                    p = num.nextInt(10) + 1;
                    t = num.nextInt(10) + 1;
                    i = num.nextInt(10) + 1;
                    j = num.nextInt(10) + 1;
                    w2 = p + ((double)j/10);
                    v2 = t + ((double)i/10);
                    // What is x.0 + y.0?
                    System.out.print("What is " + w2 + " + " + v2 + "? ");
                    c2 = getDub();
                    u2 = w2 + v2;
                    correctDouble(u2, c2);
                }
            break;
            case 55: // Subtract Decimals
                points = 0;
                while (points < 100)
                {
                    p = num.nextInt(10) + 1;
                    t = num.nextInt(10) + 1;
                    i = num.nextInt(10) + 1;
                    j = num.nextInt(10) + 1;
                    w2 = p + ((double)j/10);
                    v2 = t + ((double)i/10);
                    // What is x.0 - y.0?
                    System.out.print("What is " + w2 + " - " + v2 + "? ");
                    c2 = getDub();
                    u2 = (w2 - v2);
                    correctDouble(u2, c2);
                }
            break;
            case 56: // Multiply Decimals
                points = 0;
                while (points < 100)
                {
                    p = num.nextInt(10) + 1;
                    t = num.nextInt(10) + 1;
                    i = num.nextInt(10) + 1;
                    j = num.nextInt(10) + 1;
                    w2 = p + ((double)j/10);
                    v2 = t + ((double)i/10);
                    // What is x.0 * y.0?
                    System.out.print("What is " + w2 + " * " + v2 + "? ");
                    c2 = getDub();
                    u2 = w2 * v2;
                    correctDouble(u2, c2);
                }
            break;
            case 57: // Divide decimals
                points = 0;
                while (points < 100)
                {
                    p = num.nextInt(10) + 1;
                    t = num.nextInt(10) + 1;
                    i = num.nextInt(10) + 1;
                    j = num.nextInt(10) + 1;
                    w2 = p + ((double)j/10);
                    v2 = t + ((double)i/10);
                    double [] divisors = new double [2];
                    divisors[0] = w2;
                    divisors[1] = v2;
                    t2 = w2 * v2;
                    m = num.nextInt(1);
                    // What is x.0 / y.0?
                    System.out.print("What is " + t2 + " / " + divisors[m] + "? ");
                    c2 = getDub();
                    k2 = divisors[m];
                    u2 = t2 / k2;
                    correctDouble(u2, c2);
                }
            break;
        }
    }
}