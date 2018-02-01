import java.util.Stack;

public class BasicCalculator
{
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int res = 0;
        int sign = 1;
        char[] exp = s.toCharArray();
        for( int i=0; i < exp.length; i++ ){
            
            if( exp[i]>='0' && exp[i]<='9' ){
                
                 int num = 0;
                while( i<exp.length && exp[i]>='0' && exp[i]<='9'){
                    num = num*10+(exp[i] - '0');  
                    i++;
                } 
                res = res+sign*num;
                i--;
                
            }else if( exp[i]=='+' ){
                
                sign = 1;
                
            }else if( exp[i]=='-' ){
                
                sign = -1;
                
            }else if( exp[i]=='('){
                
                stack.push( res );
                stack.push( sign );
                res= 0;
                sign = 1;
                
            }else if( exp[i]==')'){
                res = res*stack.pop()+stack.pop();
            }
            
        }
        
        return res;
    }
}
