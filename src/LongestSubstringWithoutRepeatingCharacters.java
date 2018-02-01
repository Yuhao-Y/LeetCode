import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters
{
    public int lengthOfLongestSubstring(String s) {
        
        if( s==null || s.length() == 0 ) return 0;
        
        int res = 0;
        int[] letters = new int[128];
        
        int lo=0, hi = 0;
        while( hi< s.length() ){
            
            while( hi<s.length() && ++letters[s.charAt(hi)]<=1 ) hi++;
            
            res = Math.max( hi - lo, res);
            
            while( lo<hi ){
                if( --letters[s.charAt(lo++)]==1 ) break;
            }
            
            hi++;
            
        }
        
        return res;
        
    }
    
    public int lengthOfLongestSubstringDP(String s) {
        
        if(s==null||s.length()==0) return 0; 
        if(s.length()==1) return 1;
        
        int[] count = new int[128];
        Arrays.fill(count,-1);
        int result = 0, currentIndex = 0;
        
        char[] charArray = s.toCharArray();
        for( int i=0;i<charArray.length;i++ ){
            currentIndex = Math.max(count[charArray[i]]+1, currentIndex);
            count[charArray[i]] = i;
            result = Math.max( result, i-currentIndex+1);    
        }
        
        return result;
    }
}
