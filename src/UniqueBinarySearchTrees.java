import java.util.Arrays;

public class UniqueBinarySearchTrees
{
    public int numTrees( int n )
    {
        if( n <= 0 )
            return 0;
        if( n == 1 )
            return 1;

        int[] countBinarySearchTrees = new int[n];
        countBinarySearchTrees[0] = 1;
        for( int i = 1; i < n; i++ )
        {
            for( int j = 0; j <= i; j++ )
            {
                int left = ( j - 1 ) < 0 ? 1 : countBinarySearchTrees[j - 1];
                int right = ( i - j - 1 ) < 0 ? 1 : countBinarySearchTrees[i - j - 1];

                countBinarySearchTrees[i] = countBinarySearchTrees[i] + left * right;
            }
        }

        System.out.println( Arrays.toString( countBinarySearchTrees ) );

        return countBinarySearchTrees[n - 1];

    }

    public int numTrees2( int n )
    {
        if( n <= 0 )
            return 0;
        if( n == 1 )
            return 1;

        int[] countBinarySearchTrees = new int[n + 1];
        countBinarySearchTrees[0] = countBinarySearchTrees[1] = 1;
        for( int i = 2; i <= n; i++ )
        {
            for( int j = 1; j <= i; j++ )
            {
                countBinarySearchTrees[i] = countBinarySearchTrees[i]
                    + countBinarySearchTrees[j - 1] * countBinarySearchTrees[i - j];
            }
        }

        return countBinarySearchTrees[n];
    }

    public static void main( String args[] )
    {
        System.out.println( new UniqueBinarySearchTrees().numTrees2( 3 ) );
    }
}
