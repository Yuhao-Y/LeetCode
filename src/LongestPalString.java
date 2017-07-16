public class LongestPalString
{
    public int maxLength = 0;
    public int beginIndex = 0;

    public String longestPalindrome( String s )
    {
        char[] sArray = s.toCharArray();

        for( int i = 0; i < sArray.length; i++ )
        {
            if( sArray.length - i <= maxLength )
            {
                break;
            }

            if( isPalindrome( sArray, i - maxLength + 1, i ) )
            {
                int begin = i - maxLength + 1;
                int end = i;
                while( sArray[begin] == sArray[end]&&begin>=0&&end<sArray.length )
                {
                    if( ( end - begin + 1 ) > maxLength )
                    {
                        maxLength = end - begin + 1;
                        beginIndex = begin;
                    }
                    
                    begin--;
                    end++;
                }
            }
        }

        return s.substring( beginIndex, maxLength );
    }

    private boolean isPalindrome( char[] sArray, int begin, int end )
    {
        while( begin <= end )
        {
            if( sArray[begin++] != sArray[end++] )
            {
                return false;
            }
        }

        return true;
    }

    public static void main( String[] args )
    {
        LongestPalString longestPS = new LongestPalString();
        System.out.println( longestPS.longestPalindrome( "bb" ) );
    }
}
