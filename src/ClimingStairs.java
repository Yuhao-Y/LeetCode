
public class ClimingStairs
{
    //Tn=O(n^2)
    public int climbStairs( int n )
    {
        int climbWays = 1;
        if( n < 2 )
            return climbWays;

        int i = 1, j = n - 1;
        while( i <= j )
        {
            climbWays += permutationNum( j, i );
            i++;
            j--;
        }

        return climbWays;
    }

    public int permutationNum( int low, int high )
    {
        long sum = 1;
        long divisor = 1;
        for( int i = 1, j = low; i <= ( high ); i++, j-- )
        {
            sum *= j;
            divisor = divisor * i;
            long quotient = sum / divisor;
            if( sum == quotient * divisor )
            {
                sum = quotient;
                divisor = 1;
            }
        }

        return (int)sum;
    }

    //Tn=O(n)
    public int climbStairsDP( int n )
    {
        if( n == 1 )
            return 1;
        if( n == 2 )
            return 2;

        int result = 0;
        int lastTwoStep = 1;
        int lastOneStep = 2;
        for( int i = 3; i <= n; i++ )
        {
            result = lastTwoStep + lastOneStep;
            lastTwoStep = lastOneStep;
            lastOneStep = result;
        }

        return result;
    }

    public static void main( String[] args )
    {
        System.out.println( new ClimingStairs().climbStairs(44) );
        System.out.println( new ClimingStairs().climbStairsDP(44) );
    }
}
