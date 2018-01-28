import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaxium
{
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0) return new int[]{};
        
        int max = 0;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int[] result = new int[nums.length-k+1];
        
        int i=0;
        for(; i<k-1;i++){
            queue.add(nums[i]);
        }
        
        max = findMax(queue);
        
        for( int j=0;i<nums.length;i++,j++){
            queue.add(nums[i]);
            if(nums[i]>max){
                max = nums[i];
            }
            result[j] = max;
            
            int head = queue.poll();
            if(head==max){
                max = findMax(queue);
            }
        }
        
        return result;
    }
    
    public int findMax( Deque<Integer> queue){
        int max = Integer.MIN_VALUE;
        for(Integer i :queue){
            max = Math.max(max,i);
        }
        
        return max;
    }
    
    public int[] maxSlidingWindowWithDeque(int[] nums, int k) {
        if(k==0) return new int[]{};
    
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int[] result = new int[nums.length-k+1];
        
        for( int i=0;i<nums.length;i++){
            while(!queue.isEmpty()&&queue.peek()<(i-k+1))
                queue.poll();
            
            while(!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            
            if(i>=(k-1)){
                result[i-k+1] = nums[queue.peek()];
            }
                
        }
        
        return result;
    }
    
    
}
