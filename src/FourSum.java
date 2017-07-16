import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum
{
    public List<List<Integer>> fourSum( int[] nums, int target )
    {
        List<List<Integer>> fourNum = new ArrayList<List<Integer>>();

        if( nums.length < 4 )
        {
            return fourNum;
        }

        Arrays.sort( nums );

        if( nums[0] * 4 > target || nums[nums.length - 1] * 4 < target )
        {
            return fourNum;
        }

        for( int i = 0; i < nums.length - 3; i++ )
        {
            if( nums[i] * 4 > target )
            {
                break;
            }

            if( nums[i] + nums[nums.length - 1] * 3 < target )
            {
                continue;
            }

            if( i > 0 && nums[i] == nums[i - 1] )
            {
                continue;
            }

            threeSum( nums, target - nums[i], i + 1, fourNum );

        }

        return fourNum;
    }

    public void threeSum( int[] nums, int target, int low, List<List<Integer>> fourNum )
    {

        if( nums.length < 3 )
        {

            return;

        }

        int i = low;
        while( i < nums.length )
        {
            if( i == low || nums[i] != nums[i - 1] )
            {
                int j = i + 1, k = nums.length - 1;

                while( j < k  )
                {
                    if( nums[i] + nums[j] + nums[k] == target )
                    {
                        fourNum.add( Arrays.asList( nums[low - 1], nums[i], nums[j], nums[k] ) );
                        while( j < k && nums[j] == nums[j + 1] )
                            j++;
                        while( j < k && nums[k] == nums[k - 1] )
                            k--;
                        j++;
                        k--;
                    }
                    else if( nums[i] + nums[j] + nums[k] < target )
                    {
                        while( j < k && nums[j] == nums[j + 1] )
                            j++;
                        j++;
                    }
                    else
                    {
                        while( j < k && nums[k] == nums[k - 1] )
                            k--;
                        k--;
                    }
                }

            }
            i++;
        }

        return;
    }

    public static void main( String[] args )
    {
        FourSum fourSum = new FourSum();
        System.out.println( fourSum.fourSum( new int[] { -1,0,-5,-2,-2,-4,0,1,-2 }, -9 ) );
    }
}
