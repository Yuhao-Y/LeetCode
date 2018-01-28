
public class ReadCharactersFromFile
{
    //use the queue to simulate buffer
    char[] buffer = new char[4];
    int head, count = 0; 
    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
    public int read(char[] buf, int n) {
        // Write your code here
        int index = 0;
        while( index < n){
            if( head == 0  ){
                count = read4( buffer );
            }
        
            if( head == count ){
                break;
            }
            
            while( index<n && head< count ){
                buf[index++] = buffer[head++];
            }
            
            if( head == count ) head = 0;
        
        }
        
        return index;
    }
    
    public int read4( char[] buf) {
        return 0;
    }
}
