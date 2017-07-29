
public class RemoveDuplicatesFromSortedArray
{
    public int removeDuplicates( int[] nums )
    {
        if( nums.length == 0 )
            return 0;

        int lengthAfterRmove = 1;

        for( int i = 1, j = 0; i < nums.length; i++ )
        {
            if( nums[i] != nums[j] )
            {
                lengthAfterRmove++;
                if( i != j++ ) nums[j] = nums[i];
            }
        }
        return lengthAfterRmove;
    }
}
