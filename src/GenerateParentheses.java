import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses
{
    public List<String> parenthesis = new ArrayList<String>();

    public List<String> generateParenthesis( int n )
    {
        if( n > 0 )
        {
            String s = new String();
            //addParentheses( 1, 0, n, s );
            backtracking(s,n,n,n);
        }
        
        return parenthesis;
    }

    private void addParentheses( int level, int lastLevel, int total, String s )
    {
        s = s + "(";

        if( level == total )
        {
            for( int i = 0; i < total - lastLevel; i++ )
            {
                s = s + ")";
            }
            parenthesis.add( s );
            return;
        }

        for( int i = 0; i <= ( level - lastLevel ); i++ )
        {
            String newS = s;
            for( int j = 0; j < i; j++ )
            {
                newS = newS + ")";
            }

            addParentheses( level + 1, i + lastLevel, total, newS );
        }

        return;
    }
    
    private void backtracking(String s, int left, int right, int n)
    {
        if(left==0&&right==0)
        {
            parenthesis.add( s );
            return;
        }
        
        if(left>right)
        {
            return;
        }
        
        if(left>0)
        {
            backtracking(s+"(",left-1,right,n);
        }
        
        if(right>0)
        {
            backtracking(s+")",left, right-1, n);
        }
    }

    public static void main( String[] args )
    {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println( g.generateParenthesis( 3 ) );
    }
}
