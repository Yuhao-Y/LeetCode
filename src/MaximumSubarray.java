
public class MaximumSubarray
{
    public int maxSubArray( int[] nums )
    {
        if( nums.length == 0 )
            return 0;
        if( nums.length == 1 )
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int globalValue = dp[0];

        for( int i = 1; i < nums.length; i++ )
        {
            dp[i] = nums[i] + ( dp[i - 1] > 0 ? dp[i - 1] : 0 );
            globalValue = Math.max( globalValue, dp[i] );
        }

        return globalValue;
    }

    public int maxSubArray2( int[] nums )
    {
        if( nums.length == 0 )
            return 0;
        if( nums.length == 1 )
            return nums[0];

        int globalValue = nums[0];
        int currentValue = nums[0];

        for( int i = 1; i < nums.length; i++ )
        {
            currentValue = currentValue + nums[i];
            if(currentValue<0) currentValue = 0;
            
            globalValue = Math.max( globalValue, currentValue );
        }
        
        return globalValue;
    }

    public static void main( String[] args )
    {
        System.out.println( new MaximumSubarray().maxSubArray2( new int[] { -1, -2 } ) );
    }
}
