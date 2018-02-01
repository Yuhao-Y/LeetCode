import java.util.Arrays;

public class SortColors
{
    public void sortColors( int[] nums )
    {
        if( nums.length < 2 )
            return;

        int redCount = 0, whiteCount = 0, blueCount = 0;
        for( int i = 0; i < nums.length; i++ )
        {
            if( nums[i] == 0 )
                redCount++;
            else if( nums[i] == 1 )
                whiteCount++;
            else if( nums[i] == 2 )
                blueCount++;
        }

        Arrays.fill( nums, 0, redCount, 0 );
        Arrays.fill( nums, redCount, redCount + whiteCount, 1 );
        Arrays.fill( nums, redCount + whiteCount, nums.length, 2 );
        return;
    }

    //one pass
    public void sortColors2( int[] nums )
    {
        int left = 0, right = nums.length - 1, index = 0;
        while( index <= right )
        {
            //the order of the while-loop is important.
            while( right>index&&nums[index] == 2 )
            {
                nums[index]=nums[right];
                nums[right--]=2;
            }
            
            while( left<index&&nums[index] == 0 )
            {
                nums[index]=nums[left];
                nums[left++]=0;
            }
            
            index++;
        }
    }
    
    public void sortNum( int[] nums ) { //follow up of facebook
        
        if( nums == null || nums.length<=1 ) return;
        
        int left = 0, right = nums.length - 1, i=0;
        
        while( i <= right ) {
            
            if( nums[i]<=3) {
                swap( nums, i, left);
                left++;
                i++;
            }else if( nums[i]>=11 && nums[i]<=15 ) {
                swap( nums, i, right);
                right--;
            }else {
                i++;
            }
            
        }
        
    }
    
    public void swap( int[] nums, int a , int b ) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main( String[] args )
    {
        int[] nums = new int[] { 1,2,0 };
        new SortColors().sortColors2( nums );
        System.out.println( Arrays.toString( nums ) );
        
        int[] nums2 = new int[] {5,7,2,9,1,14,12,10,5,3};
        new SortColors().sortNum( nums2 );
        System.out.println( Arrays.toString( nums2 ) );
    }
}
