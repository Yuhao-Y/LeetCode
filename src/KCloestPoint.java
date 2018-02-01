import java.util.Comparator;
import java.util.PriorityQueue;

public class KCloestPoint
{
    /*
     * @param points: a list of points
     * 
     * @param origin: a point
     * 
     * @param k: An integer
     * 
     * @return: the k closest points
     */
    public Point[] kClosest( Point[] points, Point origin, int k )
    {
        if(k<=0) return new Point[0];
        
        Point[] result = new Point[k];
        
        PriorityQueue<Point> pointQueue = new PriorityQueue<Point>( 3, new Comparator<Point>()
        {

            @Override
            public int compare( Point arg0, Point arg1 )
            {
                if(getDistance(arg0,origin)<getDistance(arg1,origin)){
                    return 1;
                }else if(getDistance(arg0,origin)==getDistance(arg1,origin)){
                    if( arg0.x < arg1.x )
                    {
                        return 1;
                    }
                    else if( arg0.x == arg1.x )
                    {
                        if( arg0.y < arg1.y )
                        {
                            return 1;
                        }
                        else
                        {
                            return -1;
                        }
                    }
                    else
                    {
                        return -1;
                    }
                }else{
                    return -1;
                }
            }
        } );

        for( Point point : points )
        {

            if( pointQueue.size() < k )
            {
                pointQueue.add( point );
            }else {
                Point peek = pointQueue.peek();
                 if(getDistance(point,origin)<getDistance(peek,origin)) {
                    pointQueue.poll();
                    pointQueue.add( point );
                }
            }
        }

        
        while(pointQueue.size()>0) {
            result[--k]=pointQueue.poll();
        }
        
        return result;
    }
    
    public int getDistance( Point a, Point b) {
        return Math.abs( a.x-b.x )*Math.abs( a.x-b.x )+Math.abs( a.y-b.y )*Math.abs( a.y-b.y );
    }
    
    public static void  main( String[] args) {
        Point b = new Point(4,7);
        Point c = new Point(4,4);
        Point d = new Point(2,5);
        Point a = new Point(4,6);
        Point[] points = new Point[] {a,b,c,d};
        for(Point point: new KCloestPoint().kClosest( points, new Point(0,0), 3 ) ) {
            System.out.println( point.x+" "+point.y );
        }
    }
}

class Point
{
    int x;
    int y;

    Point()
    {
        x = 0;
        y = 0;
    }

    Point(int a, int b)
    {
        x = a;
        y = b;
    }
    
    @Override
    public String toString() {
        return x+" "+y;
    }
}
