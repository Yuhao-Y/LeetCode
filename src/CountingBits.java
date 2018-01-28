
public class CountingBits
{
    public int[] countBits(int num) {
        if(num<1) return new int[]{0} ;
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for( int i=2;i<=num;i++){
            dp[i] = dp[i>>1]+(i&1);
        }
        
        return dp;
    }
}
