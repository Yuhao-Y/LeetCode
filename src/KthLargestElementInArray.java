import java.util.Arrays;

public class KthLargestElementInArray
{
    public int findKthLargest( int[] nums, int k )
    {
        return quickSelect( nums, k );
    }

    private int quickSelect( int[] nums, int k )
    {
        int index = partition( nums, 0, nums.length - 1, k );
        return nums[index];
    }

    private int partition( int[] nums, int lo, int hi, int k )
    {
        //set the left most element to pivot
        int pivot = nums[lo];

        int i = lo + 1;
        int j = lo;

        //put the element great than pivot to left side
        for( ; i <= hi; i++ )
        {
            if( nums[i] > pivot )
            {
                j++;
                swap( nums, i, j );
            }
        }

        //swap pivot to the sorted position
        swap( nums, lo, j );

        if( ( j + 1 ) == k )
            return j;
        else if( ( j + 1 ) > k )
            return partition( nums, lo, j, k );
        else
            return partition( nums, j + 1, hi, k );
    }

    private void swap( int[] nums, int i, int j )
    {
        if( nums[i] != nums[j] )
        {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }

    public void quickSort( int[] nums, int lo, int hi )
    {
        if( lo >= hi )
            return;

        int pivot = nums[lo];
        int i = lo + 1;
        int start = lo;
        for( ; i <= hi; i++ )
        {
            if( nums[i] > pivot )
            {
                start++;
                swap( nums, i, start );
            }
        }

        swap( nums, lo, start );

        quickSort( nums, lo, start - 1 );
        quickSort( nums, start + 1, hi );
    }

    public static void main( String[] args )
    {
        KthLargestElementInArray k = new KthLargestElementInArray();

        int[] array = new int[] { 3, 5, 2, 7, 6,-1 };
        k.quickSort( array, 0, array.length-1 );
        //System.out.println( k.findKthLargest( new int[] { 3, 5, 2, 7, 6 }, 4 ) );
        System.out.println( Arrays.toString( array ) );
    }
}
