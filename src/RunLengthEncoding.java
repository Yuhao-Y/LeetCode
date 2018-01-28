
public class RunLengthEncoding
{
    public String encoding( String str ) {
        
        if( str == null || str.length() == 1 ) return str;
        
        String compress = "";
        
        for( int i = 1; i<=str.length() ; i++ ) {
            char count = 1;
            while( i<str.length() && str.charAt(i) == str.charAt( i-1 )) {
                count++;
                i++;
            }
            compress += count+""+str.charAt( i-1 );
        }
        
        return compress;
    }
    
    public String decoding( String str ) {
        
        if( (str.length()&1)!=0 ) return null;
        
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i<str.length(); i = i+2 ) {
            
            char length = str.charAt(i);
            char symbol = str.charAt( i+1 );
            for( int j =0 ; j<length ; j++ ) {
                sb.append( symbol );
            }
            
        }
        
        return sb.toString();
    }
    
    public static void main( String[] args ) {
        String rawString = "aaaaaaaaaaaabbbbbbbbbbbbbbbbbcd";
        String str = new RunLengthEncoding().encoding( rawString );
        System.out.println( str );
        System.out.println( rawString );
        System.out.println( new RunLengthEncoding().decoding( str ) );
    }
    
}
