import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TopKFrequentElements
{
    public List<Integer> topKFrequent( int[] nums, int k )
    {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for( int i = 0; i < nums.length; i++ )
        {
            int target = nums[i];
            if( map.containsKey( target ) )
                map.put( target, map.get( target ) + 1 );
            else
                map.put( target, 1 );
        }

        List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>( map.entrySet() );

        Collections.sort( list, new Comparator<Map.Entry<Integer, Integer>>()
        {

            @Override
            public int compare( Entry<Integer, Integer> arg0, Entry<Integer, Integer> arg1 )
            {
                return arg0.getValue().compareTo( arg1.getValue() );
            }
        } );

        for( int i = 0; i < k; i++ )
        {
            result.add( list.get( list.size() - 1 ).getValue() );
        }

        return result;

    }

    public List<Integer> topKFrequent2( int[] nums, int k )
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for( int i = 0; i < nums.length; i++ )
        {
            int target = nums[i];
            if( map.containsKey( target ) )
                map.put( target, map.get( target ) + 1 );
            else
                map.put( target, 1 );
        }

        TreeMap<Integer, List<Integer>> res = new TreeMap<Integer, List<Integer>>();
        for( Integer key : map.keySet() )
        {
            int value = map.get( key );
            if( res.containsKey( value ) )
            {
                res.get( value ).add( key );
            }
            else
            {
                List<Integer> list = new ArrayList<Integer>();
                list.add( key );
                res.put( value, list );
            }
        }

        for( int i = 0; i < k; )
        {
            List<Integer> list = res.pollLastEntry().getValue();
            for( Integer value : list )
            {
                result.add( value );
                i++;
            }
        }

        return result;

    }

    public List<Integer> topKFrequentBucketSort(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer>[] bucket = new List[nums.length+1];
        
        for( int i=0;i<nums.length;i++){      
            map.put(nums[i], map.getOrDefault( nums[i], 0 )+1);
        }
        
        for( Integer key: map.keySet()) {
            int val = map.get( key );
            if(bucket[val]==null) {
                bucket[val] = new ArrayList<Integer>();
            }
             bucket[val].add( key );
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for( int i=0, j = nums.length;i<k;) {
            if(bucket[j]!=null) {
                for(Integer value: bucket[j]) {
                    result.add( value );
                    i++;
                    if(i==k) break;
                }
            }
            j--;
        }
        
        return result;
        
    }
        

    public static void main( String[] args )
    {
        System.out.println( new TopKFrequentElements().topKFrequentBucketSort( new int[] { 1, 1, 1, 2, 2, 3 }, 2 ) );
    }
}
