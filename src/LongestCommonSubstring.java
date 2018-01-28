
public class LongestCommonSubstring
{
    /*
     * if A[i] == B[j], dp[i][j] =  dp[i-1][j-1] + 1
     * else if A[i] != B[j], dp[i][j] = 0
     */
    public int longestCommonSubstring(String A, String B) {
        int longest = 0;
        
        int[][] dp = new int[A.length()+1][B.length()+1];
        for( int i=1; i <dp.length ; i++ ){
            for( int j = 1; j< dp[0].length;  j++){
                if( A.charAt( i-1) == B.charAt( j-1 ) ){
                    dp[i][j] = dp[i-1][j-1]+1;
                    longest = Math.max( dp[i][j], longest );
                }
            }
        }
    
        return longest;
    }
}
