
public class RemoveDuplicatesFromSortedArrayII
{
    public int removeDuplicates( int[] nums )
    {
        if( nums.length == 0 )
            return 0;
        int slow = 0, fast = 1;
        int duplicateTime = 0;

        while( fast < nums.length )
        {
            if( nums[slow] != nums[fast] )
            {
                nums[++slow] = nums[fast];
                duplicateTime = 0;
            }
            else
            {
                if( duplicateTime < 1 )
                {
                    nums[++slow] = nums[fast];
                    duplicateTime++;
                }
            }

            fast++;
        }

        return slow + 1;
    }
    
    
    // the 2 in the if statement can be change to any number that allow to be duplicate
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
