import java.util.ArrayList;
import java.util.List;

public class NumberOfDistanceIslands
{
    public int numDistinctIslands(int[][] grid) {
        
        if( grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        List<String> islandShape = new ArrayList<String>();
        
        for( int i=0; i<grid.length; i++) {
            for( int j = 0; j<grid[0].length; j++) {
                if( grid[i][j] == 1 ) {
                    String shape = helper( grid, i, j, 0, 0);
                    if( shape!=null && shape.length() > 0 ) {
                        if( !islandShape.contains( shape ))
                            islandShape.add( shape );
                    }
                }
            }
        }
        
        return islandShape.size();
    }
    
    private String helper( int[][] grid, int x, int y, int a, int b ) {
        
        if( x<0 || x>=grid.length || y<0 || y>=grid[0].length ) return "";
        if( grid[x][y] == 0|| grid[x][y] == -1 ) return "";
        
        String res = a+" "+b+" ";
        grid[x][y] = -1;
        res += helper( grid, x-1, y, a-1, b );
        res += helper( grid, x+1, y, a+1, b );
        res += helper( grid, x, y-1, a, b-1 );
        res += helper( grid, x, y+1, a, b+1 );
        //grid[x][y] = 1;
        return res;
    }
    
    public static void main( String[] args ) {
        
        int[][] ocean = new int[][] {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,0}
        };
        
        System.out.println(  new NumberOfDistanceIslands().numDistinctIslands( ocean ) );
    }
    
    
}
