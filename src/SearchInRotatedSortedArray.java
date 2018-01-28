
public class SearchInRotatedSortedArray
{
    // There is only one difference in this case when compare with the usual binary search.
    // The difference is that sometimes the value of low index is bigger than the value of high index in the array or sub-array.
    // We can use the usual binary search ways to process the exception array or sub-array when the target is in the array or sub-array.
    
    public int search( int[] nums, int target )
    {
        int index = -1;

        if( nums.length > 0 && isTargetInArray( nums, 0, nums.length - 1, target ) )
        {
            index = searchTarget( nums, 0, nums.length - 1, target );
        }
        return index;
    }

    private int searchTarget( int nums[], int low, int high, int target )
    {
        int mid = ( high + low ) / 2;
        
        if(nums[mid]==target)
        {
            return mid;
        }
        
        if( isTargetInArray( nums, low, mid, target ) )
        {
            return searchTarget( nums, low, mid, target );
        }
        else if( isTargetInArray( nums, mid + 1, high, target ) )
        {
            return searchTarget( nums, mid + 1, high, target );
        }
        else
        {
            return -1;
        }

    }

    private boolean isTargetInArray( int[] nums, int low, int high, int target )
    {

        if( nums[low] <= nums[high] && target >= nums[low] && target <= nums[high] )
        {
            return true;
        }
        // when the value of low index is bigger than the value of high index.
        else if( nums[low] > nums[high] && ( target >= nums[low] || target <= nums[high] ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int search2(int[] nums, int target) {
        
        if( nums == null || nums.length <= 0 ) return -1;
        
        int lo = 0, hi = nums.length - 1;
        
        while( lo<=hi ){
            int mid = lo + ( hi - lo )/2;
            
            if( nums[mid] == target ) return mid;
            else if( nums[mid] > nums[hi] ){
                if( target < nums[mid] && target > nums[hi] ) hi = mid - 1;
                else lo = mid+1;
            } 
            else {
                if( target>nums[mid] && target<=nums[hi]) lo = mid+1;
                else hi = mid - 1;
            }
            
        }
        
        return -1;
        
    }

    public static void main( String[] args )
    {
        System.out.println( new SearchInRotatedSortedArray().search( new int[] { 2, 1, 3 }, 1 ) );
    }
}
