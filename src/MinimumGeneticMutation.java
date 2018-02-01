import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumGeneticMutation
{
    char[] geneticSymbol = { 'A', 'C', 'G', 'T' };

    public int minMutation( String start, String end, String[] bank )
    {
        List<String> bankList = new ArrayList<String>();
        
        char[] startArray = start.toCharArray();
        char[] endArray = end.toCharArray();

        for( String s : bank )
        {
            bankList.add( s );
        }

        return isValid( startArray, endArray, -1, bankList, 0, new ArrayList<String>() );
    }

    public int isValid( char[] genetic, char[] geneticEnd, int index, List<String> bankList, int count,
        List<String> geneticSequence )
    {
        if( index != -1 && !bankList.contains( String.valueOf( genetic ) ) )
            return -1;
        
        if(geneticSequence.contains( String.valueOf( genetic ))) return -1;
        
        geneticSequence.add( String.valueOf( genetic ) );
        if( Arrays.equals( genetic, geneticEnd ) )
            return count;
   
        for( int currentIndex = 0; currentIndex < genetic.length; currentIndex++ )
        {
            char tmp = genetic[currentIndex];
            for( int j = 0; j < geneticSymbol.length; j++ )
            {
                if( tmp != geneticSymbol[j] )
                {
                    genetic[currentIndex] = geneticSymbol[j];

                    count = isValid( genetic, geneticEnd, currentIndex, bankList, count, geneticSequence );
                    if( count >= 0 )
                    {
                        return count + 1;
                    }
                    else
                        count = 0;
                }

            }
            genetic[currentIndex] = tmp;
            count = 0;

        }
        return -1;
    }

    public static void main( String[] args )
    {

                System.out.println( new MinimumGeneticMutation().minMutation( "AACCGGTT", "AAACGGTA",
                    new String[] { "AACCGGTA","AACCGCTA","AAACGGTA" } ) );
        //new String[] { "AAACGGTA" } ) );
//        System.out.println( new MinimumGeneticMutation().minMutation( "AACCGGTT", "AAACGGTA",
//            new String[] { "AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA" } ) );
    }
}
