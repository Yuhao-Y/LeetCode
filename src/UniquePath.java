import java.util.Arrays;

public class UniquePath
{
    public int uniquePaths( int m, int n )
    {
        if( m == 1 || n == 1 )
            return 1;

        int[][] road = new int[m][n];
        
        Arrays.fill( road[0], 1 );
        
        for( int i = 1; i < road.length; i++ )
        {
            for( int j = 0; j < road[0].length; j++ )
            {
                if( j == 0 )
                    road[i][j] = 1;
                else
                {
                    road[i][j] = road[i][j - 1] + road[i - 1][j];
                }
            }
        }

        return road[m - 1][n - 1];
    }
    
    //we can also use the math way:(m-1+n-1)!/((m-1)!(n-1)!), 
    //because for grid mxn, it can down m-1 steps and n-1 steps, the it can be converted a permutation problem
    public int uniquePathsMath( int m, int n)
    {
        int maxNumber = Math.max( m, n );
        
        long sum=1;
        int divisor = 1;
        for( int i=maxNumber;i<=(m-1+n-1);i++)
        {
            sum = sum*i;
        }
        
        for(int i=1;i<(m+n-maxNumber);i++)
        {
            divisor=divisor*i;
        }
        
        return (int)(sum/divisor);
        
    }

    public static void main( String[] args )
    {
        System.out.println( new UniquePath().uniquePathsMath( 10, 10 ) );
    }
}
