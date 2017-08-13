import java.util.HashSet;
import java.util.Set;

public class ValidSudoku
{
    public boolean isValidSudoku( char[][] board )
    {
        for( int i = 0; i < board.length; i++ )
        {
            Set<Character> column = new HashSet<Character>();
            Set<Character> row = new HashSet<Character>();
            Set<Character> subGrid = new HashSet<Character>();
            for( int j = 0; j < board[i].length; j++ )
            {
                if( board[i][j] != '.' && board[i][j] >= '0' && board[i][j] <= '9' )
                {
                    if( !row.add( board[i][j] ) )
                        return false;
                }

                if( board[j][i] != '.' && board[j][i] >= '0' && board[j][i] <= '9' )
                {
                    if( !column.add( board[j][i] ) )
                        return false;
                }

                if( ( board[j / 3 + i / 3 * 3][j % 3 + i % 3 * 3] != '.' )
                    && ( board[j / 3 + i / 3 * 3][j % 3 + i % 3 * 3] >= '0' )
                    && ( board[j / 3 + i / 3 * 3][j % 3 + i % 3 * 3] <= '9' ) )
                {

                    if( !subGrid.add( board[j / 3 + i / 3 * 3][j % 3 + i % 3 * 3] ) )
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2( char[][] board )
    {
        Set<Integer> seen = new HashSet<Integer>();
        for( int i = 0; i < 9; i++ )
        {
            for( int j = 0; j < 9; j++ )
            {
                char number = board[i][j];
                if( number != '.' )
                    if( !seen.add( Integer.valueOf( String.valueOf(1) + number + i ) ) || 
                        !seen.add( Integer.valueOf( String.valueOf(2) + number + j ) ) || 
                        !seen.add( Integer.valueOf( String.valueOf(3) + number + i / 3  + j / 3 ) ) )
                return false;
            }
        }

        return true;
    }

    public static void main( String[] args )
    {
        System.out.println( new ValidSudoku().isValidSudoku2( new char[][] {
                { '.', '.', '.', '5', '.', '.', '.', '1', '.' }, 
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '3', '.', '.', '1' }, 
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' },
                { '.', '.', '2', '.', '7', '.', '.', '.', '.' }, 
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '2', '.', '.', '.' }, 
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' },
                { '.', '.', '4', '.', '.', '.', '.', '.', '.' } } ) );
    }
}
