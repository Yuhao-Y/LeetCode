import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {  
  
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    int count;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2)  {  
        if( !v1.isEmpty() ) list.add( v1 );
        if( !v2.isEmpty() ) list.add( v2 );
        count = 0;
    }  
  
    public int next() {  
        int index = count++%list.size();
        
        List<Integer> tmp = list.get( index );
        int result = tmp.remove( 0 );
        
        if(tmp.isEmpty()) list.remove( tmp );
        
        return result;
    }  
  
    public boolean hasNext() {  
        return !list.isEmpty();
    } 
    
    public static void main( String[] args ) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        List<Integer> l3 = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        l1.add( 1 );
        l1.add( 2 );
        l1.add( 3 );
        l1.add( 4 );
        l1.add( 5 );
        l2.add( 11 );
        l2.add( 12 );
        l3.add( 111 );
        l3.add( 112 );
        l3.add( 113 );
        list.add( l1 );
        list.add( l2 );
        list.add( l3 );
        
        ZigzagIterator z = new ZigzagIterator( l1, l2 );
        while( z.hasNext()) {
            System.out.println(  z.next() );
        }
        
    }
}  
  
/** 
 * Your ZigzagIterator object will be instantiated and called as such: 
 * ZigzagIterator i = new ZigzagIterator(v1, v2); 
 * while (i.hasNext()) v[f()] = i.next(); 
 */  