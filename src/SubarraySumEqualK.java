import java.util.HashMap;

public class SubarraySumEqualK
{
    public int subarraySum(int[] nums, int k) {
        
        if( nums == null || nums.length<0 ) return 0;
        
        int result = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put( 0, 1 );
        
        for( int i=0; i<nums.length ;i++){
            sum += nums[i];
            if( map.containsKey( sum - k)){
                result += map.get( sum - k);
            }
            
            map.put( sum, map.getOrDefault(sum, 0)+1); //use getOrDefault method to put or get a value when the key is new
        }
        
        return result;
        
    }
    
    public static void main( String[] args ) {
        System.out.println( new SubarraySumEqualK().findSubarraySum( new int[] {8,8,1,5,5}, 10 ) );
    }
    
    //follow up find whether have sub array equal to k
    public boolean findSubarraySum( int[] nums, int k) {
        if( nums == null || nums.length<=0 ) return false;
        
        int i=0, j=0;
        int sum = 0;
        
        while( j< nums.length ) {
            while( sum<k && j<nums.length ) {
                sum +=nums[j];
                j++;
            }
            
            while( sum>k && i<j ) {
                sum -=nums[i];
                i++;
            }
            
            if( sum == k) return true;
        }
        
        return false;
    }
}
