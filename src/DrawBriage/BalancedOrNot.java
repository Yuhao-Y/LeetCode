package DrawBriage;

import java.util.Stack;

//就是一堆"<<>>><"这种字符串， 和一个最大的替代次数， 看能不能平衡。 不过水的地方在于如果有多的">"， 只能用"<>"替代， 而不是删掉。 多的"<"就没办法了， 返回不能平衡就行了
public class BalancedOrNot
{
    public boolean balance( String str, int n ) {
        
        if( n == 0 ) return false;
        
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        
        for( int i=0; i < str.length() ; i++ ) {
            if( str.charAt( i ) == '<') {
                stack.add( '<' );
            }else if( str.charAt( i ) == '>' ) {
                if( stack.isEmpty() ) {
                    count++;
                }else {
                    stack.pop();
                }
            }
        }
        
        if( stack.size()!=0 ) return false;
        
        return n>=count;
    }
    
    public static void main( String[] args ) {
        System.out.println(  new BalancedOrNot().balance( ">>>><<", 4 ) );
    }
}
