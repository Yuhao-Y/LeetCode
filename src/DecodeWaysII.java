
public class DecodeWaysII
{
    public int numDecodings(String s) {
        
        if( s==null || s.length()<=0 ) return 0;
        
        long prePre = 1;
        long pre = s.charAt(0)=='0'?0:(s.charAt(0)=='*'?9:1);
        
        for( int i=2; i<( s.length() + 1 ); i++){
            long cur = 0;
            if( s.charAt(i-1)>'0' && s.charAt(i-1)<='9') cur = pre;
            else if( s.charAt(i-1)=='*') cur = 9*pre;
            
            if( s.charAt(i-2) != '0' ){
                if( s.charAt(i-2)!='*'){
                    long sum = 0;
                    if( s.charAt( i-1 ) !='*'){
                        sum = ( s.charAt( i-2 ) - '0')*10 + ( s.charAt( i-1 ) - '0');
                        if( sum>=10 && sum<=26 )
                            cur += prePre;
                    }
                    else{
                        if( ( s.charAt( i-2 ) - '0') == 1 )  cur += prePre*9;
                        else if( ( s.charAt( i-2 ) - '0') == 2 ) cur += prePre*6;
                    }
                    
                }else{
                
                    if( s.charAt( i-1 ) !='*'){
                    
                        if(  ( s.charAt( i-1 ) - '0')<=6 ) cur += prePre*2;
                        else cur += prePre;
                    }
                    else{
                        cur += 15*prePre;
                    }
                }
            }
            
            prePre = pre%1000000007;
            pre = (cur%1000000007);
            
        }
        
        
        return (int)pre%1000000007;
    }
}
