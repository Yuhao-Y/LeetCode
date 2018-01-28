import java.util.HashMap;

public class ContiguousArray
{
    public int findMaxLength(int[] nums) {
        
        if( nums==null || nums.length<=0) return 0;
    
        int max = 0, difference = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);  //
    
        for( int i=0;i<nums.length; i++){
            if( nums[i]==1) difference++;
            else difference--;
        
            if( map.containsKey(difference) )
                max = Math.max(max, i -map.get(difference));
            else
                map.put(difference, i);
        }
    
        return max;
    }
}
