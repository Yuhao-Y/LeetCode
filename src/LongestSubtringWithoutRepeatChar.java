import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class LongestSubtringWithoutRepeatChar
{
    public int lengthOfLongestSubstring( String string ){
        int maxlength = 0;
        Set<Character> charSet = new HashSet<Character>();
        
        for(int i=0;i<string.length();i++){
            int length=0;
            
            while(!charSet.contains( string.charAt( i ) ) ){
                charSet.add( string.charAt( i ) );
                length++;
            }
            
            
            charSet.clear();
            if(maxlength<length){
                maxlength = length;
            }
        }
        
        return maxlength;
    }
    
    static public int lengthOfLongestSubstring2( String string ){
        int maxLength = 0;
        Set<Character> charSet = new HashSet<Character>();
        
        for(int i=0;i<string.length();i++){
            
            if( !charSet.contains( string.charAt( i ) ) ) {
                String[] strArray = string.split( String.valueOf(string.charAt( i ) ) );
                
                for(String str: strArray){
                    System.out.println(str);
                    if(maxLength<str.length()){
                        maxLength = str.length();
                    }
                }
                
                charSet.add( string.charAt( i ) );
            }
        }
        
        return maxLength;
    }
    
    static public int lengthOfLongestSubstring3( String s ){
        int maxLength = 0;
        Set<Character> set = new HashSet<Character>();
        int i=0, j=0;
        
        while( i<s.length() ){
            if(!set.contains( s.charAt( i ) )){
                set.add( s.charAt( i ) );
                maxLength = Math.max( maxLength, set.size() );
                i++;
            }else{
                set.remove( s.charAt( j ) );
                j++;
            }
        }
        
        return maxLength;
    }
    
    static public int lengthOfLongestSubstring4(String s) {
        int[] mOccur = new int[256];
        int maxL = 0;
        for(int i = 0, j = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            ++mOccur[ch];
            while(mOccur[ch] > 1){
                --mOccur[s.charAt(j++)];
            }
            maxL = Math.max(maxL, i - j + 1);
        }
        return maxL;
    }
    
    public static void main(String[] args){
        System.out.println( LongestSubtringWithoutRepeatChar.lengthOfLongestSubstring4( "aab" ) );
    }
}
