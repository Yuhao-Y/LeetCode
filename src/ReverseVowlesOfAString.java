import java.util.LinkedList;

public class ReverseVowlesOfAString
{
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        LinkedList<Integer> list = new LinkedList<Integer>();
        char[] charArray = s.toCharArray();
        for( int i=0;i<s.length();i++ ){
            if(vowel.indexOf(charArray[i])>=0) list.add(i); 
        }
        
        while(list.size()>1){
            int left = list.pollFirst();
            int right = list.pollLast();
            char tmp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = tmp;
        }
        
        return String.valueOf(charArray);
        
    }
    
    public String reverseVowelsTwoPointer(String s) {
        String vowel = "aeiouAEIOU";
        char[] charArray = s.toCharArray();
        
        int left = 0, right = charArray.length-1;
        while(left<right){
            if(vowel.indexOf(charArray[left])<0){
                left++;
            }else{
                while(left<right&&vowel.indexOf(charArray[right])<0){
                    right--;
                }
                     if(left<right){
                        char tmp = charArray[left];
                        charArray[left] = charArray[right];
                        charArray[right] = tmp;
                        left++;right--;
                    }
               
            }    
        }
        
        return String.valueOf(charArray);
        
    }
    
    public static void main(String[] args) {
        LinkedList<Character> queue = new LinkedList<Character>();
        
        queue.add( 'a' );
        queue.add( 'b' );
        queue.add( 'c' );
        queue.add( 'd' );
        queue.add( 'e' );
        LinkedList<Character> stack = new LinkedList<Character>();
        stack.push( 'a' );
        stack.push( 'b' );
        stack.push( 'c' );
        stack.push( 'd' );
        stack.push( 'e' );
        //queue.poll();
        //stack.pop();
        System.out.println( queue );
        System.out.println( stack );
    }
}
