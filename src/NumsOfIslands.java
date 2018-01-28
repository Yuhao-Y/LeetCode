import java.util.Arrays;

public class NumsOfIslands
{
    public int numIslands(char[][] grid) {
        int count=0;
        for( int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){    //traverse every grid
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
          
    }
    
               
     private void dfs( int i, int j, char[][] grid ){
         if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!='1') return;

         grid[i][j] = '0';          // key step, set the position to zero which is include in island
         dfs( i+1, j, grid);
         dfs( i-1, j, grid);
         dfs( i,j+1, grid);
         dfs( i,j-1, grid);
     }

    public static void main( String[] args )
    {
        System.out.println(
            new NumsOfIslands().numIslands( new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
                    { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } } ) );
    }
}
