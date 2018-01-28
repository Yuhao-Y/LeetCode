import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSumCloest
{
    public int threeSumClosest( int[] nums, int target )
    {
        List<Integer> singleInteger = new ArrayList<Integer>();
        List<Integer> twoInteger = new ArrayList<Integer>();
        int cloest = nums[0]+nums[1]+nums[2];
        for( int i = 0; i < nums.length; i++ )
        {
            for( Integer num : twoInteger )
            {
                cloest = Math.abs( target - cloest ) > Math.abs( target - num - nums[i] ) ? ( num + nums[i] ) : cloest;
            }

            for( Integer num : singleInteger )
            {   
                twoInteger.add( num + nums[i] );
            }

            singleInteger.add( nums[i] );
        }
        
        return cloest;
    }
    
    public int threeSum( int[] nums, int target) {
        int cloest = nums[0]+nums[1]+nums[2];
        Arrays.sort( nums );
        for( int i=0;i<nums.length;i++) {
            int low = i+1; // the number before i has been used, improve performance
            int high = nums.length-1;
            
            while(low<high) {
                int sum = nums[low]+nums[i]+nums[high];
                cloest = Math.abs( target - cloest ) > Math.abs( target - sum ) ? (sum ) : cloest;
                if(sum>target) high--;
                else if(sum<target) low++;
                else return cloest;
            }
        }
        
        return cloest;
    }

    public static void main( String[] args )
    {
        HashMap<String, String> map= new HashMap<String, String>();
        map.put( "a", "b" );
        System.out.println( new ThreeSumCloest().threeSum( new int[] {0,1,2}, 0 ) );
    }
}
