package Zappos;

public class FixTheInfiniteImprobabilityDrive
{
    public String remove( String coordinates, int remove ) {
        
        if( remove >= coordinates.length() ) return "0";
        
        if( remove == 0 ) return coordinates;
        
        char[] res = new char[coordinates.length() - remove ];
        
        int index = -1;
        for( int i=0; i < res.length; i++ ) {
            
            index = findMin( coordinates,  index+1, coordinates.length()- res.length  +i );
            res[i] = coordinates.charAt( index );
        }
        
        return String.valueOf( res );
        
    }
    
    private int findMin( String coordinates, int start, int end ) {
        int min = start;
        
        for( ; start<=end; start++ ) {
            if( coordinates.charAt(start) <coordinates.charAt( min ) ) {
                min = start;
            }
        }
        
        return min;
    }
    
    public String remove2( String coordinates, int remove ) {
        
        if( remove >= coordinates.length() ) return "0";
        
        if( remove == 0 ) return coordinates;
        
        int length = coordinates.length() - remove;
        char[] res = new char[ coordinates.length() ];
        int top = 0;
        
        for( int i=0; i <coordinates.length(); i++ ) {
            
            char c = coordinates.charAt( i );
            
            while( top>0 && res[top-1]>c && remove>0 ) {
                top--;
                remove--;
            }
            
            res[top++] = c;
            
        }
        
        
        return String.valueOf( res ).substring( 0, length );
    }
    
    public static void main( String[] args ) {
        
        System.out.println( new FixTheInfiniteImprobabilityDrive().remove2( "746209249", 5 ) );
        
    }
}
