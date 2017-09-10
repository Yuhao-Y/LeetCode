
public class Pow
{
    public double myPow( double x, int n )
    {
        if( n == 0 )
            return 1;

        if( n < 0 )
        {
            long nLong = n;
            if( Math.abs( nLong ) > Integer.MAX_VALUE )
            {
                return myPow( x, -Integer.MAX_VALUE );
            }
            n = -n;
            x = 1 / x;
        }
        return ( n % 2 == 0 ) ? myPow( x * x, n / 2 ) : x * myPow( x * x, n / 2 );
    }

    public double myPow2( double x, int n )
    {
        if( n == 0 )
            return 1.0;
        if( n < 0 )
        {
            n = -n;
            return 1.0 / myPow2( x, n );
        }
        double half = myPow2( x, n >> 1 );
        if( n % 2 == 0 )
            return half * half;
        else
            return half * half * x;
    }

    public double myPow3( double x, int n )
    {
        if( n == 0 )
        {
            return 1;
        }

        if( n < 0 )
        {
            n = -n;
            return 1 / myPow3( x, n );
        }

        if( n % 2 == 0 )
        {
            return myPow3( x * x, n >> 1 );
        }
        else
        {
            return x * myPow3( x * x, n >> 1 );
        }
    }

    public static void main( String[] args )
    {
        System.out.println( new Pow().myPow3( 8.88023, 3 ) );
    }
}
