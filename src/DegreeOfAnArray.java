import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class DegreeOfAnArray
{
    public int findShortestSubArray(int[] nums) {
        
        if( nums == null || nums.length == 0 ) return 0;
        
        //int[0] is left index, int[1] is right index, int[2] is count
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int max = nums[0];
        for( int lo = 0; lo < nums.length; lo++){
            
            if( !map.containsKey( nums[lo] ) ){
                map.put( nums[lo], new int[]{lo, lo, 1} );
            }else{
                int[] loArray = map.get( nums[lo]);
                int[] maxArray = map.get( max );
                loArray[1] = lo;
                loArray[2]++;
                
                if( loArray[2] > maxArray[2] ) max = nums[lo];
                else if( loArray[2] == maxArray[2] 
                        && (loArray[1]-loArray[0] ) < (maxArray[1]-maxArray[0] ) ) {
                    max = nums[lo];
                }
            }
            
        
        }
        
        return map.get( max )[1] - map.get( max )[0] + 1;
    }
    
    public int findShortestSubArray2(int[] nums) {
        
        if( nums == null || nums.length == 0 ) return 0;
        
        //int[0] is left index, int[1] is right index, int[2] is count
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();

        for( int lo = 0; lo < nums.length; lo++){
            
            if( !map.containsKey( nums[lo] ) ){
                map.put( nums[lo], new int[]{lo, lo, 1} );
            }else{
                int[] loArray = map.get( nums[lo]);
                loArray[1] = lo;
                loArray[2]++;
            }
            
        }
        
        int max = 0;
        int maxLength = Integer.MAX_VALUE;
        
        for( Integer i : map.keySet() ){
            int[] iArray = map.get(i);
            if( iArray[2] > max ){
                max = iArray[2];
                maxLength = iArray[1] - iArray[0] +1;
            }else if(iArray[2] == max ){
                maxLength = Math.min( maxLength, iArray[1] - iArray[0] +1);
            }
        }
        
        return maxLength;
        
    }
}
