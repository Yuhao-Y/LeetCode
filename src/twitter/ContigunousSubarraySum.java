package twitter;

public class ContigunousSubarraySum
{
    public int sum( int[] array )
    {
        int result = 0;
        int lastSum = 0;
        for( int i = 0; i < array.length; i++ )
        {
            int sum = ( lastSum + ( i + 1 ) * array[i] );
            result = result + sum;
            lastSum = sum;
        }
        return result;
    }

    public static void main( String[] args )
    {
        ContigunousSubarraySum c = new ContigunousSubarraySum();
        System.out.println( c.sum( new int[] { 2, 3, 4 } ) );
    }
}
