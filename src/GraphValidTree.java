import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphValidTree
{
    public boolean validTree(int n, int[][] edges) {
        
        if( n>1 && edges.length == 0 ) return false;
        if( n == 0 || edges == null || edges.length == 0) return true;
        if( n == 1 || edges.length == 1 ) return true;
        
        HashSet<Integer> visited = new HashSet<Integer>();
        HashMap< Integer, Set<Integer>> map = new HashMap< Integer, Set<Integer>>();
        
        for( int i=0; i <edges.length; i++ ) {
            if( !map.containsKey( edges[i][0] )) map.put( edges[i][0], new HashSet<Integer>() );
            map.get( edges[i][0] ).add( edges[i][1] );
            if( !map.containsKey( edges[i][1] )) map.put( edges[i][1], new HashSet<Integer>() );
            map.get( edges[i][1] ).add( edges[i][0] );
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();   
        queue.add( 0 );
        visited.add( 0 );
        
        while( !queue.isEmpty() ) {
            for( int i=0; i< queue.size() ; i++) {
                int node = queue.poll();
                if( !map.containsKey( node ) ) continue;
                for( Integer neighbor: map.get( node )) {
                    if( visited.contains( neighbor )) return false;
                    
                    queue.add( neighbor );
                    visited.add( neighbor );
                    map.get( neighbor ).remove( node );
                }
            }
        }
        
        return visited.size() == n;
    }
    
    private int[] id;
    public boolean validTreeWithUF( int n, int[][] edges ) {
        
        id = new int[n];
        for( int i=0 ; i < n ; i++) id[i] = i;
        
        for( int i=0; i < edges.length; i++ ) {
            if( find(edges[i][0])!=find(edges[i][1])) {
                union(edges[i][0], edges[i][1]);
            }else
                return false;
        }
        
        return edges.length==n-1;
    }
    
    public int find( int a) {
        return id[a];
    }
    
    public void union( int a, int b) {
        for( int i=0; i< id.length ; i++) {
            if( id[i] == id[b] ) {
                id[i] = id[a];
            }
        }
    }
    
    public static void main( String[] args ) {
        System.out.println(  new GraphValidTree().validTreeWithUF( 3, new int[][]{ {0,1} } ) );
    }
}
