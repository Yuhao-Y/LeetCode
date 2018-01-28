import java.util.Arrays;

public class MaximalSquare
{
    public int maximalSquare( char[][] matrix )
    {
        char[] temp = new char[matrix[0].length];
        Arrays.fill( temp, '1' );
        int local = 0;
        int gobal = 0;

        for( int i = 0; i < matrix.length; )
        {
            int count = 0;
            int maxCount = 0;
            for( int j = 0; j < temp.length; j++ )
            {
                temp[j] = String
                    .valueOf( ( Character.getNumericValue( temp[j] ) ) & ( Character.getNumericValue( matrix[i][j] ) ) )
                    .toCharArray()[0];
            }

            for( int j = 0; j < temp.length; j++ )
            {
                if( temp[j] == '1' )
                {
                    count++;
                    maxCount = Math.max( count, maxCount );
                }
                else
                {
                    count = 0;
                }
            }

            local = local + 1;
            if( maxCount >= local )
            {
                gobal = Math.max( gobal, local );
                i++;
            }
            else
            {
                local = 0;
                Arrays.fill( temp, '1' );
                if( maxCount == 0 )
                    i++;
            }

        }

        return gobal * gobal;
    }

    public int dp( char[][] matrix )
    {
        if( matrix == null || matrix.length < 1 || matrix[0].length < 1 )
            return 0;

        int maxLength = 0;

        int[][] dp = new int[matrix.length+1][matrix[0].length+1];

        for( int i = 1; i <= matrix.length; i++ )
        {
            for( int j = 1; j <= matrix[0].length; j++ )
            {
                if( matrix[i-1][j-1]=='1' )
                {
                    dp[i][j] = Math.min( dp[i - 1][j - 1], Math.min( dp[i][j - 1], dp[i - 1][j] ) ) + 1;
                    maxLength = Math.max( maxLength, dp[i][j] );
                }
            }
        }

        return maxLength * maxLength;
    }

    public static void main( String[] args )
    {
                System.out.println( new MaximalSquare().maximalSquare( new char[][]{{'1','0','1','0','1'},
                                                                                    {'1','0','1','1','1'},
                                                                                    {'1','1','1','1','1'},
                                                                                    {'1','0','0','1','0'}} ) );
//        System.out.println( new MaximalSquare().dp( new char[][] { { '0', '0', '0', '1' }, 
//                                                                   { '1', '1', '0', '1' },
//                                                                   { '1', '1', '1', '1' }, 
//                                                                   { '0', '1', '1', '1' }, 
//                                                                   { '1', '1', '1', '1' } } ) );
    }
}
