import java.util.Arrays;
import java.util.HashMap;

public class TargetSum
{
    public int findTargetSumWaysWithMemoization(int[] nums, int S) {        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        return sum(nums, S,0,0,map );
    }
    
    public int sum(int[] nums, int target, int result, int begin, HashMap<String, Integer> map){
        if(begin==nums.length){
            if(target==result) return 1;
            return 0;
        }
        
        String key = begin+" "+result;
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        
        int add = sum(nums,target,result+nums[begin],begin+1,map);
        int minus = sum(nums,target,result-nums[begin],begin+1, map);
        map.put(key, add+minus);
        
        return add+minus;
    }
    
    public int findTargetSumWaysDP(int[] nums, int S) {        
        int sum = 0;
        for( int i=0;i<nums.length;i++){
            sum = sum+nums[i];
        }
        
        if(((sum+S)&1)==1) return 0;
        
        //sum(positive)-sum(negative) = target
        //sum(positive)+sum(negative) = sum
        //sum(positive) = (target+sum)/2, convert to subset sum problem
        int postive = (sum+S)/2;
        
        if(postive>sum) return 0;
        
        int[] dp = new int[postive+1];
        Arrays.sort(nums);
        dp[0]=1;
        for( int i=0;i<nums.length;i++){
            for( int j=postive;j>=nums[i];j--){
                dp[j] = dp[j]+dp[j-nums[i]];
            }
        }
        
        return dp[postive];
    }
}
