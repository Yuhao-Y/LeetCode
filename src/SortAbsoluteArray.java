import java.util.Arrays;

public class SortAbsoluteArray
{
    public void sort( int[] nums) {
        
        int lo = 0, hi = nums.length - 1;
        
        while( lo <= hi ) {
            int mid = lo+( hi - lo )/2;
            if( nums[mid]>=0) hi = mid - 1;
            else lo = mid+1;
        }
        
        int[] negative = Arrays.copyOfRange( nums, 0, lo );
        int[] positive = Arrays.copyOfRange( nums, lo, nums.length );
        
        int i = negative.length-1, j = 0, index = 0;
        while( i>=0 && j<positive.length ) {
            if( Math.abs( negative[i] )>positive[j]) nums[index++] = positive[j++];
            else nums[index++] = negative[i--];
        }
        
        while( i>=0) {
            nums[index++] = negative[i--];
        }
        
        while( j<positive.length ) {
            nums[index++] = positive[j++];
        }
        
    }
    
    public static void main( String[] args ) {
        SortAbsoluteArray sort = new SortAbsoluteArray();
        int[] nums = new int[] {-9, -7, -5, 0 ,1 , 2 ,3 ,4, 8};
        sort.sort( nums );
        System.out.println( Arrays.toString( nums ) );
    }
}
