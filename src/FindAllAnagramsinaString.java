import java.util.ArrayList;
import java.util.Arrays;
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
    
    public List<Integer> findAnagramsTemplate( String s, String p )
    {
        List<Integer> result = new ArrayList<Integer>();
        
         if(s==null||s.length()<=0||p==null||p.length()<=0||s.length()<p.length()) return result;
        
        int[] symbolCount = new int[26];
        int[] template = new int[26];
        char[] charArray = p.toCharArray();
        for(int i=0;i<p.length();i++){
            symbolCount[charArray[i]-'a']++;
        }
        
        charArray = s.toCharArray();
        int i=0;
        for(;i<p.length()-1;i++){    // i<p.length()-1 is means initial window just have p.length-1 number of elements. And it will add the last element in the second loop 
            symbolCount[charArray[i]-'a']--;
        }
        
        for(int j=0;i<s.length();i++,j++){
            symbolCount[charArray[i]-'a']--;  //initial winows's length is p.length()-1, so it should add a element firstly.
            if(Arrays.equals(symbolCount,template)) result.add(j);
            symbolCount[charArray[j]-'a']++;
        }
        
        return result;
         
    }

    public static void main( String[] args )
    {
        System.out.println( new FindAllAnagramsinaString().findAnagrams( "baa", "aa" ) );
    }
}
