package DrawBriage;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Jungle Book,输入是一个list,index代表pray,value代表predator,value = -1 代表没有predator,就是说list = <n个有向edge, 
 * n个node的tree(forest),题里说输入满足不成环,一个species只有一个predator。
 * 问把这些动物最少分成几组，使组内成员不互相伤害(A->B->C的话A,C也不能一组)
 */
public class JungleBook
{
    public int divide( int[] book ) {
        
        int max = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for( int i=0; i < book.length ; i++ ) {
            max = Math.max( max, helper( book, i, map, 1 ) );
        }
        
        return max;
    }
    
    private int helper( int[] book, int index, Map<Integer, Integer> map, int level ) {
        
        if( book[index]== -1) return level;
        
        if( map.containsKey( index ) ) {
            return level+1;
        }else {
            int value =  helper( book, book[index], map, level+1);
            map.put( index, value - level + 1 );
            return value;
        }
        
    }
    
    public static void main( String[] args ) {
        System.out.println( new JungleBook().divide( new int[] {1,-1,3,-1,0} ) );
    }
}
