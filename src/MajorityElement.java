import java.util.Arrays;

public class MajorityElement
{
    public int majorityElement( int[] nums )
    {
        if(nums.length==0) return 0;
        
        Arrays.sort(nums);
        int result = 0;
        int maxNums = 0;
        
        for( int i=0;i<nums.length;){
            int j=0;
            while((i+j)<nums.length&&nums[i]==nums[i+j]){
                j++;
                
            }
            
            if(j>result) {
                maxNums = nums[i+j];
                result = j;
            }
            i=i+j;
        }
        
        return maxNums;
    }
    
    public int solution2(int[] nums) {
        Arrays.sort( nums );
        return nums[nums.length/2];
    }
    
    
}
