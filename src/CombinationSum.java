import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum
{
    List<List<Integer>> combinations = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum( int[] candidates, int target )
    {
        //for( int i = 0; i < candidates.length; i++ )
        //{
        //   List<Integer> com = new ArrayList<Integer>();
        //   combine( candidates, target, com, i, 0 );
        //}
        Arrays.sort( candidates );
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        List<Integer> com = new ArrayList<Integer>();
        combine2(combinations, candidates, target, com, 0, 0 );

        return combinations;
    }
    
    public List<List<Integer>> combinationSumDP(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> dp = new ArrayList<List<List<Integer>>>();
        
        for( int i=1;i<=target;i++){
            List<List<Integer>>  list = new ArrayList<List<Integer>>();
            
            for( int j=0;j<candidates.length&&candidates[j]<=i;j++){
                if(candidates[j]==i) list.add(Arrays.asList(candidates[j]));
                else 
                    for(List<Integer> l : dp.get(i-candidates[j]-1)){
                        if(candidates[j]<=l.get(0)){    //avoid the duplicate result, such as 2,3 and 3,2
                            List<Integer> tmp = new ArrayList<Integer>();
                            tmp.add(candidates[j]);tmp.addAll(l);
                            list.add(tmp);
                        }
                    }
            }
            
            dp.add(list);
        }
        
        return dp.get(target-1);
    }

    private void combine( int[] candidates, int target, List<Integer> candidateNum, int index, int sum )
    {
        // backtracking terminal condition 1
        if( index >= candidates.length )
        {
            return;
        }

        sum = sum + candidates[index];

        // backtracking terminal condition 2
        if( sum > target )
        {
            return;
        }
        // get the correct combination
        else if( sum == target )
        {
            List<Integer> com = new ArrayList<Integer>();
            com.addAll( candidateNum );
            com.add( candidates[index] );
            combinations.add( com );
            return;
        }
        else
        {
            candidateNum.add( candidates[index] );
            for( ; index < candidates.length; index++ )
            {
                combine( candidates, target, candidateNum, index, sum );
            }
            candidateNum.remove( candidateNum.size()-1 );
        }
    }

    private void combine2( List<List<Integer>> result,int[] candidates, int target, List<Integer> candidateNum, int index, int sum )
    {
        if( sum < target )
        {
            for( ; index < candidates.length&&((target-sum)>=candidates[index]); index++ )
            {
                candidateNum.add( candidates[index] );
                //it should take index+1 as the parameter in problem Combination Sum Two
                combine2( result, candidates, target, candidateNum, index, sum + candidates[index] );
                // remove the latest num
                candidateNum.remove( candidateNum.size()-1 );
            }
        }
        else if( sum == target )
        {
            result.add( new ArrayList<Integer>(candidateNum) );
        }

    }
    
    public List<List<Integer>> combinationSumWithBacktracting(int[] candidates, int target) {
        
        backtracking(candidates, target, 0, new ArrayList<Integer>() );
        
        return combinations;
    }
    
    public void backtracking(int[] candidates, int target, int index, List<Integer> list ){
        if(target==0) {combinations.add( new ArrayList<Integer>(list)); return;}
        
        if(index>=candidates.length||target<0) return;
        
        for( int i = index;i<candidates.length;i++){
            list.add(candidates[i]);
            backtracking(candidates, target-candidates[i], i, list);
            list.remove(list.size()-1);
        }
    
    }

    public static void main( String[] args )
    {
        CombinationSum c = new CombinationSum();
        System.out.println( c.combinationSum( new int[] { 2, 3, 5, 6, 7 }, 7 ) );
    }
}
