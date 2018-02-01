import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsK
{
    
    public int maxSubArrayLen( int[] nums, int target) {
        if( nums==null || nums.length<=0) return 0;
        
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);// when the sum is equal to target, it will use current index - (-1)   to get the length
        
        for( int i=0; i<nums.length; i++) {
            sum +=nums[i];
            
            if( map.containsKey(  sum - target )) {
                result = Math.max( result, i - map.get(  sum - target ));
            }
               
            if( !map.containsKey(  sum )) {
                map.put( sum, i );
            }
            
        }
        
        
        return result;
    }
    
    public int maxSubArrayLen2( int[] nums, int target) {
        if( nums==null || nums.length<=0) return 0;
        
        int res = Integer.MIN_VALUE;
        
        int lo = 0, hi = 0;
        int sum = 0;
        
        while( hi< nums.length ) {
            
            while( hi<nums.length && sum < target) {
                sum+=nums[hi];
                hi++;
            }
            
            while( sum>=target ) {
                if( sum == target )res = Math.max( res, hi-lo);
                sum -= nums[lo];
                lo++;
            }
            
        }
        
        return res == Integer.MIN_VALUE ? 0 :res  ;
    }
    
    public static void main( String[] args) {
        System.out.println( new MaximumSizeSubarraySumEqualsK().maxSubArrayLen2( new int[] { 1,2,4,5,1,1,1,1,1,4,4,5,3 }, 8 ) );
    }
    
}
