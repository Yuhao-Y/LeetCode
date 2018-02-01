package Zappos;

import java.util.HashSet;

public class Gigawatts
{
    public boolean sum( int[] a, int[] b, int gigawatts ) {
        
        if( a==null || a.length == 0 || b == null || b.length == 0 ) return false;
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for( int i=0; i<a.length; i++ ) {
            set.add( a[i] );
        }
        
        for( int i=0; i<b.length; i++ ) {
            if( set.contains( gigawatts - b[i] )) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main( String[] args ) {
        
        System.out.println( new Gigawatts().sum( new int[] {5, 7, 2, 4}, new int[] {-3, 0, 1}, 8 ) );
        
    }
}
