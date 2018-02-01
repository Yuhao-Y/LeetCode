package DrawBriage;

//第一个就是最小步数，123-->234  需要3步，其实就是计算每个位置对应的数字的差的和
public class CountStepOfTwoNumber
{
    public int count( int num1, int num2 ) {
        
        int count = 0;
        
        int num = 10;
        while( num1 != 0 ) {
            count += Math.abs( num1%num - num2%num );
            num1 /=num;
            num2 /=num;
        }
        
        return count;
    }
    
    public static void main( String[] args ) {
        System.out.println(  new CountStepOfTwoNumber().count( 123, 231 ) );
    }
}
