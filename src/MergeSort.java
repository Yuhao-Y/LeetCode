import java.util.Arrays;

public class MergeSort
{
    
    public void mergeSort( int[] nums ) {
        
        sort( nums, 0, nums.length-1);
        
        System.out.println( Arrays.toString( nums ) );
    }
    
    public void sort( int[] nums, int start, int end ) {
        
        if( start >= end ) return;
        
        int mid = start + ( end - start )/2;
        
        sort( nums, start, mid );
        sort( nums, mid+1, end );
        
        merge( nums, start, mid, mid+1, end );
        
    }
    
    public void merge( int[] nums, int start1, int end1, int start2, int end2 ) {
        
        int[] tmp = new int[end2 - start1 + 1];
        
        for( int i = 0; i<tmp.length; i++ ) {
            
            if( start2>end2 || (start1<=end1 && nums[start1]<nums[start2] ) ) {
                tmp[i] = nums[start1++];
                continue;
            }
            
            if( start1 > end1 || (start2<=end2 && nums[start1]>=nums[start2] ) ) {
                tmp[i] = nums[start2++];
                continue;
            }
        }
        
        System.arraycopy( tmp, 0, nums, end2 - tmp.length+1, tmp.length );
        
    }
    
    public static void main( String[] args ) {
        
        new MergeSort().mergeSort( new int[] {6,5,4,3,2,1 } );
        
    }
    
}
