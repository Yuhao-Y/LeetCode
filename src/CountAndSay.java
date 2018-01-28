import java.util.Arrays;

public class CountAndSay
{
    public String countAndSay( int n )
    {
        if( n <= 0 )
            return null;
        else if( n == 1 )
            return "1";

        return countSay( n, 2, "1" );
    }

    private String countSay( int n, int currentIndex, String count )
    {
        StringBuffer say = new StringBuffer();
        char[] countArray = count.toCharArray();

        char currentChar = countArray[0];
        int repeatTimes = 0;
        // check if the char[i] is different with the last i in every loop. And set the end state as i<= to avoid not process the last digital.
        for( int i = 0; i <= countArray.length; i++ )
        {
            if( i == countArray.length || countArray[i] != currentChar )
            {
                say.append( String.valueOf( repeatTimes )+ currentChar);
                currentChar = (i == countArray.length)?currentChar:countArray[i];
                repeatTimes = 1;
            }
            else
            {
                repeatTimes++;
            }
        }

        if( n == currentIndex )
        {
            return say.toString();
        }
        else
        {
            return countSay( n, ++currentIndex, say.toString() );
        }
    }
    
public String countAndSay2(int n) {
        
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        char[] numArray;
        
        
        while(n-->1){
            numArray = sb.toString().toCharArray();
            sb = new StringBuffer();
            int count=0;
            char last = numArray[0];
            for( int i=0; i< numArray.length;i++){
                if(numArray[i]==last) count++;
                else{
                    sb.append(String.valueOf(count)+(last-'0'));
                    count = 1;
                    last = numArray[i];
                }
            }
           sb.append(String.valueOf(count)+(last-'0'));
        }
        
        return sb.toString();
    }

    public static void main( String[] args )
    {
        System.out.println( new CountAndSay().countAndSay( 5 ) );
    }
}
