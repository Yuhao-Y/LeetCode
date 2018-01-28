
public class DecodeWays
{
    public int numDecodings(String s) {
        
        if( s==null || s.length()<=0 ) return 0; 
        
        int[] dp = new int[s.length() + 1];
        
        int prePre = 1; 
        int pre = (s.charAt(0)=='0')?0:1;
        
        for( int i=2; i <dp.length;i++){
            int cur = 0;
            if( s.charAt(i-1)>'0' && s.charAt(i-1)<='9') cur += pre;    //if cur is 0, cannot be decode
            
            int sum = ( s.charAt(i-2)-'0')*10+ (s.charAt(i-1)-'0'); //if the combination is less than 10 or large than 26, also cannot be decode
            
            if( sum>=10 && sum<=26 ) cur += prePre;
            
        
            prePre = pre;
            pre = cur;
            
            
        }
        
        return pre;
    }
}
