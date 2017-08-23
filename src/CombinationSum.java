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

    public static void main( String[] args )
    {
        CombinationSum c = new CombinationSum();
        System.out.println( c.combinationSum( new int[] { 2, 3, 5, 6, 7 }, 7 ) );
    }
}
