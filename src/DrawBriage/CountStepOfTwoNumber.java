package DrawBriage;

//第一个就是最小步数，123-->234  需要3步，其实就是计算每个位置对应的数字的差的和
public class CountStepOfTwoNumber
{
    public int count( int[] array1, int[] array2 ) {
        
        if( array1.length != array2.length ) return 0;
        
        int count = 0;
        
        for( int i=0; i < array1.length ; i++ ) {
            
            int num1 = array1[i];
            int num2 = array2[i];
            int num = 10;
            while( num1 != 0 ) {
                count += Math.abs( num1%num - num2%num );
                num1 /=num;
                num2 /=num;
            }
        }
        
        return count;
    }
    
    public static void main( String[] args ) {
        System.out.println(  new CountStepOfTwoNumber().count( new int[] {123}, new int[] {231} ) );
    }
}
