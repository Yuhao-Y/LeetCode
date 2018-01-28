import java.util.Arrays;

public class LargestPlusSign
{
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        
        int[][] grid = new int[N][N];
        int res = 0;
        
        for( int i = 0 ; i < N ; i++ ){
            Arrays.fill( grid[i], N);  //fill a large number
        }
        
        for( int i = 0; i < mines.length; i++ ){
                grid[mines[i][0]][mines[i][1]] = 0;
        }
        
        for( int i = 0 ; i<N; i++ ){
            for( int j = 0, k = N-1, l = 0, r = 0, u = 0, d = 0; j<N; j++, k-- ){
                //if we meet mines, set the length to 0 and continue
                grid[i][j] = Math.min( grid[i][j], l = (grid[i][j]==0?0:l+1));  // find the length from left
                grid[i][k] = Math.min( grid[i][k], r = (grid[i][k]==0?0:r+1));  // find the length from right
                grid[j][i] = Math.min( grid[j][i], u = (grid[j][i]==0?0:u+1));  // find the length from up
                grid[k][i] = Math.min( grid[k][i], d = (grid[k][i]==0?0:d+1));  // find the length from bottom
            }
        }
        
        for( int i=0; i < N; i++ ){
            for( int j=0; j < N; j++){
                res = Math.max( res, grid[i][j] );
            }
        }
        
        return res;
    }
}
