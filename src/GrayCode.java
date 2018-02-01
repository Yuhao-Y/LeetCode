import java.util.ArrayList;
import java.util.List;

public class GrayCode
{
    public List<Integer> grayCode(int n) {
        if(n<0) return null;
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        //Example: the gray code length 2 is: 00,01,11,10
        //Then the gray code length 3 is: (0.(00,01,11,10))U(1.(10,11,01,00))
        for( int i=0;i<n;i++){
            int length = result.size();
            int tmp = 1<<i;
            for( ;length>0;length--){
                result.add(result.get(length-1)|tmp);
            }
        }
        
        return result;
    }
}