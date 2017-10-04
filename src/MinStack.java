
public class MinStack
{
    /** initialize your data structure here. */
    private int[] stack;;
    private int top = 0;
    private int[] smallestStack;
    
    public MinStack() {
        stack = new int[100];
        smallestStack = new int[100];
    }
    
    public void push(int x) {
       
        top++;
        if(top>=stack.length){
            int[] temp = new int[stack.length+100];
            System.arraycopy(stack,0,temp,0,stack.length);
            stack = temp;
            
            temp = new int[smallestStack.length+100];
            System.arraycopy(smallestStack,0,temp,0,smallestStack.length);
            smallestStack = temp;
        }
        
        stack[top] = x;
        if(top==1){
            smallestStack[1] = x;
        }else{
            smallestStack[top]= Math.min(smallestStack[top-1],x);
        }
        
    }
    
    public void pop() {
        stack[top--] = 0;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return smallestStack[top];
    }
}
