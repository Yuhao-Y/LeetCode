import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedInArray
{
    public List<Integer> findDisappearedNumbers( int[] nums )
    {
        List<Integer> result = new LinkedList<Integer>();

        for( int i = 0; i < nums.length; i++ )
        {
            nums[Math.abs( nums[i] )-1] = 0-Math.abs( nums[Math.abs( nums[i] )-1] );
        }

        for( int i = 0; i < nums.length; i++ )
        {
            if(nums[i]>0) result.add( i+1 );
        }

        return result;
    }
}
