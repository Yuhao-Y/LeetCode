
public class FirstUniqueCharacterInAString
{
    public int firstUniqChar(String s) {
        //Array's performance is much higher than HashMap
        int[] symbolCount = new int[26];
        
        
        char[] sArray = s.toCharArray();
        
        for( int i=0;i < sArray.length; i++){
            symbolCount[sArray[i]-'a']++;
        }
        
        for( int i=0;i < sArray.length; i++){
            if(symbolCount[sArray[i]-'a']==1) return i;
        }
        
        return -1;
    }
}
