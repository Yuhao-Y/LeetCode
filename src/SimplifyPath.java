import java.util.Stack;

public class SimplifyPath
{
    public String simplifyPath(String path) {
        //time O(N) space O(N)
        if (path == null || path.length() == 0) return "";
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/+");//mutiple "/"
        //. means the current path
        //.. means the father path
        for (String s : str){
            //if( s.equals("..") && !stack.isEmpty() ){
            if( s.equals("..")) {
                if(!stack.isEmpty() ){
            }
                    stack.pop();
            }else if (!s.equals(".") && !s.equals("")){
                stack.push(s);
            }
        }
        //visite the stack, get the ans 
        String res = "";
        while(!stack.isEmpty()){
            res = "/"+ stack.pop()+res;
        }
        if(res.length() == 0){
            return "/";
        }
        return res;
    }
    
    public static void main( String[] args) {
        System.out.println( new SimplifyPath().simplifyPath( "/..") );
    }
}
