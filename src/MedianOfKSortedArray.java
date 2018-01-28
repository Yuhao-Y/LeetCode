import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfKSortedArray
{
    public double getMedian( int[][] arrays ) {
        
        if( arrays == null ) return 0;
        
        double res = 0;
        
        PriorityQueue< ArrayContainer > pq = new PriorityQueue< ArrayContainer >( new Comparator<ArrayContainer>() {
            
            @Override
            public int compare( ArrayContainer a, ArrayContainer b ) {
                
                return  a.array[a.index] - b.array[b.index];
                
            }
            
        });
        
        int length = 0;
        for( int i = 0 ; i<arrays.length; i++ ) {
            length += arrays[i].length;
            pq.offer( new ArrayContainer(arrays[i]) );
        }
        
        int i=0;
        
        while( i<=( (length-1)/2) ) {
            ArrayContainer c = pq.poll();
            res = c.array[c.index];
            c.index++;
            
            if( c.index<c.array.length)
                pq.offer( c );
            
            i++;
        }
        
        if( (length&1)!=1 ) res = (res+ pq.peek().array[pq.peek().index])/2;
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1,4,7,9,10};
        int[] nums2 = {2,5,6,8,9};
        int[] nums3 = {2,3,4,9,12,25};

        System.out.println(new MedianOfKSortedArray().getMedian(new int[][]{nums1,nums2,nums3}));
    }
    
}

class ArrayContainer{
    
    int[] array;
    int index = 0;
    
    public ArrayContainer(int[] array) {
        
        this.array = array;
    }
    
}
