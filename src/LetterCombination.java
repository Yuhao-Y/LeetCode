import java.util.LinkedList;
import java.util.List;

public class LetterCombination
{
    String[][] mobileNum = { { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
            { "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };

    public List<String> letterCombinations( String digits )
    {
        List<String> letterList = new LinkedList<String>();

        if( digits.length() <= 0 )
        {
            return letterList;
        }

        char[] digitNum = digits.toCharArray();

        for( int i = 0; i < mobileNum[Integer.parseInt( String.valueOf( digitNum[0] ) ) - 2].length; i++ )
        {
            letterList.add( mobileNum[Integer.parseInt( String.valueOf( digitNum[0] ) ) - 2][i] );
        }

        return combineLetter( 1, digitNum, letterList );
    }

    private List<String> combineLetter( int index, char[] digitNum, List<String> letterList )
    {
        if( index >= digitNum.length )
        {
            return letterList;
        }

        List<String> newLetterList = new LinkedList<String>();
        int num = Integer.parseInt( String.valueOf( digitNum[index] ) );
        for( String s : letterList )
        {
            for( int i = 0; i < mobileNum[num - 2].length; i++ )
            {
                newLetterList.add( s + mobileNum[num - 2][i] );
            }
        }

        index++;
        return combineLetter( index, digitNum, newLetterList );
    }

    public List<String> letterCombinations2( String digits )
    {
        LinkedList<String> letterList = new LinkedList<String>();

        if( digits.length() <= 0 )
        {
            return letterList;
        }

        char[] numArray = digits.toCharArray();

        for( int i = 0; i < digits.length(); i++ )
        {
            int num = Character.getNumericValue( numArray[i] );

            do
            {
                if( letterList.size() == 0 )
                {
                    for( int j = 0; j < mobileNum[num - 2].length; j++ )
                    {
                        letterList.add( mobileNum[num -2][j] );
                    }
                }else
                {
                    String firstString = letterList.removeFirst();
                    for( int j = 0; j < mobileNum[num - 2].length; j++ )
                    {
                        letterList.add( firstString + mobileNum[num -2][j] );
                    }
                }
            }
            while( letterList.peek().length() < ( i + 1 ) );
        }

        return letterList;
    }

    public static void main( String[] args )
    {
        LetterCombination l = new LetterCombination();
        System.out.println( l.letterCombinations2( "32" ) );
    }

}
