
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
    
    public int removeDuplicates2(int[] nums) {
        int i = 0;
       for (int n : nums)
           if (i < 1 || n > nums[i-1])
               nums[i++] = n;
       return i;
   }
}
