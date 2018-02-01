
public class ProductOfArrayExceptSelf
{
    public int[] productExceptSelf( int[] nums )
    {
        int[] result = new int[nums.length];
        int product = 1;
        for( int i = 0; i < nums.length; i++ )
        {
            result[i] = product;
            product *= nums[i];
        }

        product = 1;
        for( int i = nums.length - 1; i >= 0; i-- )
        {
            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }

    public int[] productExceptSelf2( int[] nums )
    {
        recurive(nums, 0, 1, nums.length);
        return nums;
    }

    private int recurive( int[] result, int index, int product, int length )
    {
        if(index==length) return 1;
        
        int value = result[index];
        result[index] = product;

        int rightValue = recurive( result, index + 1, product * value,length );
        result[index] *= rightValue;
        return rightValue * value;
    }
}
