
public class PermutationInString
{
    public boolean checkInclusion(String s1, String s2) {
        
        if( s1.length() > s2.length() ) return false;
        
        int[] letters = new int[26];
        int degree = s1.length();
        
        for( int i=0; i< s1.length() ; i++) {
            letters[s1.charAt(i)-'a']++;
        }
        
        int j=0;
        for(; j <(s1.length()-1 ); j++){
            if( --letters[s2.charAt(j)-'a']>=0) degree--;
        }
        
        for( int k=0;j<(s2.length() ); j++,k++){
            if( --letters[s2.charAt(j)-'a']>=0) degree--;
            
            if( degree==0) return true;
            
            if( ++letters[s2.charAt(k)-'a']>0) degree++;
        
        }
        
        return false;
    }
}
