import java.util.Arrays;

public class RemoveElement
{
    public int removeElement( int[] nums, int val )
    {
        int lengthAfterRemove = 0;
        Arrays.sort( nums );
        for( int i = 0; i < nums.length; i++ )
        {
            if( nums[i] == val )
            {
                int tailIndex = nums.length - 1;
                while( i < nums.length && nums[i] == val )
                {
                    if( nums[tailIndex] != val )
                    {
                        nums[i] = nums[tailIndex];
                        tailIndex--;
                    }
                    lengthAfterRemove++;
                    i++;
                }
                break;
            }
        }
        return nums.length - lengthAfterRemove;
    }

    public static void main( String[] args )
    {
        int[] nums = { 1, 3, 2, 4, 8, 3 };
        System.out.println( new RemoveElement().removeElement( nums, 3 ) );
        System.out.println( Arrays.toString( nums ) );
    }
}
