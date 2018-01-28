
public class RotateArray
{
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(nums.length<=0||k==0) return;
        reverse(nums, 0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
        
    }
    
    public void reverse( int nums[], int begin, int end){
        while(begin<end){
            if(nums[begin]!=nums[end]){
                nums[begin]=nums[end]^nums[begin];
                nums[end] = nums[end]^nums[begin];
                nums[begin] = nums[end]^nums[begin];
            }
            begin++;end--;
        }
    }
}
