
public class RomanToIntger
{
    String[] roman = {"CM","CD","XC","XL","IX", "IV"};
    int[] num = {900,400,90,40,9,4};
    
    public int romanToInt(String s) {
        int integer = 0;
        int j=0;
        
        while(s.length()>0){
            boolean isFinish = false;
            for(int i=j;i<roman.length;i++){
                if(s.startsWith( roman[i] )){
                    integer = integer+num[i];
                    s = s.substring( 2 );
                    isFinish = true;
                    j++;
                    break;
                }
            }
            
            if(s.length()>0&&isFinish == false){
                integer = integer+ convert(s.substring( 0, 1 ));
                s = s.substring( 1 );
            }
            
            
        }
        
        return integer;
    }
    
    private int convert(String s){
        switch(s){
            case "I": return 1;
            case "V": return 5;
            case "X": return 10;
            case "L": return 50;
            case "C": return 100;
            case "D": return 500;
            case "M": return 1000;
            default:return 0;
        }
    }
    
    public static void main( String[] args){
        RomanToIntger r = new RomanToIntger();
        System.out.print(r.romanToInt( "MMMDLXXXVI" )) ;
        
    }
}
