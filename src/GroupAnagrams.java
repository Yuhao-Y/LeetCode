import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams
{
    public List<List<String>> groupAnagrams( String[] strs )
    {
        List<List<String>> result = new ArrayList<List<String>>();

        Map<String, List<String>> anagramsMap = new HashMap<String, List<String>>();

        for( int i = 0; i < strs.length; i++ )
        {
            char[] letterOfString = strs[i].toCharArray();
            Arrays.sort( letterOfString );

            String word = String.valueOf( letterOfString );
            if( anagramsMap.containsKey( word ) )
            {
                anagramsMap.get( word ).add( strs[i] );
            }
            else
            {
                List<String> stringList = new ArrayList<String>();
                stringList.add( strs[i] );

                anagramsMap.put( word, stringList );
            }

        }

        result.addAll( anagramsMap.values() );
        return result;
    }
    
    public List<List<String>> groupAnagrams2( String[] strs )
    {
        List<List<String>> result = new ArrayList<List<String>>();

        Map<String, Integer> anagramsMap = new HashMap<String, Integer>();

        for( int i = 0; i < strs.length; i++ )
        {
            char[] letterOfString = strs[i].toCharArray();
            Arrays.sort( letterOfString );

            String word = String.valueOf( letterOfString );
            if( anagramsMap.containsKey( word ) )
            {
                result.get( anagramsMap.get( word ) ).add( strs[i] );
            }
            else
            {
                List<String> stringList = new ArrayList<String>();
                stringList.add( strs[i] );
                result.add( stringList );
                anagramsMap.put( word, result.size()-1 );
            }

        }

        return result;
    }

    public static void main( String[] args )
    {
        GroupAnagrams g = new GroupAnagrams();
        System.out.println( g.groupAnagrams2( new String[] { "tea", "ate", "", "" } ) );
    }
}
