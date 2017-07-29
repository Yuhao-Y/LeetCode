
public class DivideTwoIntegers
{
    public int divide( int dividend, int divisor )
    {
        long result = 0;
        if( dividend == 0 || divisor == 0 )
        {
            return 0;
        }

        long divisorU = divisor > 0 ? divisor : 0 - divisor;
        long dividendU = dividend > 0 ? dividend : (long)0 - dividend;

        if( dividendU >= divisor )
        {
            result = divide( dividendU, divisorU, result );
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
            return (int)result;
        }
    }

    private long divide( long dividend, long divisor, long result )
    {
        if(dividend<divisor) return result;
        
        long sum = divisor;
        long multp = 1;
        while( dividend >= (sum+sum) )
        {
            sum = sum+sum;
            multp = multp+multp;
        }

        result = result+multp;
        
        return divide(dividend-sum, divisor, result);

    }

    public static void main( String[] args )
    {
        System.out.println( new DivideTwoIntegers().divide( 100,10 ) );
    }
}
