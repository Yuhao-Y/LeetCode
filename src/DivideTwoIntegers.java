
public class DivideTwoIntegers
{
    public int divide( int dividend, int divisor )
    {
        long result = 0;
        if( dividend == 0 || divisor == 0 )
        {
            return 0;
        }

        if( divisor == 1 )
        {
            return dividend;
        }

        long divisorU = Math.abs( (long) divisor );
        long dividendU = Math.abs( (long) dividend );

        if( dividendU >= divisorU )
        {
            result = divide2( dividendU, divisorU, result );
        }

        if( ( dividend < 0 && divisor > 0 ) || ( dividend > 0 && divisor < 0 ) )
        {
            result = 0 - result;
        }

        if( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE )
        {
            return Integer.MAX_VALUE;
        }
        else
        {
            return (int) result;
        }
    }

    private long divide( long dividend, long divisor, long result )
    {
        if( dividend < divisor )
            return result;

        long sum = divisor;
        long multp = 1;
        while( dividend >= ( sum + sum ) )
        {
            sum = sum + sum;
            multp = multp + multp;
        }

        result = result + multp;

        return divide( dividend - sum, divisor, result );

    }

    private long divide2( long dividend, long divisor, long result )
    {
        if( dividend < divisor )
            return result;

        while( dividend >= divisor )
        {
            long digits = 0;
            while( dividend > ( divisor << 1 ) )
            {
                divisor = divisor << 1;
                digits++;
            }

            dividend = dividend - divisor;
            result = result + ( 1 << digits );
            divisor = divisor >> digits;
        }

        return result;
    }

    public static void main( String[] args )
    {
        System.out.println( new DivideTwoIntegers().divide( 2147483647, 2 ) );
    }
}
