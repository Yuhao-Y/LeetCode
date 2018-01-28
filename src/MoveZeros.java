
public class MoveZeros
{
    //O(n^2)
    public void moveZeroes( int[] nums )
    {
        int begin = 0, end = nums.length - 1;
        while( begin < end )
        {
            if( nums[begin] == 0 )
            {
                System.arraycopy( nums, begin + 1, nums, begin, end - begin );
                nums[end--] = 0;
            }
            else
            {
                begin++;
            }

        }
    }

    //O(n)
    public void moveZeroes2( int[] nums )
    {
        int position = 0;
        for( int i = 0; i < nums.length; i++ )
        {
            if( nums[i] != 0 )
            {
                nums[position++] = nums[i];
            }
        }
        
        while(position<nums.length)
        {
            nums[position++] = 0; 
        }
    }
    
    public void moveZeroes3( int[] nums ){
        
        if( nums == null || nums.length<2) return;
        
        int j = 0;
        for( int i=0; i< nums.length; i++){
            if( nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            
                j++;
            }
        }
    }
}
