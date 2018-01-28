import java.util.HashMap;

public class ContiguousSubarraySum
{

    public boolean checkSubarraySum(int[] nums, int k) {
        
        if( nums == null || nums.length<=0 ) return false;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        int sum=0;
        for( int i = 0; i <nums.length ; i++ ){
            
            sum += nums[i];
            if( k!=0 ) sum = sum%k;  //all element is positive and cur sum must large than the previous sum, so the map can only save the mod value
            if(map.containsKey(sum)&&( i-map.get(sum)) >1) return true;
            
            if( !map.containsKey(sum) ) map.put( sum, i );
            
        }
        
        return false;
    }

}
