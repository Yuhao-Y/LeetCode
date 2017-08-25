
public class RotateImage
{
    public void rotate( int[][] matrix )
    {

    }

    private void roateRectangle( int[][] matrix, int index )
    {
        for( int i = 0 + index; i < matrix.length - 1; i++ )
        {
            int temp = matrix[i][matrix.length - 1 - i];
            matrix[i][matrix.length - 1 - i] = matrix[index][i];

        }
    }
}
