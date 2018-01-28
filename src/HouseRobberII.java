
public class HouseRobberII
{
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        
        //only consider include the first house or not
        return Math.max(robNormal(nums, 0, nums.length-2),robNormal(nums, 1, nums.length-1));
    }
    
    public int robNormal( int[] nums, int lo, int hi){
        int include = 0, exclude = 0;
        for( int i = lo;i<=hi;i++){
            int in = include, ex = exclude;   
            include = nums[i]+ex;
            exclude = Math.max(in,ex);
        }
        
        return Math.max(include, exclude);
    }
    
    public static void main( String[] args) {
        System.out.println( new HouseRobberII().rob(new int[] {1,1,1}) );
    }
}
