import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueue
{
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> res = new ArrayList<List<String>>();
        
        if( n == 0 ) return res;
        
        char[][] chessboard = new char[n][n];
        for( int i=0; i < n ; i++ ){
            Arrays.fill(chessboard[i],'.');
        }
        

        
        helper( n, 0, chessboard, res);
        
        return res;
    }
    
    private void helper( int n, int row, char[][] chessboard, List<List<String>> res ){
        
        if( row == n ) {
            List<String> chess = new ArrayList<String>();
            for( int i=0; i <chessboard.length; i++ ){
                chess.add( String.valueOf(chessboard[i]) );
            }
            res.add( chess );
            return;
        }
        
        for( int i = 0; i<n; i++ ){
            
            if( !isValid( chessboard, row, i) ) continue;
            
            chessboard[row][i] = 'Q';
            helper( n, row+1, chessboard, res);
            
            chessboard[row][i] = '.';
        }
        
    }
    
    private boolean isValid( char[][] chessboard, int i, int j ){
        
        int index = 0;
        while( j+index < chessboard[0].length || i - index >= 0 || j - index >= 0 ){
            
            if( i-index<0 ) break;
            
            if( j+index < chessboard[0].length && chessboard[i-index][j+index]=='Q' ) return false;
            if( j-index >=0 && chessboard[i-index][j-index]=='Q' ) return false;
            if( chessboard[i-index][j]=='Q' ) return false;
            index++;
        }
        
        return true;
        
    }
    
    
    public List<List<String>> solveNQueens2(int n) {
        
        List<List<String>> res = new ArrayList<List<String>>();
        
        if( n == 0 ) return res;
        
        boolean[] record = new boolean[n];
        boolean[] record45 = new boolean[2*n-1];
        boolean[] record135 = new boolean[2*n-1];
        
        char[][] chessboard = new char[n][n];
        for( int i=0; i < n ; i++ ){
            Arrays.fill(chessboard[i],'.');
        }
        
        helper( n, 0, chessboard, res, record, record45, record135);
        
        return res;
    }
    
    private void helper( int n, int row, char[][] chessboard, List<List<String>> res, boolean[] record, boolean[] record45, boolean[] record135 ){
        
        if( row == n ) {
            List<String> chess = new ArrayList<String>();
            for( int i=0; i <chessboard.length; i++ ){
                chess.add( String.valueOf(chessboard[i]) );
            }
            res.add( chess );
            return;
        }
        
        for( int i = 0; i<n; i++ ){
            
            if( record[i] || record45[row+i] || record135[i-row+n-1]  ) continue;
            
            chessboard[row][i] = 'Q';
            record[i] = true;
            record45[row+i] = true;
            record135[i-row+n-1] = true;
            
            helper( n, row+1, chessboard, res, record, record45, record135);
            
            record[i] = false;
            record45[row+i] = false;
            record135[i-row+n-1] = false;
            
            chessboard[row][i] = '.';
        }
        
    }
}
