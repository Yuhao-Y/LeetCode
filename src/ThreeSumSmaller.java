import java.util.Arrays;

public class ThreeSumSmaller
{
    public int sum( int[] nums, int target) {
        
        int result = 0;
        if( nums == null|| nums.length<3) return result;
        
        Arrays.sort( nums );
        
        for( int i=0; i<(nums.length-2); i++) {
            int j=i+1, k=nums.length-1;  //j=i+1, avoid the duplicate value
            while( j<k ) {
                if((nums[j]+nums[k]+nums[i])>=target) k--;
                else {result +=(k-j);j++;} //
            }
        }
        
        return result;
    }
    
    public static void main( String[] args) {
        System.out.println( new ThreeSumSmaller().sum( new int[] {-2, 0, 1, 3}, 2 ) );
    }
}
