import java.util.*;

public class LetterComPhoneNum {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        
        if(digits.length()==0) return result;
        
        HashMap<Integer, String[]> map = new HashMap<Integer, String[]>();
        map.put(2,new String[]{"a","b","c"});
        map.put(3,new String[]{"d","e","f"});
        map.put(4,new String[]{"g","h","i"});
        map.put(5,new String[]{"j","k","l"});
        map.put(6,new String[]{"m","n","o"});
        map.put(7,new String[]{"p","q","r","s"});
        map.put(8,new String[]{"t","u","v"});
        map.put(9,new String[]{"w","x","y","z"});
        map.put(0,new String[]{" "});
        
        result.add("");
        for(char digital: digits.toCharArray()){
            int length = result.size();
            while(length-->0){
                String tmp = result.poll();
                for(String letter: map.get(digital-'0')){
                    result.add(tmp+letter);
                }
            }
            
        }
        
        return result;
    }
    
    public List<String> letterCombinationsDFS(String digits) {
        LinkedList<String> res = new LinkedList<String>();
        
        if( digits == null || digits.length()<=0 ) return res;
        
        String[] map = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        helper( digits, map, "", res, 0);
        
        return res; 
    }
    
    public void helper( String digits, String[] map, String str, LinkedList<String> res, int index){
        
        if( index == digits.length()) {
            res.add(str);
            return;
        }
        
        char[] letter = map[ digits.charAt( index ) - '0' ].toCharArray();
        
        for( int i=0; i<letter.length; i++){
            helper( digits, map, str+letter[i],res, index+1);
        }
        
    }

    public static void main(String[] args) {
        LetterComPhoneNum letter = new LetterComPhoneNum();
        List<String> arr = letter.letterCombinations("23");
        System.out.print(arr);
    }
}