package Questions;

import java.util.Arrays;
import java.util.Random;
public class Converter 
{
    static int    correctAnsInt;
    static double correctAnsDub;
    static String correctAnsStr;
    static int points;
    public static String newQuestion(int unit) 
    {
        int     a,  b,  c,  d,  e,  f,  g,  h,  i,  j,  k,  l,  m,  n,  o,  p,  q,  r,  s,  t,  u,  v,  w,  x,  y,  z;
        String a1, b1, c1, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1, q1, r1, s1, t1, u1, v1, w1, x1, y1, z1;
        double a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n2, o2, p2, q2, r2, s2, t2, u2, v2, w2, x2, y2, z2;
        Fraction a4, b4;
        String returnStr = null;
        Random num = new Random();
        switch (unit)
        {
            case 11: // Counting and number patterns
                    a = num.nextInt(100);
                    c = a + 1;
                    // What number comes after x? 
                    returnStr = ("What number comes after " + a + "? ");
                    a = num.nextInt(9) + 1;
                    b = num.nextInt(99) + 1;
                    // When counting by x's, what number comes after y?
                    returnStr = ("When counting by " + a + "'s, what number comes after " + b + "? ");
                    c = a + b;
                    a = num.nextInt(100) + 1;
                    b = num.nextInt(10) + 1;
                    // What number comes next? x, y, z, ?
                    returnStr = ("What number comes next in the sequence? ");
                    returnStr = (a + ", " + (a + b) + ", " + (a + b * 2) + ", " + (a + b * 3) + ", " + (a + b * 4) + ", ");
                    c = a + b * 5;
                    // Odd or Even?
                    a = num.nextInt(100) + 1;
                    returnStr = ("Is this number even? (yes or no) " + a);
            break;
            case 12: // Addition
                c = num.nextInt(10) + 10;
                    d = num.nextInt(10);
                    // What is x + y?
                    returnStr = ("What is " + c + " + " + d + "? ");
                    e = c + d;
            break;
            case 13: // Subtraction
                f = num.nextInt(10) + 10;
                    g = num.nextInt(10);
                    
                    // What is x - y?
                    returnStr = ("What is " + f + " - " + g + "? ");
                    h = f - g;
            break;
            case 14: // Geometry
                // What shape has n sides?
                    n = num.nextInt(6) + 3;
                    returnStr = ("Give me a shape that has " + n + " sides? ");
            break;
            case 15: // Measurement
               int in = 0, cm = 0, ft = 0, mm = 0, yd = 0, tbsp = 0, tsp = 0, pint = 0, qrt = 0, qurt = 0, gal = 0, oz = 0, lb = 0;
                    a = num.nextInt(19) + 1;
                    a1 = "How many feet can you make with " + a + " inches? ";
                    b1 = "How many centimeters can you make with " + a + " millimeters? ";
                    c1 = "How many tablespoons can you make with " + a + " teaspoons? ";
                    d1 = "How many gallons can you make with " + a + " quarts? ";
                    e1 = "How many quarts can you make with " + a + " pints? ";
                    f1 = "How many pounds can you make with " + a + " ounces? ";
                    String[] v3 = {a1, b1, c1, d1, e1, f1};
                    b = num.nextInt(5);
                    returnStr = (v3[b]);
                        if (b == 0){e = a / 12;}
                        else if (b == 1){e = a / 10;}
                        else if (b == 2){e = a / 3;}
                        else if (b == 3){e = a / 4;}
                        else if (b == 4){e = a / 2;}
                        else if (b == 5){e = a / 16;}
            case 21: // 3 digit addition
               s = num.nextInt(899) + 100;
                    r = num.nextInt(89) + 10;
                    // What is x + y?
                    returnStr = ("What is " + s + " + " + r + "? ");
                    g = s + r;
            break;
            case 22: // 3 digit subtraction
                s = num.nextInt(899) + 100;
                    r = num.nextInt(98) + 1;
                    // What is x - y?
                    returnStr = ("What is " + s + " - " + r + "? ");
                    g = s - r;
            break;
            case 23: // Counting and number patterns
                a = num.nextInt(19) + 1;
                    b = num.nextInt(99) + 1;
                    // When counting by x's, what number comes after y?
                    returnStr = ("When counting by " + a + "'s, what number comes after " + b + "? ");
                    c = a + b;
                    a = num.nextInt(99) + 1;
                    b = num.nextInt(19) + 1;
                    // What number comes next? x, y, z, ?
                    returnStr = ("What number comes next in the sequence? ");
                    returnStr = (a + ", " + (a + b) + ", " + (a + b * 2) + ", " + (a + b * 3) + ", " + (a + b * 4) + ", ");
                    c = a + b * 5;
                    // Odd or Even?
                    a = num.nextInt(100) + 1;
                    returnStr = ("Is this number even? (yes or no) " + a);
            break;
            case 24: // Patterns
                String[] f3 = {"triangle", "square", "rectangle", "pentagon", "hexagon", "circle", "star", "heart", "upsidedown triangle", "diamond"};
                    String[] z3 = {"red", "orange", "yellow", "green", "blue", "violet", "white", "black", "pink", "grey", "brown"};
                        a = num.nextInt(9);
                        b = num.nextInt(9);
                        c = num.nextInt(9);
                        d = num.nextInt(10);
                        e = num.nextInt(10);
                        f = num.nextInt(10);
                    String[] y3 = {z3[d] + " " + f3[a], z3[e] + " " + f3[b], z3[f] + " " + f3[c]};
                    a1 = y3[0] + ", " +  y3[1] + ", " + y3[2];
                    returnStr = (a1 + ", " + a1 + ", " + a1);
                    returnStr = ("What color is the next shape? ");
            break;
            case 25: // Probability
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
                    returnStr = (x1 + y1);
                    e = a + b + c;
                    z1 = null;
                        if (d == 0)
                        {z1 = a + "/" + e;}
                        else if (d == 1)
                        {z1 = b + "/" + e;}
                        else if (d == 2)
                        {z1 = c + "/" + e;}
                }
            break;
            case 31: // Multiplication
                f = num.nextInt(10);
                    g = num.nextInt(10);
                    
                    // What is x * y?
                    returnStr = ("What is " + f + " * " + g + "? ");
                    h = f * g;
            break;
            case 32: // Division
                f = num.nextInt(10) + 1;
                    l = num.nextInt(10) + 1;
                    g = f * l;
                    int[] h3;
                    h3 = new int[2];
                    h3[0] = f;
                    h3[1] = l;
                    x = num.nextInt(1);
                    // What is x / y?
                    returnStr = ("What is " + g + " / " + h3[x] + "? ");
                    h = g / h3[x];
            break;
            case 33: // Fractions
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
                    returnStr = (q1);
                    x1 = a + "/" + b;
            break;
            case 34: // Logical Reasoning
                a = num.nextInt(9);
                    b = num.nextInt(9);
                    c = num.nextInt(9);
                    d = num.nextInt(9);
                    e = num.nextInt(9);
                    f = num.nextInt(9);
                    // What is the highest number you can make from: a, b, c, d, e, f?
                    a1 = a + " " + b + " " + c + " " + d  + " " + e + " " + f;
                    returnStr = ("What is the highest number you can make from these digits?: \n" + a1 + " ");
                    int j3[] = {a, b, c, d, e, f};
                    Arrays.sort(j3);
                        h = j3[j3.length-1];
                        i = j3[j3.length-2];
                        j = j3[j3.length-3];
                        k = j3[j3.length-4];
                        l = j3[j3.length-5];
                        m = j3[j3.length-6];
                    b1 =  h + "" +  i + j + k + l + m;
                    n = num.nextInt(15);
                    o = num.nextInt(15);
                    p = n + o;
                    q = 0;
                        if  (n > o)
                        {q = n - o;}
                        else if (n < o)
                        {q = o - n;}
                    // The sum of 2 numbers is x, the difference is y. What are the numbers?
                    returnStr = ("The sum of 2 numbers is " + p + ". The difference of the 2 numbers is " + q + ". \nWhat is number 1? ");
                    returnStr = ("What is number 2? ");
                    t = num.nextInt(150);
                    u = num.nextInt(10) + 5;
                    v = num.nextInt(98) - u;
                    a = 0;
                        if (v <= 0)
                        {v = v + 10;}
                    // Guess my number
                    w = (int)Math.log10(t) + 1;
                    returnStr = ("I am a " + w + "-digit number. ");
                        if(t % 9 == 0)
                        {returnStr = ("You say me when you count by 9's. ");a = 9;}
                        else if (t % 8 == 0)
                        {returnStr = ("You say me when you count by 8's. ");a = 8;}
                        else if (t % 7 == 0)
                        {returnStr = ("You say me when you count by 7's. ");a = 7;}
                        else if (t % 6 == 0)
                        {returnStr = ("You say me when you count by 6's. ");a = 6;}
                        else if (t % 5 == 0)
                        {returnStr = ("You say me when you count by 5's. ");a = 5;}
                        else if (t % 4 == 0)
                        {returnStr = ("You say me when you count by 4's. ");a = 4;}
                        else if (t % 3 == 0)
                        {returnStr = ("You say me when you count by 3's. ");a = 3;}
                        else if (t % 2 == 0)
                        {returnStr = ("You say me when you count by 2's. ");a = 2;}
                        else
                        {returnStr = ("I am a prime number. ");a = 3;}
                    z = t - a;
                    x = t + a;
                    returnStr = ("I am greater than " + z + ", but less than " + x + ". ");
            break;
            case 35: // Money
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
                    returnStr = (j1);
                    f2 = q2 + n2 + e2 + r2;
            break;
            case 36: // Geometry
                a = num.nextInt(9) + 1;
                    b = num.nextInt(9) + 1;
                    s1 = "A shape is " + a + " inches by " + b + " inches. What is the area in square inches? ";
                    returnStr = (s1);
            case 41: // Equations
                c = num.nextInt(10) + 1;
                    t = num.nextInt(10) + 1;
                    String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
                    h = num.nextInt(25);
                    l = t + c;
                    // What is x + n if n = y?
                    returnStr = ("What is " + c + " + " + alpha[h] + " if " + alpha[h] + " = " + t + "? ");
            break;
            case 42: // Adding Fractions
                a4 = new Fraction();
                b4 = new Fraction();
                a4.n = num.nextInt(3) + 2;
                    a4.d = num.nextInt(2) + 5;
                    b4.n = num.nextInt(3) + 2;
                    b4.d = num.nextInt(2) + 5;
                    a4.simplify();
                    b4.simplify();
                    returnStr = ("What is " + a4.getString() + " + " + b4.getString() + "? ");
                    o1 = a4.addFrac(b4).getString();
            case 43: // Subtracting Fractions
                a4 = new Fraction();
                b4 = new Fraction();
                a = num.nextInt(4) + 2; a4.n = a;
                    b = num.nextInt(4) + 5; a4.d = b;
                    c = num.nextInt(4) + 1; b4.n = c;
                    d = num.nextInt(4) + 6; b4.d = d;
                    a4.simplify();
                    b4.simplify();
                    o1 = null;
                    if ((a / b) > (c / d))
                    {
                        returnStr = ("What is " + a4.getString() + " - " + b4.getString() + "? ");
                        o1 = a4.subFrac(b4).getString();
                    }
                    else if ((a / b) < (c / d))
                    {
                        returnStr = ("What is " + b4.getString() + " - " + a4.getString() + "? ");
                        o1 = b4.subFrac(a4).getString();
                    }
            case 44: // What's my rule?
                r = num.nextInt(39) + 10;
                    s = num.nextInt(39) + 10;
                    t = num.nextInt(39) + 10;
                    y = num.nextInt(39) + 10;
                    z = num.nextInt(39) + 10;
                    n = num.nextInt(10) + 1;
                    boolean[] x3 = {true, false, false, true, false, false, true, false, false, false};
                    b = num.nextInt(9);
                        returnStr = ("   in    *   out   ");
                        returnStr = ("*******************");
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + r + "   *    " + (r+n) + "    ");}
                        else
                        {returnStr = ("    " + r + "   *    " + (r+n) + "    ");}
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + s + "   *    " + (s+n) + "    ");}
                        else
                        {returnStr = ("    *    *    " + (s+n) + "    ");}
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + t + "   *    " + (t+n) + "    ");}
                        else
                        {returnStr = ("    " + y + "   *    *    ");}
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + z + "   *    " + (z+n) + "    ");}
                        else
                        {returnStr = ("    " + z + "   *    *    ");}
                    // What's my rule?
                    returnStr = ("What's my rule? +");
                    // What's my rule?
                        returnStr = ("   in    *   out   ");
                        returnStr = ("*******************");
                        n = num.nextInt(10) + 1;
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + r + "   *    " + (r-n) + "    ");}
                        else
                        {returnStr = ("    " + r + "   *    " + (r-n) + "    ");}
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + s + "   *    " + (s-n) + "    ");}
                        else
                        {returnStr = ("    *    *    " + (s-n) + "    ");}
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + t + "   *    " + (t-n) + "    ");}
                        else
                        {returnStr = ("    " + y + "   *    *    ");}
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + z + "   *    " + (z-n) + "    ");}
                        else
                        {returnStr = ("    " + z + "   *    *    ");}
                    returnStr = ("What's my rule? -");
                    returnStr = ("   in    *   out   ");
                    returnStr = ("*******************");
                    r = num.nextInt(8) + 1;
                    s = num.nextInt(8) + 1;
                    t = num.nextInt(8) + 1;
                    y = num.nextInt(9) + 1;
                    z = num.nextInt(8) + 1;
                    n = num.nextInt(10) + 1;
                    b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + r + "   *    " + (r*n) + "    ");}
                        else
                        {returnStr = ("    " + r + "   *    " + (r*n) + "    ");}
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + s + "   *    " + (s*n) + "    ");}
                        else
                        {returnStr = ("    *   *    " + (s*n) + "    ");}
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + t + "   *    " + (t*n) + "    ");}
                        else
                        {returnStr = ("    " + y + "   *    *    ");}
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + z + "   *    " + (z*n) + "    ");}
                        else
                        {returnStr = ("    " + z + "   *    *    ");}
                    // What's my Rule?
                    returnStr = ("What's my rule? *");
                    returnStr = ("   in    *   out   ");
                    returnStr = ("*******************");
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
                        if (x3[b] == true)
                        {returnStr = ("    " + r + "   *    " + (r/n) + "    ");}
                        else
                        {returnStr = ("    " + r + "   *    " + (r/n) + "    ");}
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + s + "   *    " + (s/n) + "    ");}
                        else
                        {returnStr = ("    *    *    " + (s/n) + "    ");}
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + t + "   *    " + (t/n) + "    ");}
                        else
                        {returnStr = ("    " + y + "   *    *    ");}
                        b = num.nextInt(9);
                        if (x3[b] == true)
                        {returnStr = ("    " + z + "   *    " + (z/n) + "    ");}
                        else
                        {returnStr = ("    " + z + "   *    *    ");}
                    // What's my rule?
                    returnStr = ("What's my rule? /");
            break;
            case 45: // Decimals
                a = num.nextInt(9);
                    b = num.nextInt(9);
                    c = num.nextInt(9);
                    d = num.nextInt(9);
                    e = num.nextInt(9);
                    f = num.nextInt(9);
                    a1 = a + "" + b + "" + c + "." + d  + "" + e + "" + f;
                    int c3[] = {a, b, c, d, e, f};
                    // What number is in the __ths place?
                    String[] d3 = {"hundreds", "tens", "ones", "tenths", "hundredths", "thousandths"};
                    g = num.nextInt(5);
                    d1 = "What number is in the " + d3[g] + " place? \n" + a1 + ": ";
                    returnStr = (d1);
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
                    String[] n3 = {"largest", "smallest"};
                    o = num.nextInt(1);
                    i1 = "Which number is the " + n3[o] + "?\n" + e1 + " or " + h1 + " ";
                    // Which number is (largest or smallest)? .xyz or .abc
                    returnStr = (i1);
            case 46: // Geometry
                String m3[] = {"Joe", "Steve", "Billy", "Jack", "Bob", "Ben", "Sarah", "Sally", "Amelia", "Susan", "Madison", "Hannah"};
                    a = num.nextInt(11);
                    r1 = m3[a];
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
                    returnStr = (z1 + y1);
            break;
            case 51: // Ratios
                a = num.nextInt(9) + 1;
                    b = num.nextInt(9) + 1;
                    c = num.nextInt(9) + 1;
                    d = num.nextInt(9) + 1;
                    boolean[] a3 = {true, false, true, false, true, false, true, false, true};
                    j = num.nextInt(8) + 1;
                    e = 0;
                    f = 0;
                        if (a3[j] == true)
                        {e = c; f = c;}
                        else if (a3[j] == false)
                        {e = c; f = d;}
                    g = a * e;
                    h = b * f;
                    // is x:y equivalent to a:b?
                    returnStr = ("Are these two ratios equivalent?: \n" + a + ":" + g + " and " + b + ":" + h + "? ");
                    i = num.nextInt(10) * 10;
                    k = num.nextInt(99) + 1;
                    // What is x% of y?
                    returnStr = ("What is " + i + "% of " + k + "? ");
                    l2 = ((double)(i)/100) * k;
                    g2 = Math.round(l2 * 10d);
            break;
            case 52: // Multiply fractions
                a4 = new Fraction();
                b4 = new Fraction();
                a4.n = num.nextInt(3) + 2;
                    a4.d = num.nextInt(2) + 5;
                    b4.n = num.nextInt(3) + 2;
                    b4.d = num.nextInt(2) + 5;
                    a4.simplify();
                    b4.simplify();
                    returnStr = ("What is " + a4.getString() + " * " + b4.getString() + "? ");
                    o1 = a4.mulFrac(b4).getString();
            break;
            case 53: // Divide fractions
                a4 = new Fraction();
                b4 = new Fraction();
                a = num.nextInt(4) + 2; a4.n = a;
                    b = num.nextInt(4) + 5; a4.d = b;
                    c = num.nextInt(4) + 1; b4.n = c;
                    d = num.nextInt(4) + 6; b4.d = d;
                    a4.simplify();
                    b4.simplify();
                    t1 = null;
                    if ((a / b) >= (c / d))
                    {
                        returnStr = ("What is " + a4.getString() + " / " + b4.getString() + "? ");
                        t1 = a4.divFrac(b4).getString();
                    }
                    else if ((a / b) < (c / d))
                    {
                        returnStr = ("What is " + b4.getString() + " / " + a4.getString() + "? ");
                        t1 = b4.divFrac(a4).getString();
                    }
                    t1 = a4.divFrac(b4).getString();
            break;
            case 54: // Add Decimals
                p = num.nextInt(10) + 1;
                    t = num.nextInt(10) + 1;
                    i = num.nextInt(10) + 1;
                    j = num.nextInt(10) + 1;
                    s2 = p + ((double)j/10);
                    z2 = t + ((double)i/10);
                    // What is x.0 + y.0?
                    returnStr = ("What is " + s2 + " + " + z2 + "? ");
                    m2 = s2 + z2;
            break;
            case 55: // Subtract Decimals
               p = num.nextInt(10) + 1;
                    t = num.nextInt(10) + 1;
                    i = num.nextInt(10) + 1;
                    j = num.nextInt(10) + 1;
                    x2 = p + ((double)j/10);
                    v2 = t + ((double)i/10);
                    // What is x.0 - y.0?
                    returnStr = ("What is " + x2 + " - " + v2 + "? ");
                    u2 = (x2 - v2);
            break;
            case 56: // Multiply Decimals
               p = num.nextInt(10) + 1;
                    t = num.nextInt(10) + 1;
                    i = num.nextInt(10) + 1;
                    j = num.nextInt(10) + 1;
                    w2 = p + ((double)j/10);
                    v2 = t + ((double)i/10);
                    // What is x.0 * y.0?
                    returnStr = ("What is " + w2 + " * " + v2 + "? ");
                    u2 = w2 * v2;
            break;
            case 57: // Divide decimals
                p = num.nextInt(10) + 1;
                    t = num.nextInt(10) + 1;
                    i = num.nextInt(10) + 1;
                    j = num.nextInt(10) + 1;
                    y2 = p + ((double)j/10);
                    v2 = t + ((double)i/10);
                    double [] divisors = new double [2];
                    divisors[0] = y2;
                    divisors[1] = v2;
                    t2 = y2 * v2;
                    m = num.nextInt(1);
                    // What is x.0 / y.0?
                    returnStr = ("What is " + t2 + " / " + divisors[m] + "? ");
                    k2 = divisors[m];
                    o2 = t2 / k2;
            break;
        }
        return "ok";
    }
}
