import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostFrequentSubtreeSum
{
    HashMap< Integer, Integer > sumFre = new HashMap< Integer,Integer >();
    HashMap< Integer, Set<Integer> > freSum = new HashMap< Integer, Set<Integer> >();
    int maxFrequency = 1;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[]{};        
        
        freSum.put( 1, new HashSet<>());
        dfs(root);
        
        Set<Integer> result = freSum.get(maxFrequency);
        int[] resultArray = new int[result.size()];
        
        int index = 0;
        for( Integer i :result){
            resultArray[index++] = i;
        }
        
        return resultArray;
    }
    
    public int dfs( TreeNode root ){
        if( root == null) return 0 ;
        
        int sum = dfs( root.left)+ dfs(root.right)+root.val;
        
        if( sumFre.containsKey(sum)){
            int frequency = sumFre.get(sum);
            
            freSum.get(frequency++).remove(sum);
            if(!freSum.containsKey(frequency)) freSum.put(frequency, new HashSet<Integer>());        
            freSum.get(frequency).add(sum);
            sumFre.put( sum, frequency);
            
            maxFrequency = Math.max(frequency, maxFrequency);
           
        }else{
            sumFre.put(sum, 1);            
            freSum.get(1).add(sum);
        }
        
        
        return sum;
    }
}
