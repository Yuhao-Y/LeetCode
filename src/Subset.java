import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subset
{
    public List<List<Integer>> subsets( int[] nums )
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add( new ArrayList<Integer>());
        
        for( int i=0;i<nums.length;i++){
            int length = result.size();
            for( int j=0;j<length;j++){
                List<Integer> list = new ArrayList<Integer>();
                list.addAll(result.get( j ));
                list.add(nums[i]);
                result.add(list);
            }    
        }
        
        return result;
    }

    //recurstion, dfs, faster than for-loop.
    public List<List<Integer>> subsetsBacktracking( int[] nums )
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        dfs(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private void dfs( int[] nums, List<List<Integer>> result, List<Integer> temp, int start )
    {
        result.add( new ArrayList<Integer>(temp) );

        for( ; start < nums.length; start++ )
        {
            temp.add( nums[start] );
            dfs(nums, result, temp, start+1);
            temp.remove( temp.size()-1 );
        }
    }

    public static void main( String[] args )
    {
        System.out.println( new Subset().subsets( new int[] { 0, 1, 2 } ) );
    }
}
