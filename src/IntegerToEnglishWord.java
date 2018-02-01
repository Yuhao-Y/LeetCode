
public class IntegerToEnglishWord
{
    String[] unit = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    String[] decade = new String[]{"Zero","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] quantity = new String[]{"", " Thousand", " Million", " Billion"};
    String[] e = new String[]{"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    public String numberToWords(int num) {
        
        if(num==0) return "Zero";
        
        String res = "";
        return helper( num, res, 0).trim();
        
    }
    
    public String helper( int num, String res, int index ){

        if( num == 0 ) return res;
        
        int remainder = num%1000;
        
        if( remainder>0 )
            res = helperHundred( remainder, "") + quantity[index] + " " + res;
        
        return helper( num/1000, res, index+1);
    }
    
    public String helperHundred( int num, String res){
        
        int h = num/100;
        int du = num%100;
        int d = du/10;
        int u = du%10;
        
        if( h !=0 ){
            res = res + unit[h]+" Hundred";
        }
        
        if( du>10 && du<20){
            res = res +" "+ e[du-11];
        }else{
            if( d != 0 ) {
                res = res +" "+ decade[d];
            }
            if( u != 0){
                res = res +" "+ unit[u];
            }
        }
        
        return res.trim();
        
    }
}
