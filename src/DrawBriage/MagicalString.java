package DrawBriage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
规则是一个字符串只能由 a, e, i, o, u 中的字符组成，每个字符都可以用任意次，但是必须满足规则：
a后面只能跟e
e后面只能跟a或i
i后面可以跟a, e, o, u中任一
o后面只能跟i或u
u后面只能跟a
题目输入是一个数字n，求满足以上规则且长度为n的字符串一共有多少个，输出个数对于1000000007的模。
 */
public class MagicalString
{
    public int countString( int n ) {
        
        if( n <= 0 ) return 0;
        
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        
        for( int j=1; j < n; j++) {
            long aTemp = e + a + u;
            long eTemp = a + i;
            long iTemp = e + o;
            long oTemp = i;
            long uTemp = i + o;
            
            a = aTemp%1000000007;
            e = eTemp%1000000007;
            i = iTemp%1000000007;
            o = oTemp%1000000007;
            u = uTemp%1000000007;
        }
        
        return (int)( ( a+e+i+o+u) % 1000000007 );
    }
    
    public static void main( String[] args ) {
        long a = System.currentTimeMillis();
        System.out.println( new MagicalString().countString(1000) );
        System.out.println( System.currentTimeMillis() - a );
    }
}
