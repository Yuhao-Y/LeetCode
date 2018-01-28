public class CompressString
{
    public String compress( String str) {
        
        if( str==null || str.length()<=0 ) return str;
        
        StringBuffer sb = new StringBuffer();
        char[] strArray = str.toCharArray();
        
        for( int i=1; i <= strArray.length; i++) {
            int count = 1;
            while( i<strArray.length && strArray[i-1]==strArray[i]) {
                count++;
                i++;
            }
            
            if( count ==1 )
                sb.append( String.valueOf( strArray[i-1] ) );
            else
                sb.append( count+String.valueOf( strArray[i-1] )  );
            
        }
        
        
        return sb.toString();
    }
    
    public static void main( String[] args ) {
        System.out.println( new CompressString().compress( "xxxyyyyyyz" ) );
    }
}
