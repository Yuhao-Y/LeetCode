import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ThirdMaximumNumber
{
    public int thirdMaxWithPriorityQueue( int[] nums )
    {
        if( nums == null || nums.length <= 0 )
            return 0;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>( 1, new Comparator<Integer>()
        {
            @Override
            public int compare( Integer o1, Integer o2 )
            {
                if( o2 > o1 )
                    return 1;
                else
                    return -1;
            }
        } );

        for( Integer i : nums )
        {
            if( !queue.contains( i ) )
                queue.offer( i );
        }

        if( queue.size() > 2 )
        {
            for( int i = 0; i < 2; i++ )
                queue.poll();
        }
        return queue.peek();
    }
    
    public int thirdMaxWithSorted(int[] nums) {
        
        if( nums==null||nums.length<=0) return 0;
        
        Arrays.sort(nums);
        
        int j = nums.length-1;
      
        int result = nums[j];
        for( int i=0; i<2; i++){
            if(j<=0) return result;
            while( nums[j]==nums[j-1]) if(--j<=0) return result;
            j--;
        }
        
        return nums[j];
        
    }
    
    public int thirdMaxWithTheeVar(int[] nums) {
        
        if( nums==null||nums.length<=0) return 0;
        
        Integer max1 = null, max2 = null, max3 = null; // if the type of max is int, it must have a default value. This default value can be the third maximum value.
        
        for( Integer i: nums){
            if( i.equals( max1 ) || i.equals( max2 ) || i.equals( max3 )) continue; //use equals() to check whether two Integer is equal
            
            if( max1==null||i>max1){
                max3 = max2;
                max2 = max1;
                max1 = i;
            }else if( max2 == null || i>max2 ){
                max3 = max2;
                max2 = i;
            }else if( max3 == null || i>max3){
                max3 = i;
            }
        }
        
        return max3==null?max1:max3;
        
    }
    
    public static void main( String[] args) {
        char i = 2+'5';
        System.out.println( i );
    }
}
