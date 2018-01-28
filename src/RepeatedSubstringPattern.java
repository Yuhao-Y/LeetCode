
public class RepeatedSubstringPattern
{
    public boolean repeatedSubstringPattern(String s) {
        
        if( s==null || s.length()<=1 ) return false;
        
        for( int i=1; i <= s.length()/2; i++ ){
            if( s.length()%i==0){
                boolean isPattern = true;
                String str = s.substring( 0, i );
                int j = i;
                for(; (j+i)<=s.length(); j = j+i ){
                    if( (j+i)>s.length() || !s.substring( j , j+i ).equals(str) ){
                        isPattern = false;
                        break;
                    }
                }
            
                if( isPattern && j==s.length() ) return true;
            }
        }
        
        return false;
    }
}
