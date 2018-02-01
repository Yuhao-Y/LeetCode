import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SortCharacterByFrequence
{
    public String frequencySort( String s )
    {
        if( s == null || s.length() <= 0 )
            return s;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for( Character c : s.toCharArray() )
        {
            if( map.containsKey( c ) )
            {
                map.put( c, map.get( c ) + 1 );
            }
            else
            {
                map.put( c, 1 );
            }
        }

        ArrayList<Character>[] bucket = new ArrayList[s.length() + 1];  //bucket sort
        for( Character c : map.keySet() )
        {
            if( bucket[map.get( c )] == null )
                bucket[map.get( c )] = new ArrayList<Character>();
            bucket[map.get( c )].add( c );
        }

        StringBuilder sb = new StringBuilder();
        for( int i = bucket.length - 1; i >= 0; i-- )
        {
            if( bucket[i] != null )
            {
                for( char c : bucket[i] )
                {
                    for( int j = 0; j < i; j++ )
                    {
                        sb.append( c );
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main( String[] args )
    {
        System.out.println( Arrays.toString( "abc".split( "b" ) ) );
        System.out.println( new SortCharacterByFrequence().frequencySort( "tree" ) );
    }
}
