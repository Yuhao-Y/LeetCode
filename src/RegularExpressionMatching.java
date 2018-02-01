
public class RegularExpressionMatching
{
    public boolean isMatch(String s, String p) {
        return compareBruteForece( s.toCharArray(), 0, p.toCharArray(), 0);
    }
    
    public boolean compareBruteForece( char[] sArray, int sStart, char[] pArray, int pStart ){
        if( pStart == pArray.length ) return sArray.length == sStart;
        
        if( pStart == ( pArray.length-1) || pArray[pStart+1] != '*' ) {
            
            if( sStart==sArray.length ) return false;
            
            if( pArray[pStart] =='.' ){
                return compareBruteForece( sArray, sStart+1, pArray, pStart+1);
            }else if( pArray[pStart] == sArray[sStart] ){
                return compareBruteForece( sArray, sStart+1, pArray, pStart+1);
            }else if( pArray[pStart] != sArray[sStart] ) {
                return false;
            }
        }
        
        if( pArray[pStart+1] == '*'){
            
            int i = sStart;
            while( i<sArray.length && ( pArray[pStart] == '.' || sArray[i] == pArray[pStart] ) ) {
                
                i++;
                
                if( compareBruteForece(sArray, i, pArray,pStart+2)){
                    return true;
                }
                
                
            }
            
        }
                  
        return compareBruteForece( sArray, sStart, pArray, pStart+2);
    } 
    
    public boolean isMatchDP(String s, String p) {
        
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        
        dp[0][0] = true;
        
        for( int i = 1; i <= p.length(); i++ ){     //when s is "", compare with p.
            if( p.charAt(i-1) == '*' ){
                if( dp[0][i-1] || ( i >1 && dp[0][i-2] ) ){
                    dp[0][i] = true;
                }
            }
        }
        
        for( int i = 1; i <= s.length(); i++ ){
            
            for( int j = 1; j<= p.length(); j++){
                
                if( s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.' ){   //when s.charAt(i-1) == p.charAt(j-1)
                    dp[i][j] = dp[i-1][j-1];
                }
                
                if( p.charAt(j-1) == '*'){
                    if( s.charAt(i-1)!=p.charAt(j-2) && p.charAt(j-2)!='.' ){   //only can count x* as empty, because s.charAt(i-1) not equal p.charAt(j-2)
                        dp[i][j] = dp[i][j-2];
                    }else{
                        //dp[i][j-1] means count x* as single x
                        //dp[i][i-2] means count x* as empty  
                        //dp[i-1][j] means x* as multiple x
                        dp[i][j] = dp[i][j-1] || dp[i][j-2] || dp[i-1][j];  
                    }
                    
                }
            }
            
        }
        
        for( int i = 0; i<dp.length; i++ ) {
            for( int j=0; j<dp[0].length; j++ ) {
                if( dp[i][j]) System.out.print( "T " );
                else System.out.print( "F " );
            }
            System.out.println( "" );
        }
        
        return dp[s.length()][p.length()];
    }
    
    public static void main( String[] args ) {
        System.out.println( new RegularExpressionMatching().isMatchDP( "aab","c*a*b" ));
    }
}
