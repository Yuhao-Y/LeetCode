import java.util.Arrays;

public class JumpGame
{
    public boolean canJump( int[] nums )
    {
        int max = 0;

        for( int i = 0; i < nums.length; i++ )
        {
            if(i>max) return false;
            max = Math.max( max, i+nums[i] );
        }
        
        return true;
    }

    public static void main( String[] args )
    {
        System.out.println( new JumpGame().canJump( new int[] { 3, 0, 2, 2, 0, 0, 1 } ) );
    }
}
