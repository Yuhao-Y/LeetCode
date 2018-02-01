import java.util.*;

public class LongestIncreaingSubsequence
{
    public int lengthOfLISDP( int[] nums )
    {
        if( nums.length <= 0 )
            return 0;
        int global = 1;
        int[] dp = new int[nums.length];
        Arrays.fill( dp, 1 );

        for( int i = 0; i < nums.length; i++ )
        {
            for( int j = 0; j < i; j++ )
            {
                if( nums[i] > nums[j] )
                {
                    dp[i] = Math.max( dp[i], dp[j] + 1 );
                }
            }

            global = Math.max( global, dp[i] );

        }

        return global;
    }

    public int lengthOfLIS( int[] nums )
    {
        if( nums.length <= 0 )
            return 0;

        int[] array = new int[nums.length];
        array[0] = nums[0];
        int len = 0;
        for( int i = 1; i < nums.length; i++ )
        {
            if( nums[i] < array[0] )
            {
                array[0] = nums[i];
            }
            else if( nums[i] > array[len] )
            {
                array[++len] = nums[i];
            }
            else if( nums[i] > array[0] && nums[i] < array[len] )
            {
                int lo = 0, hi = len;

                while( lo <= hi )
                {
                    int mid = ( lo + hi ) / 2;
                    if( nums[i] > array[mid] )
                        lo = mid + 1;
                    else if( nums[i] < array[mid] )
                        hi = mid - 1;
                    else
                    {
                        lo = mid;
                        break;
                    }
                }

                array[lo] = nums[i];
            }

        }

        return len + 1;
    }
    
    public int binarySearch( int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while(lo<hi) {
            int mid = (lo+hi)/2;
            if(target>nums[mid]) lo = mid+1;
            else if( target<nums[mid]) hi = mid-1;
            else {
                lo = mid;
                return lo;
            }
        }
        
        return lo;
    }

    public static void main( String[] args )
    {
        System.out.println( new LongestIncreaingSubsequence().binarySearch( new int[] {2,5,6 },4) );
    }
    
}
