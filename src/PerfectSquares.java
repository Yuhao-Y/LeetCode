import java.util.ArrayList;
import java.util.Arrays;

public class PerfectSquares
{
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for( int i=1;i<=n;i++){
            int j=1;
            while((i-j*j)>=0){
                //dp[9] = Min(dp[9-1*1]+1,dp[9-2*2]+1,dp[9-3*3]+1
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                j++;
            }
        }
        return dp[n];
    }
    
    public static void main( String[] args) {
        
    }
}
