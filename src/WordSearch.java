import java.util.HashSet;
import java.util.Set;

public class WordSearch
{
    public boolean exist( char[][] board, String word )
    {
        if( word == null || word.length() < 1 )
            return false;

        for( int i = 0; i < board.length; i++ )
            for( int j = 0; j < board[0].length; j++ )
            {
                if( dfs2( board, word, 0, i, j ) )
                {
                    return true;
                }
            }

        return false;

    }

    private boolean dfs( char[][] board, String word, int wordIndex, int curX, int curY )
    {
        if( wordIndex == ( word.length() ) )
            return true;

        if( board[curX][curY] == word.charAt( wordIndex ) )
        {
            board[curX][curY] = '*';
            if( ( wordIndex + 1 ) == ( word.length() ) )
                return true;

            if( ( curX + 1 ) < board.length && board[curX + 1][curY] == word.charAt( wordIndex + 1 ) )
            {
                if( dfs( board, word, wordIndex + 1, curX + 1, curY ) )
                    return true;
            }

            if( ( curX - 1 ) >= 0 && board[curX - 1][curY] == word.charAt( wordIndex + 1 ) )
            {
                if( dfs( board, word, wordIndex + 1, curX - 1, curY ) )
                    return true;
            }

            if( ( curY + 1 ) < board[0].length && board[curX][curY + 1] == word.charAt( wordIndex + 1 ) )
            {
                if( dfs( board, word, wordIndex + 1, curX, curY + 1 ) )
                    return true;
            }

            if( ( curY - 1 ) >= 0 && board[curX][curY - 1] == word.charAt( wordIndex + 1 ) )
            {
                if( dfs( board, word, wordIndex + 1, curX, curY - 1 ) )
                    return true;
            }
            board[curX][curY] = word.charAt( wordIndex );
        }

        return false;
    }

    private boolean dfs2( char[][] board, String word, int wordIndex, int x, int y )
    {
        if( wordIndex == ( word.length() ) )
            return true;

        if( x < 0 || y < 0 || x >= board.length || y >= board[0].length )
            return false;

        if( board[x][y] == word.charAt( wordIndex ) )
        {
            board[x][y] = '*';
            if( dfs2( board, word, wordIndex + 1, x + 1, y ) )return true;
            if( dfs2( board, word, wordIndex + 1, x - 1, y ) )return true;
            if( dfs2( board, word, wordIndex + 1, x, y + 1 ) )return true;
            if( dfs2( board, word, wordIndex + 1, x, y - 1 ) )return true;
            board[x][y] = word.charAt( wordIndex );
        }

        return false;
    }

    public static void main( String[] args )
    {
        System.out.println( new WordSearch().exist(
            new char[][] { { 'a', 'b', 'c', 'e' }, { 's', 'f', 'e', 's' }, { 'a', 'd', 'e', 'e' } }, "abceseeefs" ) );
    }
}
