
public class LongestPalindromicSubsequence
{
    int maxLength = 0;
    public int longestPalindromeSubseqBruteforce(String s) {
        
        if( s== null ) return 0;
        if( s.length() == 1) return 1;
        
        char[] sArray = s.toCharArray();
        
        helper( sArray, 0, "");
        
        return maxLength;
    }
    
    private void helper( char[] s, int index, String str ){
        
        if( isPalindromic(str ) ) maxLength = Math.max( maxLength, str.length() );
        
        if( index >= s.length ){
            return;
        }
        
        for( int i=index; i< s.length; i++){
           helper( s, i+1, str+s[i]) ;
        }
        
    }
    
    private boolean isPalindromic( String str ){
        
        int lo = 0, hi = str.length()-1;
        
        while( lo<hi ){
            if( str.charAt(lo)!=str.charAt(hi) ) return false;
            lo++;
            hi--;
        }
        
        return true;
    }
}
