import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsinaString
{
    public List<Integer> findAnagrams( String s, String p )
    {
        List<Integer> result = new LinkedList<Integer>();
        if( s.length() < p.length() )
            return result;
        int begin = 0, end = 0;
        int differenceDegree = p.length();    //record the difference degree of target string and string in window.
        int[] hash = new int[26];             // hash array record the difference of the symbol from begin to end

        for( char c : p.toCharArray() )
        {
            hash[c - 'a']++;
        }

        for( ; end < s.length(); end++ )
        {
            hash[s.charAt( end ) - 'a']--;
            if( hash[s.charAt( end ) - 'a'] >= 0 )
            {
                differenceDegree--;
            }

            if( ( end - begin + 1 ) == p.length() )
            {
                if( differenceDegree == 0 )
                    result.add( begin );

                if( hash[s.charAt( begin ) - 'a'] >= 0 )
                {
                    differenceDegree++;
                }
                hash[s.charAt( begin ) - 'a']++;
                
                begin++;
            }
        }

        return result;
    }

    public static void main( String[] args )
    {
        System.out.println( new FindAllAnagramsinaString().findAnagrams( "baa", "aa" ) );
    }
}
