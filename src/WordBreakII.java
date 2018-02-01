import java.util.ArrayList;
import java.util.List;

public class WordBreakII
{
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> res = new ArrayList<String>();
        
        if( s==null || s.length()<=0 || wordDict.size()<=0 ) return res;
        
        List<Integer>[] dp = new ArrayList[ s.length()+1 ];
        dp[0] = new ArrayList<Integer>();
        dp[0].add( 0 );
        
        for( int i=0; i < dp.length; i++){
            for( int j = 0; j < i; j++ ){
                if( dp[ j ]!=null && wordDict.contains( s.substring( j , i) ) ){          
                    
                    if( dp[i] ==null ) dp[i] = new ArrayList<Integer>();
                    
                    dp[i].add( j );

                }
            }
            
        }
        
        helper( s, dp, dp.length-1, res, "");
        
        return res;
    }
    
    public void helper( String s, List<Integer>[] dp, int index, List<String> res, String str ){
        
        if( dp[index]== null )return;
        
        if(index==0 ) {
            str = str.trim();
            res.add( str );
            return;
        }
        
        for( Integer i: dp[index]){
            helper( s, dp, i, res, s.substring(i,index)+" "+str);
        }
        
    }
}
