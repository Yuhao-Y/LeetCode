
public class MinimumWindowSubstring
{
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        char[] sChar = s.toCharArray(); // convert the string to array to improve the efficiency 
        char[] tChar = t.toCharArray(); 
        int[] count = new int[100]; //use array to instead of map when construct dictionary
        
        for( int i=0;i<t.length();i++){
            count[tChar[i]-'A']++;
        }
        
        for( int i=0;i<t.length();i++){
            if(count[tChar[i]-'A']==0)
                count[tChar[i]-'A'] = Integer.MAX_VALUE;
        }
        
        int lo=0, hi = 0, degree = t.length();
        int start=0, end = Integer.MAX_VALUE; // use star and end to record the minimum substring now
        for(;hi<s.length();hi++){
            if(count[sChar[hi]-'A']<Integer.MAX_VALUE){
                int hiIndex = sChar[hi]-'A';
                if(count[hiIndex]>0) degree--;
                
                count[hiIndex]--;
                
                while(degree==0&&lo<=hi){
                    if((end-start)>(hi-lo)){
                        end = hi;
                        start = lo;
                    }
                   
                    int loIndex = sChar[lo]-'A';
                    if(count[loIndex]<Integer.MAX_VALUE){
                        count[loIndex]++;
                        if( count[loIndex]>0) degree++;    
                    }
                    lo++;
                    
                }
                
            }
        }
        
        if((end-start)>s.length()) return "";
        return s.substring(start,end+1);
    }
    
    public static void main( String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow( "bbaa", "aba" ));
    }
}
