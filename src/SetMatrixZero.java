import java.util.Arrays;

public class SetMatrixZero
{
    public void setZeroes( int[][] matrix )
    {
        boolean row = false, column = false;

        for( int i = 0; i < matrix.length; i++ )
        {
            for( int j = 0; j < matrix[0].length; j++ )
            {
                if( matrix[i][j] == 0 )
                {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if( i == 0 )
                        row = true;
                    if( j == 0 )
                        column = true;
                }
            }
        }

        for( int i = 1; i < matrix[0].length; i++ )
        {
            if( matrix[0][i] == 0 )
            {
                for( int j = 0; j < matrix.length; j++ )
                {
                    matrix[j][i] = 0;
                }
            }
        }

        for( int i = 1; i < matrix.length; i++ )
        {
            if( matrix[i][0] == 0 )
            {
                Arrays.fill( matrix[i], 0 );
            }
        }

        if( row )
        {
            Arrays.fill( matrix[0], 0 );
        }

        if( column )
        {
            for( int i = 0; i < matrix.length; i++ )
            {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main( String[] args )
    {
        //int[][] a = {{0,1,1},{1,1,0},{1,1,1}};
        //int[][] a = {{0,1}};
        int[][] a = { { 0, 1, }, { 1, 0 }, { 1, 1 } };
        new SetMatrixZero().setZeroes( a );

        for( int b[] : a )
        {
            System.out.println( Arrays.toString( b ) );
        }
    }
}
