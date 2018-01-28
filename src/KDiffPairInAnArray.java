import java.util.Arrays;
import java.util.HashSet;

public class KDiffPairInAnArray
{
    public int findPairs(int[] nums, int k) {
        
        if( nums==null || nums.length == 0 || k<0 ) return 0;
        
        int count = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        Arrays.sort( nums );
        
        for( int i=0; i < nums.length; i++ ){
            
            if( k!=0 ){
                if( set.contains( nums[i] ) ) continue;
                if( set.contains( nums[i]-k) ) count++;
                set.add( nums[i] );
            }else{
                
                if( set.contains( nums[i] ) ) {
                    count++;
                    while( (i+1)<nums.length && nums[i]==nums[i+1]){
                        i++;
                    }
                }
                else set.add(nums[i]);
            }
            
        }
        return count;
    }
}
