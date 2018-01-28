
public class Minesweeper
{
    public char[][] updateBoard(char[][] board, int[] click) {
        
        if( board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        
        recursive( board, click);
        
        return board;
    }
    
    public int recursive( char[][] board, int[] point){
       
        if(board[point[0]][point[1]]!='E') return 0;
        
        
        int count = 0;
        
        int startX = (point[0]-1)>0?(point[0]-1):0;
        int startY = (point[1]-1)>0?(point[1]-1):0;
        int endX = (point[0]+1)<board.length?(point[0]+1):(board.length-1);
        int endY = (point[1]+1)<board[0].length?(point[1]+1):(board[0].length-1);
        
        for( int x = startX;x<=endX;x++){
            for( int y = startY; y<=endY;y++ ) {
                if( board[x][y] == 'M' ) 
                    count += 1;
            }
        }
                                       
        if(count==0){
            board[point[0]][point[1]] = 'B';
           for( int x = startX;x<=endX;x++){
            for( int y = startY; y<=endY;y++ ) {
                    recursive(board, new int[]{x,y});
                }
            }
        }else{
            board[point[0]][point[1]] =(char)( count+'0' );
        }                            
        
        
        
        return 0;
    }
}
