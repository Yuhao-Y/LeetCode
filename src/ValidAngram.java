import java.util.Arrays;

public class ValidAngram
{
    public boolean isAnagram2(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray,tArray);
    }
    
    public boolean isAnagram( String s, String t) {
        
        if(s.length()!=t.length()) return false;
        int[] symbols = new int[26];
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for( int i=0;i<s.length();i++){
            symbols[sArray[i]-'a']++;
            symbols[tArray[i]-'a']--;
        }
        
        for( int count: symbols){
            if(count!=0) return false;
        }
        return true;
    }
}
