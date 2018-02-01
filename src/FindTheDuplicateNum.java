
public class FindTheDuplicateNum
{
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        // treat the array as a linked list. When slow meet fast, fast have been passed two time path than slow. 
        // Let A = from list's start point to circle's start point, B = circle's start point to meet point, C = circle length.
        // (A+B+C) = 2*(A+B) -> C = A+B
        // A = C-B
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
                        
        fast = 0;
        while( slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
                        
        return fast;        
    }
    
    public int findDucplicateBinarySearch( int[] nums) {
        int max = nums.length-1, min = 0;
        
        while(min<=max) {
            int mid = (min+max)/2;
            int count = 0;
            for( int i=0;i<nums.length;i++) {
                //notice <=
                if(nums[i]<=mid) {
                    count++;
                }
            }
            
            //target bee found when min==max, but the count still great than mid at this time and max minus 1. So min be returned at last
            if(count>mid) max = mid-1;
            else min = mid+1;
        }
        
        return min;
    }
    
    public static void main( String[] args) {
        System.out.println(new FindTheDuplicateNum().findDuplicate(new int[] {1,3,4,2,1}));
    }
}
