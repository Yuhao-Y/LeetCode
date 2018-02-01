package DrawBriage;

//求一个数能被多少个连续的数的和表示，比如10 -> 1+2+3+4 ，不需要打印，只需要求个数
public class SumOfContinuousNumber
{
    public int continuousNumber( long num ) {
        
        if( num < 3 ) return 0;
        
        int count = 0;
        
        for( int i=1; i<= num/2; i++ ) {
            
            if( num % i == 0 && (num/i & 1) == 1 && (i-num/i + 1)>0 ) count++;  // if i is the mid of the odd continuous numbers
            
            if( num % ( i + i+1) == 0 && (i-num/( i + i+1 ) + 1)>0 ) count++; // if i is the first mid of the even continuous numbers
        }

        return count;
    }
    
    public static void main( String[] args ) {
        System.out.println(  new SumOfContinuousNumber().continuousNumber( 9 ) );
    }
}
