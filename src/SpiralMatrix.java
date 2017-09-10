import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix
{
    public List<Integer> spiralOrder( int[][] matrix )
    {
        List<Integer> result = new ArrayList<Integer>();

        if( matrix != null && matrix.length > 0 )
            convertCurLevel( 0, 0, result, matrix );

        return result;
    }

    private void convertCurLevel( int m, int n, List<Integer> result, int[][] matrix )
    {
        if( ( m == ( matrix.length - 1 ) && matrix.length != 1 )
            || n == ( ( matrix[0].length - 1 ) ) && ( matrix[0].length != 1 ) )
            return;

        if( ( m >= ( matrix.length / 2 ) ) )
        {
            for( int i = n; i < ( matrix[0].length - n ); i++ )
                result.add( matrix[m][i] );
            return;
        }

        if( n >= ( matrix[0].length / 2 ) )
        {
            for( int j = m; j < ( matrix.length - m ); j++ )
                result.add( matrix[j][n] );
            return;
        }

        int i = m, j = n;
        for( ; j < ( matrix[0].length - n ); j++ )
            result.add( matrix[i][j] );
        j--;
        i++;
        for( ; i < ( matrix.length - m ); i++ )
            result.add( matrix[i][j] );
        i--;
        j--;
        for( ; j >= n; j-- )
            result.add( matrix[i][j] );
        j++;
        i--;
        for( ; i > m; i-- )
            result.add( matrix[i][j] );

        convertCurLevel( ++m, ++n, result, matrix );
    }

    public static void main( String[] args )
    {
        System.out.println( new SpiralMatrix().spiralOrder( new int[][] { { 1, 2, 3 }, { 4, 5, 6 } } ) );
    }
}
