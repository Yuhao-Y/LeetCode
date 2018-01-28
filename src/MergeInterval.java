import java.util.ArrayList;
import java.util.List;

public class MergeInterval
{

    public List<Interval> merge( Interval[] A, Interval[] B ) {
        
        List<Interval> list = new ArrayList<Interval>();
        
        if( A==null || B == null ) return list;
        
        int i = 0, j = 0;
        
        while( i < A.length && j < B.length ) {
            
            if( A[i].end <= B[j].start ) i++;
            
            else if( B[j].end <= A[i].start ) j++;
            
            else {
                
                Interval interval = new Interval();
                
                interval.start = Math.max( A[i].start, B[j].start );
                interval.end = Math.min(  A[i].end, B[j].end );
                
                if(A[i].end > B[j].end)j++;
                else i++;
                
                list.add( interval );
                
            }
        }
        
        return list;
    }
    
    public static void main( String[] args ) {
        
        Interval[] A = new Interval[]{ new Interval(1, 2), new Interval(3, 4), new Interval(7, 10), new Interval(15, 16) };
        Interval[] B = new Interval[]{ new Interval(0, 2), new Interval(3, 8), new Interval(8, 12), new Interval(16, 17) };
        
        System.out.println( new MergeInterval().merge( A, B ) );
    }
}


