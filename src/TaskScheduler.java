import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TaskScheduler
{
    public int leastInterval(char[] tasks, int n) {
        
        int[] count = new int[26];
        
        for( int i=0; i<tasks.length; i++){
            count[tasks[i]-'A']++;
        }
        
        Arrays.sort( count );
        
        int i = 25;
        while( i>=0 && count[i] == count[25] ) i--;
        
        return Math.max( tasks.length, (count[25]-1)*(n+1)+25-i);
        
    }
    
    public int leastIntervalInOrder( char[] tasks, int n) {
        
        if( tasks == null || tasks.length<=0) return 0;
        
        int res = 0;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for( int i=0; i < tasks.length ; i++) {
            
            if( map.containsKey( tasks[i] )&&( res - map.get( tasks[i] ) )<n ) {
                res = map.get( tasks[i] )+n+1;
                map.put( tasks[i], res );
            }else {
                res++;
                map.put( tasks[i], res );
            }
            
            for (Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator(); it.hasNext();){
                Map.Entry<Character, Integer> item = it.next();
                if( ( res - item.getValue() )>n ) {
                    it.remove();
                }
            }
            
        }
        
        
        return res;
    }
    
    public int leastIntervalInOrder2( char[] tasks, int n ) {
        if( tasks == null || tasks.length== 0 ) return 0;
        
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for( int i =0 ; i<tasks.length; i++) {
            if( map.containsKey( tasks[i] ) && map.get( tasks[i] )>res ) {
                res = map.get( tasks[i] );
            }
            map.put( tasks[i], res+n+1);
            res++;
        }
        
        
        return res;
    }
    
    public static void main( String[] args ) {
        System.out.println( new TaskScheduler().leastIntervalInOrder( new char[] {'A','B','B','A','B','B','C'}, 3 ) );
        System.out.println( new TaskScheduler().leastIntervalInOrder2( new char[] {'A','B','B','A','B','B','C'}, 3 ) );
    }
}
