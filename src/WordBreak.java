import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak
{
    public boolean wordBreak( String s, List<String> wordDict )
    {
        LinkedList<Integer> wordIndexAfterRemove = new LinkedList<Integer>();
        wordIndexAfterRemove.add( 0 );
        Set<Integer> visited = new HashSet<Integer>();

        while( wordIndexAfterRemove.size() > 0 )
        {
            int start = wordIndexAfterRemove.poll();
            for( int i = start + 1; i <= s.length(); i++ )
            {
                if( visited.contains( i ) )
                    continue;
                if( wordDict.contains( s.substring( start, i ) ) )
                {
                    if( i == s.length() )
                        return true;
                    wordIndexAfterRemove.add( i );
                    visited.add( i );
                }
            }
        }

        return false;
    }

    public boolean wordBreakDP( String s, List<String> wordDict )
    {
        boolean[] boolArray = new boolean[s.length()+1];
        boolArray[0] = true;

        for( int i = 1; i <= s.length(); i++ )
        {
            for( int j = 0; j < i; j++ )
            {
                if( boolArray[j] && wordDict.contains( s.substring( j, i ) ) )
                {
                    boolArray[i] = true;
                    break;
                }
            }
        }

        return boolArray[boolArray.length - 1];
    }

    public static void main( String args[] )
    {
        LinkedList<String> wordDict = new LinkedList<String>();
        wordDict.add( "leet" );
        //wordDict.add( "abc" );
        wordDict.add( "code" );
       // wordDict.add( "cd" );

        System.out.println( new WordBreak().wordBreakDP( "leetcode", wordDict ) );
    }
}
