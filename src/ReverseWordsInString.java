
public class ReverseWordsInString
{
    public String reverseWords( String string) {
        
        char[] array = string.toCharArray();
        int start = array.length-1, end = 0;
        StringBuffer s = new StringBuffer();
        while(start>=0) {
            while(start>=0&&array[start]==' ') start--;
            end = start;
            while(start>=0&&array[start]!=' ') start--;
            s.append(String.valueOf( array, start+1, end-start)+" ");

        }
        
        return s.toString().trim();
    }
    
    public static void main( String[] args ) {
        System.out.println(  new ReverseWordsInString().reverseWords( "     a     b" ) );
    }
    
}
