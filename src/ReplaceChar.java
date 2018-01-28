import java.util.Arrays;

public class ReplaceChar
{
    public String replace( String str ){
        
        if( str == null || str.length()<3 ) return str;
        
        char[] strArray = str.toCharArray();
        
        int slow = 0, fast = 0;
        
        while( fast<strArray.length) {
            
            if( strArray[fast]=='%'&&fast<(strArray.length-2)&& strArray[fast+1]=='2' && strArray[ fast+2]=='0') {
                strArray[slow] = ' ';
                slow++;
                fast = fast+3;
            }else {
                strArray[slow] = strArray[fast];
                fast++;
                slow++;
            }
        }
        
        return String.valueOf( Arrays.copyOf( strArray, slow ) );
    }
    
    public static void main(String[] args ) {
        System.out.println(  new ReplaceChar().replace( "abcd%20ef%20%" ) );
    }
}
