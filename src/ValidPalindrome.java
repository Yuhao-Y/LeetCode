
public class ValidPalindrome
{
    public boolean isPalindrome( String s )
    {

        if( s == null || s.length() <= 0 )
            return true;

        s = s.toLowerCase();

        int low = 0, high = s.length() - 1;

        while( low < high )
        {

            //while( low<high&&(s.charAt(low) < 'a' || s.charAt( low ) >'z')&&(s.charAt(low) < '0' || s.charAt( low ) >'9')) low++;
            //while( low<high&&(s.charAt(high) < 'a' || s.charAt( high ) >'z')&&(s.charAt(high) < '0' || s.charAt( high ) >'9')) high--;
            //while( low<high&&!Character.isLetterOrDigit( s.charAt(low) )) low++;
            //while( low<high&&!Character.isLetterOrDigit( s.charAt(high) )) high--;
            if( low > high || s.charAt( low ) != s.charAt( high ) )
                return false;
            low++;
            high--;
        }
        
        return true;

    }
}
