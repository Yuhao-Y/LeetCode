import java.util.Arrays;

public class CombinationSumIV
{
    public int combinationSum4BottomToUp(int[] nums, int target) {
        int[] dp = new int[target+1];
        
        dp[0] = 1;        
        
        for(int i=1;i<=target;i++){
            for( int j=0;j<nums.length;j++){
                if((i-nums[j])>=0){
                    dp[i] = dp[i]+dp[i-nums[j]];
                }
            }
        }
        
        return dp[target];
    }
    
    //fast than BottomToUp
    public int combinationSum4UpDown(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        
        return recursive( nums, target, dp);
        
    }
    
    public int recursive( int[] nums, int target, int[] dp){
        if(target<0) return 0;
        // check whether the subproblem been solved, if solved get the value from the record  immediately 
        if( dp[target]>-1) return dp[target];
        
        int result = 0;
        for( int i=0;i<nums.length;i++){
            result = result+recursive( nums,target-nums[i],dp);
        }
        
        //record the value of the subproblem that been solved
        dp[target]=result;
        
        return result;
    }
}
