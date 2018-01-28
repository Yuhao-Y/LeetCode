import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParentheses
{
    List<String> res = new ArrayList<String>();
    
    public List<String> removeInvalidParentheses(String s) {
        
        int[] invalidCount = isValidParenthese( s );
        HashSet<String> visited = new HashSet<String>();
        helper( s,invalidCount[0],invalidCount[1], 0, visited );
        
        return res;
    }
    
    public void helper( String s, int left, int right, int index, HashSet<String> visited){
        
        if( left==0&&right==0) {
            if( !res.contains(s)) res.add(s);
            return;
        }
        
        for( int i=index; i <s.length(); i++){
            if( s.charAt(i)=='('){
                String tmp = s.substring(0, i)+s.substring(i+1,s.length());
                if( visited.contains(tmp)) continue;
                visited.add(tmp);
                int[] count = isValidParenthese(tmp);
                if( (count[0]+ count[1]) <(left+right))
                    helper( tmp, left-1, right, i, visited);
            }
        }
        
        for( int i=index; i <s.length(); i++){
            if( s.charAt(i)==')'){
                String tmp = s.substring(0, i)+s.substring(i+1,s.length());
                if( visited.contains(tmp)) continue;
                visited.add(tmp);
                int[] count = isValidParenthese(tmp);
                if( (count[0]+ count[1])<(left+right))
                    helper( tmp, left, right-1, i, visited);
            }
        }
        
    }
    
    public int[] isValidParenthese( String s ){
        
        char[] sArray = s.toCharArray();
        
        int left = 0, right = 0;
        
        for( int i=0; i<sArray.length; i++){
            if( sArray[i]=='(' ){
                left++;
            }else if( sArray[i]==')'){
                if(left==0){
                    right++;
                }else{
                    left--;
                } 
            }
        }
        
        return new int[]{ left, right };
    }
}
