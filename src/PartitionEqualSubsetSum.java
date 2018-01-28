import java.util.Arrays;

public class PartitionEqualSubsetSum
{
    public boolean canPartition(int[] nums) {
        if(nums.length<=1) return false;
        int sum = 0;
        for( int i=0;i<nums.length;i++){
            sum = sum+nums[i];
        }
        
        if((sum&1)==1) return false;
        
        int value = sum/2;
        
        Arrays.sort(nums);
        
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        
//        for( int i=1;i<=value;i++){
//            for( int j = 0;j<nums.length;j++){
//                if((i>=nums[j])&&(i-nums[j])!=nums[j]) {
//                    dp[i] = dp[i]||dp[i-nums[j]];
//                    if(dp[i]) break;
//                }
//            }
//        }
        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }
        return dp[value];
        
    }
    
    public static void main( String[] args) {
        System.out.println( new PartitionEqualSubsetSum().canPartition(new int[] {1,2,5}) );
    }
}
