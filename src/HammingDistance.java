
public class HammingDistance
{
    public int hammingDistance(int x, int y) {
        int resultNum = x^y;
        int result = 0;
        
        if(resultNum==0) return 0;
        while(resultNum!=1){
            if(resultNum%2==1) result++;
            resultNum = resultNum/2;
        }
        
        return ++result;
    }
}
