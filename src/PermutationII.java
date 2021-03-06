import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationII
{
    
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permuteUnique( int[] nums )
    {
        Arrays.sort( nums );
        LinkedList<Integer> numsList = new LinkedList<Integer>();
        for( int num : nums )
        {
            numsList.add( num );
        }
        
        recursionPermute( numsList, new LinkedList<Integer>() );

        return result;
    }
    
    private void recursionPermute( LinkedList<Integer> nums, LinkedList<Integer> permutation )
    {
        if( nums.size() == 0 )
        {
            List<Integer> tempList = new LinkedList<Integer>(permutation);
            result.add( tempList );
            return;
        }

        for( int i = 0; i < nums.size(); )
        {
            int digital = nums.get( i );
            
            permutation.add( nums.get( i ) );
            nums.remove( i );
            recursionPermute( nums, permutation );
            nums.add( i, digital );
            permutation.removeLast();
            
            while(i<nums.size()&&digital==nums.get( i ))
            {
                i++;
            }
        }
    }

    public static void main( String[] args )
    {
        System.out.println( new PermutationII().permuteUnique( new int[]{3,3,0,3} ) );
    }
}
