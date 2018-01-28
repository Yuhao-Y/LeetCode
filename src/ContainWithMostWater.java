
public class ContainWithMostWater
{
    public int maxArea(int[] heights) {
        int result=0;
        int lo=0, hi=heights.length-1;
        while(lo<hi){
            
            if(heights[lo]<heights[hi]){ 
                result = Math.max(result, heights[lo]*(hi-lo));
                lo++;
            }
            else{
                result = Math.max(result, heights[hi]*(hi-lo));
                hi--;
            }
        }
        
        return result;
    }
}
