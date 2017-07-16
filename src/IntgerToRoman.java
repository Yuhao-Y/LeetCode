
public class IntgerToRoman
{
    String[] romanNumber = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    int[] intgerNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9,5,4,1};
    
    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        
        if(num<1||num>3999){
            return null;
        }
        
        int i=0;
        while(num>0){
            while(num>=intgerNum[i]){
                num = num - intgerNum[i];
                roman.append(romanNumber[i]);
            }
            i++;
        }
        
        return roman.toString();
    }
    
    public static void main(String[] args){
        IntgerToRoman i = new IntgerToRoman();
        System.out.print( i.intToRoman(199));
    }
}
