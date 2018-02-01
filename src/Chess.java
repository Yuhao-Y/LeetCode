import java.util.LinkedList;
import java.util.Queue;

public class Chess
{
    public int chess( int[][] chess, int x1, int y1, int x2, int y2) {
        if( chess == null ) return 0;
        
        Queue<PointXY> queue = new LinkedList<>();
        queue.offer( new PointXY(x1, y1) );
        int count= 0 ;
        while( !queue.isEmpty()) {
            
            int length = queue.size();
            while( length>0 ) {
               PointXY PointXY = queue.poll();
               if( PointXY.x == x2 && PointXY.y == y2) return count;
               if( isValid( chess, PointXY.x-2, PointXY.y-1)) queue.offer( new PointXY(PointXY.x-2, PointXY.y-1) );
               if( isValid( chess, PointXY.x-2, PointXY.y+1)) queue.offer( new PointXY(PointXY.x-2, PointXY.y+1) );
               if( isValid( chess, PointXY.x+2, PointXY.y-1)) queue.offer( new PointXY(PointXY.x+2, PointXY.y-1) );
               if( isValid( chess, PointXY.x+2, PointXY.y+1)) queue.offer( new PointXY(PointXY.x+2, PointXY.y+1) );
               if( isValid( chess, PointXY.x-1, PointXY.y+2)) queue.offer( new PointXY(PointXY.x-1, PointXY.y+2) );
               if( isValid( chess, PointXY.x-1, PointXY.y-2)) queue.offer( new PointXY(PointXY.x-1, PointXY.y-2) );
               if( isValid( chess, PointXY.x+1, PointXY.y-2)) queue.offer( new PointXY(PointXY.x+1, PointXY.y-2) );
               if( isValid( chess, PointXY.x+1, PointXY.y+2)) queue.offer( new PointXY(PointXY.x+1, PointXY.y+2) );
               length--;
            }
            
            count++;
        }
        
        return count;
    }
    
    private boolean isValid( int[][] chess, int x,int y) {
        if( x>=0 && x<chess.length && y>=0 && y<chess[0].length && chess[x][y]!=-1) {
            chess[x][y] = -1;
            return true;
        }else {
            return false;
        }
    }
    
    public static void main( String[] args ) {
        int[][] chess = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(  new Chess().chess( chess, 0, 0, chess.length-1, chess[0].length-1 ) );
    }
}


class PointXY{
    int x; 
    int y;
    public PointXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
