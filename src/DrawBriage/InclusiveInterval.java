package DrawBriage;
/*
 *  Given a set of inclusive intervals
 *  Calculate the minimum size of a set of number.
 *  where each interval contains at least two numbers in this set.
 *
 *  Example
 *  given [1,3], [1,4], [2,5].
 *  return 2. ([2,3])
 *
 *  given [2,4], [3,6], [0,2], [4,7].
 *  return 4. ([0,2,4,6] or [1,2,4,5])
 * */

import java.util.Comparator;
import java.util.PriorityQueue;

public class InclusiveInterval
{
    public int maxSet( int[][] intervals ) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( new Comparator<int[]>(){
            
            @Override
            public int compare( int[] a, int[] b ) {
                if( a[0] == b[0] ) {
                    return b[1] - a[1];
                }else {
                    return a[0] - b[0];
                }
            }
            
        } );
        
        for( int i=0; i < intervals.length; i++ ) {
            pq.offer( intervals[i] );
        }
        
        int count = 2;
        int[] pre = pq.poll();
        while( !pq.isEmpty() ) {
            
            int[] cur = pq.poll();
            
            if( cur[0]==pre[0] ) continue;
            
            if( cur[0] >=pre[1] ) {
                count += 2;
                pre = cur;
            }else {
                pre[1] = cur[1];
            }
            
        }
        
        return count;
    }
    
    public static void main( String[] args ) {
        System.out.print( new InclusiveInterval().maxSet( new int[][] { {2,4},{3,6},{0,2},{4,7} } ) );
    }
}
