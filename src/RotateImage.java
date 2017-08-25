import java.util.Arrays;

public class RotateImage
{
    public void rotate( int[][] matrix )
    {
        if( matrix.length == 0 )
            return;
        roateRectangle2( matrix, 0 );

        // use loop instead of recursion
        //    	for(int index=0;index<(matrix.length/2);index++)
        //        {
        //            if(index>=(matrix.length/2))return;
        //            for( int i = 0 + index; i < matrix.length - 1 -index; i++ )
        //            {
        //                int temp = matrix[index][i];
        //                matrix[index][i] = matrix[matrix.length-1-i][index];
        //                matrix[matrix.length-1-i][index] = matrix[matrix[0].length-1-index][matrix.length-1-i];
        //                matrix[matrix[0].length-1-index][matrix.length-1-i] = matrix[i][matrix.length-1-index];
        //                matrix[i][matrix.length-1-index] = temp;
        //            }
        //        }
    }

    // my own method
    private void roateRectangle( int[][] matrix, int index )
    {
        if( index >= ( matrix.length / 2 ) )
            return;
        for( int i = 0 + index; i < matrix.length - 1 - index; i++ )
        {
            //swap top with right, and save right as temp1
            int temp1 = matrix[i][matrix.length - 1 - index];
            matrix[i][matrix.length - 1 - index] = matrix[index][i];

            //swap right with bottom, and save bottom as temp2
            int temp2 = matrix[matrix[0].length - 1 - index][matrix.length - 1 - i];
            matrix[matrix[0].length - 1 - index][matrix.length - 1 - i] = temp1;

            //swap bottom with leftBottom, and save left as temp1
            temp1 = matrix[matrix.length - 1 - i][index];
            matrix[matrix.length - 1 - i][index] = temp2;

            //swap left with top
            matrix[index][i] = temp1;
        }

        roateRectangle( matrix, ++index );
    }

    //only use one temp variable
    private void roateRectangle2( int[][] matrix, int index )
    {
        if( index >= ( matrix.length / 2 ) )
            return;
        for( int i = 0 + index; i < matrix.length - 1 - index; i++ )
        {
            int temp = matrix[index][i];
            matrix[index][i] = matrix[matrix.length - 1 - i][index];
            matrix[matrix.length - 1 - i][index] = matrix[matrix[0].length - 1 - index][matrix.length - 1 - i];
            matrix[matrix[0].length - 1 - index][matrix.length - 1 - i] = matrix[i][matrix.length - 1 - index];
            matrix[i][matrix.length - 1 - index] = temp;
        }

        roateRectangle( matrix, ++index );
    }

    public static void main( String[] args )
    {
        RotateImage rotateImage = new RotateImage();
        int[][] image = new int[][] { { 1, 2, 3 }, { 3, 4, 5 }, { 5, 6, 7 } };
        rotateImage.rotate( image );

        for( int i = 0; i < image.length; i++ )
        {
            System.out.println( Arrays.toString( image[i] ) );
        }
    }
}
