import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArray
{
    public int[] intersection(int[] nums1, int[] nums2) {
        
        if( nums1 == null ||nums1.length<=0 || nums2 ==null || nums2.length<=0 ) return new int[]{};
        
        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        
        for( int i=0;i<nums1.length;i++) set.add( nums1[i] );
        
        for( int j = 0; j <nums2.length ; j++ ){
            if( set.contains( nums2[j] ) ) 
                list.add( nums2[j] );
        }
        
        int[] res = new int[list.size()];
        
        int index = 0;
        for( Integer i : list){
            res[index++] = i;
        }
        
        return res;
    }
    
    public int[] intersectionWithBinarySearch( int[] nums1, int[] nums2 ) {
        
        if( nums1 == null ||nums1.length<=0 || nums2 ==null || nums2.length<=0 ) return new int[]{};
        Arrays.sort( nums1 );
        Arrays.sort( nums2 );
        
        int[] longArray = nums1.length>nums2.length?nums1:nums2;
        int[] shortArray = nums1.length>nums2.length?nums2:nums1;
        
        int start = 0, end =0;
        int lo = 0, hi = longArray.length-1;
        int min = shortArray[0],max = shortArray[ shortArray.length-1];
        while( lo<=hi ) {
            int mid = lo+ (hi - lo)/2;
            if( longArray[mid] >= min) hi = mid - 1;
            else lo = mid+1;
        }
        start = lo;
        
        lo = 0; hi = longArray.length-1;
        while( lo<=hi ) {
            int mid = lo+ ( hi - lo )/2;
            if( longArray[mid] <= max) lo = mid+1;
            else hi = mid-1;
        }
        end = hi;
        
        HashSet<Integer> list = new HashSet<Integer>();
        
        int i = start, j =0;
        
        while( i <=max && j < shortArray.length ){
            
            if( nums1[i]>nums2[j] ) j++;
            else if( nums1[i]<nums2[j] ) i++;
            else{
                list.add( nums1[i] );
                i++;
                j++;
            }
            
        }
        
        int[] res = new int[list.size()];
        
        int index = 0;
        for( Integer val : list){
            res[index++] = val;
        }
        
        return res;
        
        
        
    }

    public static void main( String[] args ) {
        System.out.println(  Arrays.toString( new IntersectionOfTwoArray().intersectionWithBinarySearch( new int[] {1}, new int[] {1} ) ) );
    }
}
