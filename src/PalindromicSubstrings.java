
public class PalindromicSubstrings
{
    public int countSubstrings(String s) {
        int count = 0;
        
        char[] sArray = s.toCharArray();
        for( int i=0;i < s.length();i++){
            count=count+countSubArray(sArray,i,i)+countSubArray(sArray,i,i+1);
        }
        
        return count;
    }
    
    public int countSubArray( char[] s, int left, int right){
        int count = 0;
        while(left>=0&&right<s.length){
            if(s[left--]==s[right++]){
                count++;
            }else{
                break;
            }
        }
        
        return count;
    }
}
