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
        
        if( n ==0 ) return 0;
        
        Map<Character, char[] > map = new HashMap< Character, char[] >();
        map.put( 'a', new char[] {'e'} );
        map.put( 'e', new char[] {'a','i'} );
        map.put( 'i', new char[] {'a','e','o'} );
        map.put( 'o', new char[] {'i','u'} );
        map.put( 'u', new char[] {'a'} );
        
        Queue<Character> queue = new LinkedList<Character>();
        queue.add( 'a' );
        queue.add( 'e' );
        queue.add( 'i' );
        queue.add( 'o' );
        queue.add( 'u' );
        
        for( int i=1; i < n; i++ ) {
            
            int length = queue.size();
            for( int j=0; j < length; j++ ) {
                char c = queue.poll();
                for( Character ch : map.get( c ) ) {
                    queue.add( ch );
                }
            }
            
        }
        
        return queue.size();
    }
    
    public int countString2( int n ) {
        
        if( n ==0 ) return 0;
        
        Map<Character, char[] > map = new HashMap< Character, char[] >();
        map.put( 'a', new char[] {'e'} );
        map.put( 'e', new char[] {'a','i'} );
        map.put( 'i', new char[] {'a','e','o'} );
        map.put( 'o', new char[] {'i','u'} );
        map.put( 'u', new char[] {'a'} );
        
        Map<Character, Integer > count = new HashMap<Character, Integer >();
        count.put( 'a',1 );
        count.put( 'e',1 );
        count.put( 'i',1 );
        count.put( 'o',1 );
        count.put( 'u',1 );
        
        for( int i=1; i < n; i++ ) {
            
            int[] lettersCount = new int[26];
            
            for( Character c : count.keySet() ) {
                int times = count.get( c );
                for( Character ch : map.get( c )) {
                    lettersCount[ch-'a'] += times;
                }
            }
            
            for( Character c : count.keySet() ) {
                count.put( c, lettersCount[c-'a'] );
            }
            
        }
        
        int res = 0;
        for( Character c : count.keySet() ) {
            res += count.get( c );
        }
        return res;
    }
    
    public static void main( String[] args ) {
        long a = System.currentTimeMillis();
        System.out.println( new MagicalString().countString(20) );
        System.out.println( System.currentTimeMillis() - a );
        
        long b = System.currentTimeMillis();
        System.out.println( new MagicalString().countString2(20) );
        System.out.println( System.currentTimeMillis() - b );
    }
}
