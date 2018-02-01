package DrawBriage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//把array里的数字按照二进制形式里1的个数排序，少的在前，个数相等的话，小的在前，比如[3, 4]，排序后[4, 3]，[1, 2]排序后还是[1,2]
public class SortNumberByBit
{
    public List<Integer> sortByBit( List<Integer> list ){
        
        if( list == null || list.size() == 0 ) return list;
        
        Collections.sort( list, new Comparator<Integer>() {
            
            @Override
            public int compare( Integer a, Integer b ) {
                
                int aBit = Integer.bitCount( a );
                int bBit = Integer.bitCount( b );
                
                if( aBit == bBit ) {
                    return a - b;
                }else if( aBit > bBit) {
                    return 1;
                }else {
                    return -1;
                }
                
            }
        } );
        
        return list;
    }
    
    public static void main( String[] args ) {
        
        List<Integer> list = new ArrayList<Integer>();
        list.add( 16 );
        list.add( 3);
        list.add( 1);
        
        System.out.println(  new SortNumberByBit().sortByBit( list ) );
    }
}
