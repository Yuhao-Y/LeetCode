import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII
{
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
        backtracking(candidates, target, 0, new ArrayList<Integer>() );
        
        return result;
    }
    
    public void backtracking(int[] candidates, int target, int index, List<Integer> list ){
        if(target==0) {result.add( new ArrayList<Integer>(list)); return;}
        
        if(index>=candidates.length||target<0) return;
        
        for( int i = index;i<candidates.length&&candidates[i]<=target;){  // no need to continue traversal if candidates[i] large than target
            list.add(candidates[i]);
            backtracking(candidates, target-candidates[i], i+1, list);
            list.remove(list.size()-1);
            while((i+1)<candidates.length&&candidates[i]==candidates[i+1]) i++;
            i++;
        }
    
    }
}
