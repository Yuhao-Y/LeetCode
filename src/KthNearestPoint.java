import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthNearestPoint
{
    public Point[] nearestK(Point[] points,Point target, int k){
        List<Point> tmp = new ArrayList<Point>();
        PriorityQueue<Point> minHeap = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1,Point p2) {
                int dis1 = (target.x-p1.x)*(target.x-p1.x) + (target.y-p1.y)*(target.y-p1.y);
                int dis2 = (target.x-p2.x)*(target.x-p2.x) + (target.y-p2.y)*(target.y-p2.y);
                return dis2 - dis1;
            }
        });

//        for (Point p : points){
//            //if(minHeap.size() < k)
//            minHeap.offer(p);
//            if (minHeap.size() > k){
//                for (int i = 0; i < k; i++){
//                    tmp.add(minHeap.poll());
//                }
//            }
//        }
//        Point[] res = new Point[tmp.size()];
//        int i = 0;
//        for (Point p: tmp){
//            res[i++] = p;
//        }
        
        for( Point p : points) {
            
            minHeap.offer( p );
            if( minHeap.size() > k ) minHeap.poll();
            
        }
        
        Point[] res = new Point[minHeap.size()];
        int i=0;
        while( !minHeap.isEmpty() ) {
            res[i++] = minHeap.poll();
        }
        
        return res;
    }


    public static void main(String[] args) {
        KthNearestPoint s = new KthNearestPoint();

        System.out.println("priority queue approach:");
        for (Point p : s.nearestK(new Point[]{new Point(0,0),new Point(1,0),new Point(0,1),
                new Point(0,2),new Point(2,0),new Point(1,2),new Point(2,1)},
                new Point(3,0),5)){
            System.out.println(p.toString());
        }

    }
}
