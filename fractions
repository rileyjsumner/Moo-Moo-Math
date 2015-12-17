
package Tutorial;

public class Fraction 
{
    public int n, d;
    public Fraction()
    {
        n = 0; d = 0;
    }
    public Fraction(int numerator, int denominator)
    {
        n = numerator; d = denominator;
    }
    public void simplify()
    {
        for (int x = d; x >= 1; x--)
        {
            if ((n % x == 0) && (d % x == 0))
            {n = n / x; d = d / x;}
        }
    }
    public Fraction addFrac(Fraction fraction)
    {
        Fraction temp = new Fraction(n, d);
        int e = 0;
        if (temp.d != fraction.d)
        {
            e = temp.d * fraction.d;
            temp.d *= fraction.d;
            temp.n *= fraction.d;
        }
        temp.n += fraction.n;
        temp.simplify();
        return temp;
    }
    public Fraction subFrac(Fraction fraction)
    {
       Fraction temp = new Fraction(n, d);
        int e = 0;
        if (temp.d != fraction.d)
        {
            e = temp.d * fraction.d;
            temp.d *= fraction.d;
            temp.n *= fraction.d;
        }
        temp.n -= fraction.n;
        temp.simplify();
        return temp;
    }
    public Fraction mulFrac(Fraction fraction)
    {return new Fraction(n * fraction.n, d * fraction.d);}
    public Fraction divFrac(Fraction fraction)
    {return new Fraction(n * fraction.d, d * fraction.n);}
    public String getString()
    {
        if (n == d)
        {return "1";}
        return n + "/" + d;
    }
}
