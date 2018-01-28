import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumLenghtOfPairChain
{
    public int findLongestChain(int[][] pairs) {
        
        if( pairs==null ) return 0;
        
        PriorityQueue< int[]> pq = new PriorityQueue<int[]>( new Comparator<int[]>(){
            
            @Override
            public int compare(int[] a, int[] b ){
                
                return a[0]-b[0];    //can sort by a[1]-b[1].
            }
            
        });
        
        for( int i=0; i < pairs.length; i++){
            pq.offer( pairs[i] );
        }
        
        List<int[]> list = new ArrayList<int[]>();
        list.add( pq.poll() );
        while( !pq.isEmpty() ) {
            
            int[] src = pq.poll();
            int[] tar = list.get( list.size()-1 );
            
            if( src[1]<tar[1] ){
                list.set( list.size()-1, src );
            }else if( src[0]>tar[1] ){
                list.add( src ); 
            }
        }
        
        return list.size();
        
    }
}
