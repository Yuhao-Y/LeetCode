import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum
{
public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if( nums == null || nums.length <4) return res;
        
        Arrays.sort( nums );
        
        int max = nums[ nums.length - 1 ];
        
        for( int i=0; i< nums.length-3; i++){
            
            if( ( nums[i]+max*3 )<target) continue;     // i is too small
            
            if( nums[i]*4>target) break;    // i is too big
            
            for( int j=i+1; j < nums.length-2; j++){
                
                if( ( nums[j]+max*2 )<(target - nums[i])) continue;
                
                if( nums[j]*3>(target - nums[i]) ) break;
                
                List<Integer> list = new ArrayList<Integer>();
                list.add( nums[i]);
                list.add( nums[j]);
                twoSum( nums, j+1, target-nums[i]-nums[j], list, res);
                while( j<(nums.length-1) && nums[j]==nums[j+1] ) j++;
            }
            while( i<(nums.length-1) && nums[i]==nums[i+1] ) i++; // skip the duplicate
        }
        
        return res;
    }
    
    public void twoSum( int[] nums, int start, int target, List<Integer> list, List<List<Integer>> res){
        int left = start, right =nums.length-1;
       
        while( left< right ){
            
            if( nums[left]*2 >target) break;
            
            if( ( nums[left] + nums[right] ) > target ){
                //while( left< right && nums[right-1]==nums[right]) right--;
                right--;
            }else if( ( nums[left] + nums[right] ) < target ){
                //while( left< right && nums[left+1]==nums[left]) left++;
                left++;
            }else{
                List<Integer> tmp = new ArrayList<Integer>( list );
                tmp.add(nums[left]);
                tmp.add( nums[right]);
                res.add(tmp);
                while( left< right && nums[right-1]==nums[right]) right--;
                while( left< right && nums[left+1]==nums[left]) left++;
                right--;
                left++;
            }
        }
    }

    public static void main( String[] args )
    {
        FourSum fourSum = new FourSum();
        System.out.println( fourSum.fourSum( new int[] { -1,0,-5,-2,-2,-4,0,1,-2 }, -9 ) );
    }
}
