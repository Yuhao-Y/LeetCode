import java.util.LinkedList;

public class TrappingRainWater
{
    public int trapWithStack(int[] height) {
        if(height==null||height.length<=0) return 0;
        int result=0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        
        for( int i=0;i<height.length;i++){
            if(stack.size()==0||height[i]<height[stack.peek()]){
                stack.push(i);
            }else{
                while(stack.size()>0&&height[i]>height[stack.peek()]){
                    int pre = stack.pop();
                    if(stack.size()>0)
                        result +=(Math.min(height[stack.peek()],height[i])-height[pre])*(i-stack.peek()-1);
                }
                
                stack.push(i);
            }
        }
        
        return result;
    }
    
    public int trapWithDP(int[] height) {
        if(height==null||height.length<=0) return 0;
        int result=0;
        int[] dp = new int[height.length];
        int max=0;
        for( int i=0;i<height.length;i++){
            dp[i] = max;
            max = Math.max(max,height[i]);
        }
        
        max=0;
        for( int i=height.length-1;i>=0;i--){
            int val = Math.min(dp[i],max) - height[i];
            result+= val>0?val:0;
            max = Math.max(max,height[i]);
        }
        
        return result;
    }
    
    public int trapWithTwoPointer(int[] height) {
        if(height==null||height.length<=0) return 0;
        int result=0;
        
        int left=0, right=height.length-1;
        while(left<right&&height[left]<height[left+1]) left++;
        while(left<right&&height[right]<height[right-1]) right--;
        
        while(left<right){
            int leftMax = height[left], rightMax = height[right];
            if(leftMax<rightMax){
                while(left<right&&height[++left]<leftMax) result +=leftMax-height[left];
            }else{
                while(left<right&&height[--right]<rightMax) result +=rightMax-height[right];
            }
        }
        
        return result;
    }
}
