
public class MoveZeros
{
    //O(n^2)
    public void moveZeroes( int[] nums )
    {
        int begin = 0, end = nums.length - 1;
        while( begin < end )
        {
            if( nums[begin] == 0 )
            {
                System.arraycopy( nums, begin + 1, nums, begin, end - begin );
                nums[end--] = 0;
            }
            else
            {
                begin++;
            }

        }
    }

    //O(n)
    public void moveZeroes2( int[] nums )
    {
        int position = 0;
        for( int i = 0; i < nums.length; i++ )
        {
            if( nums[i] != 0 )
            {
                nums[position++] = nums[i];
            }
        }
        
        while(position<nums.length)
        {
            nums[position++] = 0; 
        }
    }
}
