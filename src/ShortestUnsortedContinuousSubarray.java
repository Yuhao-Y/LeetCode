
public class ShortestUnsortedContinuousSubarray
{
    public int findUnsortedSubarray(int[] nums) {
        if( nums == null || nums.length == 1 )
            return 0;

        int begin = 0, end = -1;    // the initial value of end must less 1 than begin, because if the array is ascending it would return 0.
        int max = nums[0], min = nums[nums.length - 1];

        for( int i = 0; i < nums.length; i++ )
        {
            if( nums[i] < max )
                end = i;
            if( nums[nums.length - 1 - i] > min )
                begin = nums.length - 1 - i;
            max = Math.max( max, nums[i] );
            min = Math.min( min, nums[nums.length - 1 - i] );
        }

        return end - begin+1;
    }

    public static void main( String[] args )
    {
        System.out.println(
            new ShortestUnsortedContinuousSubarray().findUnsortedSubarray( new int[] { 2, 6, 4, 8, 10, 9, 15 } ) );
    }
}
