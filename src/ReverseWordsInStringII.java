
public class ReverseWordsInStringII
{
    public String reverseWords( String string) {
        
        if( string==null||string.length()<=0) return string;
        
        char[] array = string.toCharArray();
        reverse( array, 0, array.length-1);
        
        int start = 0, end = 0;
        while(end<array.length) {
            while(end<array.length&&array[end]!=' ') {
                end++;
            }
            reverse( array, start, end-1);
            start = end+1;
            end++;
        }
       
        return String.valueOf( array );
    }
    
    public void reverse( char[] string, int start, int end) {
        while(start<end) {
            char tmp = string[start];
            string[start] = string[end];
            string[end] = tmp;
            start++;end--;
        }
    }
    
    public String reverseWordInString2( String str ) {
        
        if( str == null || str.length()==0 ) return str;
        
        char[] arr = str.toCharArray();
        
        int left = 0, right = 0;
        
        while( right<arr.length ) {
            
            while( right<arr.length && arr[right] == ' ') right++;
            left = right;
            while( right<arr.length && arr[right] != ' ' ) right++;
            reverse( arr, left, right-1);
            
        }
        
        reverse( arr, 0, right-1);
        
        return String.valueOf( arr ).trim();
    }
    
    public static void main( String[] args ) {
        
        System.out.println(  new ReverseWordsInStringII().reverseWordInString2("   hello      world   for java  ") );
        
    }
}
