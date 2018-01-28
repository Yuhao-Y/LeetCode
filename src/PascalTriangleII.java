import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII
{
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        
        for( int i =0; i<rowIndex; i++ ){
            int length = res.size();
            res.add(0, 1 );
            for( int j=1; j<length; j++ ){
                res.set( j, res.get(j)+res.get(j+1) );
            }
        }
        
        return res;
        
    }
    
    public List<Integer> getRow2(int rowIndex) {    // number = previous*(level+1-index)/index
        
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        long previous = 1;
        for( int i = 1; i<=rowIndex; i++ ){
            
            long num = previous*( rowIndex+1-i)/i ;
            res.add( (int)num );
            previous = num;
            
        }
        
        return res;
        
    }
}
