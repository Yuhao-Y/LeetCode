import java.util.Arrays;


public class MedianOfTwoSortedArrays
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.0;
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
        int[] num = new int[]{4,5,3,3,7,8};
        MedianOfTwoSortedArrays.sort(0,num.length-1,num);
        System.out.println(Arrays.toString( num ));
    }
}
