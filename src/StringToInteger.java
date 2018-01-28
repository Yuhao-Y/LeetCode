
public class StringToInteger
{
 public int myAtoi(String str) {
        
        if( str==null || str.length()<=0) return 0;
        
        //1. remove the space
        str = str.trim();
        char[] charArray = str.toCharArray();
        int start = 0, sign=1,result = 0;
        
        //2. check the sign
        if(charArray[start]=='-'||charArray[start]=='+') sign = charArray[start++]=='-'?-1:1;
           
        //3. convert
        while(start<charArray.length&&(charArray[start]>='0'&&charArray[start]<='9')){
            int num = charArray[start]-'0';
            //4. check whether the result will overflow
            //the judging condition will return false even the result is equal to MAX_VALUE. This is because the absolute of MIN_VALUE is larger 1 than MAX_VALUE
            if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10)) 
                return sign>0?Integer.MAX_VALUE:Integer.MIN_VALUE; 
            result = result*10+num;
            start++;
        }
        return  result*sign;
        
    }
}
