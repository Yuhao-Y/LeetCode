import java.util.ArrayList;
import java.util.List;

public class PascalTriangleI
{
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(numRows<=0) return result;
        
        List<Integer> firstList = new ArrayList<Integer>();
        firstList.add(1);
        result.add(firstList);
        
        for(int i=1;i<numRows;i++){
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            for( int j=1;j<i;j++){
                list.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            list.add(1);
            result.add(list);
        }
        
        return result;
    }
}
