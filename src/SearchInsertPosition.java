
public class SearchInsertPosition
{
    public int searchInsert( int[] nums, int target )
    {
        return search( nums, 0, nums.length - 1, target );
    }

    private int search( int[] nums, int start, int end, int target )
    {
        if( start == end )
        {
            if( nums[start] < target )
                return start + 1;
            else
                return start;
        }
        int mid = ( start + end ) / 2;
        if( nums[mid] > target )
            return search( nums, start, mid, target );
        else if( nums[mid] < target )
            return search( nums, mid + 1, end, target );
        else
            return mid;
    }

    public static void main( String[] args )
    {
        System.out.println( new SearchInsertPosition().searchInsert( new int[]{1,3}, 0 ) );
    }
}
