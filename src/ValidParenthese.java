import java.util.LinkedList;

public class ValidParenthese
{
    public boolean isValid( String s )
    {
        LinkedList<Character> parenthese = new LinkedList<Character>();

        char[] sArray = s.toCharArray();

        for( char c : sArray )
        {
            if( c == ')' || c == '}' || c == ']' )
            {
                if( parenthese.size()==0||parenthese.peek() != c )
                {
                    return false;
                }
                else
                {
                    parenthese.pop();
                }
            }

            if( c == '(' )
            {
                parenthese.push( ')' );
            }
            else if( c == '{' )
            {
                parenthese.push( '}' );
            }
            else if( c == '[' )
            {
                parenthese.push( ']' );
            }
        }

        return parenthese.isEmpty();
    }

    public static void main( String[] args )
    {
        ValidParenthese v = new ValidParenthese();
        System.out.println( v.isValid( "]" ) );
    }
}
