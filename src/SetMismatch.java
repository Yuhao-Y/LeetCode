import java.util.Arrays;

public class SetMismatch
{
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        
        Arrays.sort(nums);
        
        int sum = 0;
        for( int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) result[0] = nums[i];
            sum = sum^(i+1)^nums[i];
        }
        
        result[1] = sum^result[0];
        
        return result;
    }
    
    public int[] findErrorNumsWithoutSorted(int[] nums) {
        
        int[] res = new int[2];
        int[] count = new int[nums.length+1];
        int sum = 0;
        for( int i=0; i < nums.length; i++ ){
            if( ++count[nums[i]]==2) res[0] = nums[i];
            sum = sum^nums[i]^(i+1);
        }
        
        res[1] = sum^res[0];
        
        return res;
    }
    
    public static void main( String[] args ) {
        System.out.println(Arrays.toString( new SetMismatch().findErrorNums( new int[] {1,2,2,4} ) ) );
    }
}
