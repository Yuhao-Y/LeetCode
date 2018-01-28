import java.util.LinkedList;

public class BaseballGame
{
    public int calPoints(String[] ops) {
        if(ops==null||ops.length<=0) return 0;
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        int result = 0;
        
        for( String op: ops){
            if(op.equals("+")){
                if(list.size()<2) return 0;
                int val = list.get(0)+list.get(1);
                result+= val;
                list.push(val);
            }else if( op.equals("C")){
                result -= list.pop();
            }else if( op.equals("D")){
                int val = list.peek()*2;
                result+= val;
                list.push(val);
            }else{
                int val = Integer.valueOf(op);
                result+=val;
                list.push(val);
            }
        }
        
        return result;
        
    }
}
