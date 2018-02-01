package Zappos;

public class BermudaTriangle
{
    public int check( int x1, int y1, int x2, int y2, int x3, int y3, int px, int py, int bx, int by ) {
        
        if( !isTriangle( x1, y1, x2, y2, x3, y3) ) return 0;
        
        boolean plane = isPointInTriangle( px, py, x1, y1, x2, y2, x3, y3 );
        boolean boat = isPointInTriangle( bx, by, x1, y1, x2, y2, x3, y3 );
        
        if( plane&&boat) return 3;
        else if( plane ) return 1;
        else if( boat) return 2;
        else return 4;
    }
    
    public boolean isTriangle( int x1, int y1, int x2, int y2, int x3, int y3 ) {
        
        int[] vector1 = new int[] {x2-x1, y2-y1};
        int[] vector2 = new int[] {x3-x1, y3-y1};
        
        
        if( vector1[0]*vector2[1]-vector1[1]*vector2[0]==0) return false;
        else return true;
    }
    
    public boolean isPointInTriangle( int x, int y, int x1, int y1, int x2, int y2, int x3, int y3 ) {
        
        int triangleArea = Math.abs( (x2-x1)*(y3-y1)-(y2-y1)*(x3-x1))/2;
        
        int trangleArea1 = Math.abs( (x1-x)*(y2-y)-(x2-x)*(y1-y) ) /2;
        int trangleArea2 = Math.abs( (x2-x)*(y3-y)-(x3-x)*(y2-y) ) /2;
        int trangleArea3 = Math.abs( (x3-x)*(y1-y)-(x1-x)*(y3-y) ) /2;
        
        return triangleArea == ( trangleArea1 + trangleArea2 + trangleArea3 );
    }
    
    public static void main( String[] args ) {
        System.out.println(  new BermudaTriangle().check( 3, 1, 7, 1, 5, 5, 1, 1, 2, 2 ) );
    }
}
