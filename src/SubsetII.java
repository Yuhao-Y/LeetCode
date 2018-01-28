import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetII
{
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        
        dfs(nums, 0, new LinkedList<Integer>());
        
        return result;
    }
    
    public void dfs( int[] nums, int start, LinkedList<Integer> list){
        
        result.add( new ArrayList<Integer>(list));
        
        if(start>=nums.length) return;
        
        for(;start<nums.length;){
            
            list.add(nums[start]);
            dfs( nums, start+1, list);
            list.pollLast();
            
            while((start+1)<nums.length&&nums[start]==nums[start+1]) start++;
            
            start++;
        }
        
    } 
}
