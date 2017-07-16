import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum
{
    public List<List<Integer>> threeSum( int[] nums )
    {

        List<List<Integer>> tripletsList = new ArrayList<List<Integer>>();

        Arrays.sort( nums );

        if( nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0 )
        {

            return tripletsList;

        }
        
        int i = 0;
        while( i < nums.length && nums[i] <= 0 )
        {
            if( i==0 || nums[i]!=nums[i-1] )
            {
                int j = i+1, k = nums.length-1;
                
                while(j<k&&nums[k]>=0)
                {
                    if(nums[i]+nums[j]+nums[k]==0){
                        tripletsList.add( Arrays.asList( nums[i],nums[j],nums[k] ) );
                        while(j<k&&nums[j]==nums[j+1])j++;
                        while(j<k&&nums[k]==nums[k-1])k--;
                        j++;
                        k--;
                    }else if(nums[i]+nums[j]+nums[k]<0){
                        while(j<k&&nums[j]==nums[j+1])j++;
                        j++;
                    }else{
                        while(j<k&&nums[k]==nums[k-1])k--;
                        k--;
                    }
                }
                
            }
            i++;
        }

        return tripletsList;
    }

    public static void main( String[] args )
    {
        ThreeSum threeSum = new ThreeSum();
        System.out.println( threeSum.threeSum( new int[] {3,0,-2,-1,1,2 } ) );
    }
}
