import java.util.Scanner;

public class MapMine
{
    public boolean findPath( int m, int n, char[][] map){
        
        if( m == 0 || n == 0 || map ==null ) return false;
        
        int startX=-1, startY=-1, endX=-1, endY=-1;
        
        for( int i =0; i <map.length ; i ++ ){
            
            for( int j = 0; j <map[0].length ; j++){
                
                if(map[i][j]=='A'){
                    startX = i;
                    startY = j;
                }
                
                if(map[i][j]=='B'){
                    endX = i;
                    endY = j;
                }
                
            }
            
        }
        
        if( startX == -1  || endX == -1  ) return false;
        
        return helper( startX, startY, endX, endY, map );
        
    }
    
    public boolean helper(int startX, int startY, int endX, int endY, char[][] map ){
        
        if( startX == endX && startY == endY ) return true;
        if( map[startX][startY] == 'V' ) return false;
        
        boolean[][] state = new boolean[3][3];
        map[startX][startY] = 'V';
        int x = startX-1, y = startY - 1;
        for( int i = Math.max(0, startX-1); i<= Math.min(map.length-1, startX+1); i++ ){
            for( int j = Math.max(0, startY-1); j <= Math.min(map[0].length-1, startY+1); j++){
                if( map[i][j] == '#' || map[i][j] == 'A' || map[i][j] == 'B') 
                    state[i - x][ j - y] = true;
            }
        }
        
        //move up
        if( state[0][0] &&state[0][1] && state[0][2] && helper( startX-1,startY, endX, endY, map) ) return true;
        
        //move right up
        if( state[0][1] && state[0][2] && state[1][2] && helper( startX-1, startY+1, endX, endY, map ) ) return true;
        
        //move right
        if( state[0][2] && state[1][2] && state[2][2] && helper( startX, startY+1, endX, endY, map ) ) return true;
        
        //move right down
        if( state[1][2] && state[2][2] && state[2][1] && helper( startX+1, startY+1, endX, endY, map ) ) return true;
        
        //move down
        if( state[2][0] && state[2][1] && state[2][1] && helper( startX+1, startY, endX, endY, map ) ) return true;
    
        //move left down
        if( state[1][0] && state[2][0] && state[2][1] && helper( startX+1, startY-1, endX, endY, map ) ) return true;
        
        //move left
        if( state[0][0] && state[1][0] && state[2][0] && helper( startX, startY-1, endX, endY, map ) ) return true;
    
        //move left up
        if( state[0][1] && state[0][0] && state[1][0] && helper( startX-1, startY-1, endX, endY, map ) ) return true;
    
        return false;
    }

    public static void main( String[] args ){
        
        Scanner cin = new Scanner( System.in );
        int m, n;
       
        m = cin.nextInt();
        n = cin.nextInt();
        
        char[][] map = new char[m][n];
        
        String s = cin.nextLine();
        for( int i=0 ; i<m; i++ ){
            s = cin.nextLine();
            map[i] = s.toCharArray();
            
        }
        
        System.out.println( new MapMine().findPath( m , n , map ) );
    }
}
