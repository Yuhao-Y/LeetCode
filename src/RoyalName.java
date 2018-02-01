import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RoyalName
{
    public String[] sortName( String[] names ) {
        
        if( names==null || names.length <= 0 ) return names;
        
        PriorityQueue<String> pq = new PriorityQueue<String>( new Comparator<String>() {
           
            @Override
            public int compare( String name1, String name2 ) {
                
                String[] str1 = name1.split( " " );
                String[] str2 = name2.split( " " );
                
                int res = str1[0].compareTo( str2[0] );
                
                if( res>0 ) {
                    return -1;
                }else if( res<0 ) {
                    return 1;
                }else {
                    int roman1 = convertRomanToInteger( str1[1] );
                    int roman2 = convertRomanToInteger( str2[1] );
                    return roman2-roman1;
                }
            }
            
        });
        
        for( int i=0; i < names.length; i++ ) {
            pq.offer(  names[i] );
        }
        
        for( int i=0; i < names.length; i++ ) {
            names[i] = pq.poll();
        }
        
        return names;
    }
    
    private int convertRomanToInteger( String roman ) {
        
        int sum = 0;
        if( roman.indexOf( "IV" )!=-1 ) sum = sum - 2;
        if( roman.indexOf( "IX" )!=-1 ) sum = sum - 2;
        if( roman.indexOf( "XL" )!=-1 ) sum = sum - 20;
        if( roman.indexOf( "XC" )!=-1 ) sum = sum - 20;
        if( roman.indexOf( "CD" )!=-1 ) sum = sum - 200;
        if( roman.indexOf( "CM" )!=-1 ) sum = sum - 200;
        
        for( int i=0; i < roman.length(); i++ ) {
            if(roman.charAt(i) == 'I') sum = sum+1;
            else if(roman.charAt(i) == 'V') sum = sum+5; 
            else if(roman.charAt(i) == 'X') sum = sum+10;
            else if(roman.charAt(i) == 'L') sum = sum+50;
            else if(roman.charAt(i) == 'C') sum = sum+100;
            else if(roman.charAt(i) == 'D') sum = sum+500;
            else if(roman.charAt(i) == 'M') sum = sum+1000;
        }
        
        return sum;
    }
    
    public static void main( String[] args ) {
        System.out.println(  Arrays.toString( new RoyalName().sortName( new String[] { "PILLIPS II", "PILLIPA I"} ) ) );
    }
}
