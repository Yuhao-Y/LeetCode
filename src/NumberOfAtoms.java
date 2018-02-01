import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NumberOfAtoms
{
public String countOfAtoms(String formula) {
        
        if( formula == null || formula.length()==0 ) return formula;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        Stack<Character> stack = new Stack<Character>();
            
        for( int i =0 ; i<formula.length(); i++ ){
            
            stack.push( formula.charAt( i ) );
            
        }
        
        helper( map, stack, formula, 1);
        
        StringBuilder sb = new StringBuilder();
        
        List<String> list = new ArrayList<String>(map.keySet() );
        Collections.sort(list);
        
        for( String str : list ){
            
            sb.append( str);
            if( map.get(str)!=1 )
                sb.append( map.get(str) );
            
        }
        
        return sb.toString();
    }
    
    private void helper( Map<String, Integer> map,Stack<Character> stack,  String formula, int times ){
        
       char c = 'a'; 
        while(!stack.isEmpty() && c!='('){
            c = stack.pop();
            
            if( c>='0' && c<='9' ){
                
                StringBuilder count = new StringBuilder();
                
                while( !stack.isEmpty() && c>='0' && c<='9' ){
                    count.insert(0,c);
                    c = stack.pop();
                }
                
                int totalCount = Integer.valueOf( count.toString() )*times;
                
                
                if( c==')'){
                    helper( map, stack, formula, totalCount );
                }
                else{
                    
                    StringBuilder sb = new StringBuilder();
                    while( c>='a'&&c<='z' ){
                    
                        sb.append( c );
                        c = stack.pop();    
                    }
                    sb.insert(0, c );
                    
                    map.put( sb.toString(), map.getOrDefault( sb.toString() ,0)+totalCount );
                }
               
               
            }else if( (c>='A' && c<='Z') || ( c>='a' && c<='z' )){
                
                StringBuilder sb = new StringBuilder();
                
                while( c>='a'&&c<='z' ){
                    
                    sb.append( c );
                    c = stack.pop();    
                }
                
                sb.insert(0, c );
                map.put( sb.toString(), map.getOrDefault( sb.toString() ,0)+times );
            }
        

            
        }
        
    }
}
