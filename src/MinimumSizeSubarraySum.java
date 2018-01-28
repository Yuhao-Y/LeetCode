
public class MinimumSizeSubarraySum
{
    public int minSubArrayLen(int s, int[] nums) {
        if( nums==null || nums.length<=0 ) return 0;
       
       int lo = 0, hi = 0;
       int sum = 0;
       int res = Integer.MAX_VALUE;
       while( hi<nums.length ){
           while( sum<s && hi<nums.length ){
               sum += nums[hi];
               hi++;
           }
           
           while( sum>=s ) {
               res = Math.min( res, hi-lo);
               sum -= nums[lo];
               lo++;
           }
       }
       
       return res==Integer.MAX_VALUE?0:res;
   }
}
