import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII
{
List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = { 0,1,2,3,4,5,6,7,8,9};
        backtracking( nums, 1, k, n, new LinkedList<Integer>());
        
        return result;
    }
    
    public void backtracking(int[] nums, int start, int k, int n, LinkedList<Integer> list){
        if(n==0&&k==0) {result.add(new ArrayList<Integer>(list));return;}
        
        if(start>=nums.length||nums[start]>n||k==0) return;
        
        for(;start<nums.length;start++){
            list.add(nums[start]);
            backtracking(nums, start+1, k-1, n-nums[start], list );
            list.pollLast();
        }
        
    }
}
