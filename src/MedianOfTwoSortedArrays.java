import java.util.Arrays;


public class MedianOfTwoSortedArrays
{
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int i = 0 , j = 0, index = 0;
        double median = 0, lastMedian = 0;
        int medianIndex = (nums1.length + nums2.length)/2;
        
        while( (i<nums1.length || j<nums2.length) && (index <= medianIndex ) ){
            
            lastMedian = median;
            
            if( j==nums2.length || ( i<nums1.length && nums1[i] <= nums2[j] ) )
            { 
                if( i<nums1.length ) median = nums1[i];
                i++;
                
            }
            else if( i==nums1.length || ( j<nums2.length && nums1[i] > nums2[j] ) )
            {
                if( j <nums2.length) median = nums2[j];
                j++;
                
            }
            
            index++;
        }
        
        return ((nums1.length+nums2.length)&1)==1?median:(median+lastMedian)/2;
        
    }
    
    static public void sort(int begin, int end, int[] num){
        //System.out.println(begin+":"+end);
        if(begin==end){
            return;
        }
        
        int midIndex = end/2;
        int midNum = num[midIndex];
        int[] copyNum = Arrays.copyOfRange( num, begin, end );
        int i=begin,j=end;
        for(int k=0;k<copyNum.length;k++){
            if(copyNum[k]<=midNum){
                num[i++]=copyNum[k];
            }else{
                num[j--]=copyNum[k];
            }
        }
        
        System.out.println(Arrays.toString( num ));
        sort(begin,i,num);
        sort(j,end,num);
    }
    
    public static void main(String[] args){
        int[] nums1 = new int[] {1,3};
        int[] nums2 = new int[] {1,3,4};
        System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays( nums1, nums2 ) );
    }
}
