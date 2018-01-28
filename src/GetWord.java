import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GetWord
{
    public boolean isConstruct( String word, String[]buckets ){
        
        int[] wordCount = new int[26];
        for( int i = 0 ; i<word.length() ; i++ ){
            wordCount[ word.charAt(i) - 'a' ]++;
        }
        
        List<String> res = new ArrayList<String>();
        
        helper( res, buckets, 0, new int[26] );
        
        return res.contains( Arrays.toString( wordCount) );
    }
    
    public void helper( List<String> result, String[] buckets, int index, int[] count ){
        
        if( index == buckets.length ){
            
            result.add( Arrays.toString( count ) );
            return;
            
        }
        
        result.add( Arrays.toString( count ) );
        
        helper( result, buckets, index+1, count);
        
        for( int i = 0; i<buckets[index].length(); i++ ){
          
            count[ buckets[index].charAt(i) - 'a' ]++;
            
            helper( result, buckets, index+1, count);
            
            count[ buckets[index].charAt(i) - 'a' ]--;
        }
        
    }
    
    public static void main( String[] args ){
        
        Scanner cin = new Scanner( System.in );
        
        int bucketsNum = cin.nextInt();
        
        String word = cin.next();
        
        String[] buckets = new String[ bucketsNum ];
        for( int i = 0; i < bucketsNum; i++){
            buckets[i] = cin.next();
        }
        
        System.out.println( new GetWord().isConstruct( word,buckets ) );
        
    }
}
