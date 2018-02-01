
public class MultiplyStrings
{
    public String multiply(String num1, String num2) {
        
        if( num1.equals("0")|| num2.equals("0")) return "0";
        
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        
        int[] result = new int[num1.length()+num2.length()]; //the last index of result is num1.length()+num2.length()-1
        
        
        for( int i = num1Array.length-1; i>=0; i--){
            for( int j = num2Array.length-1; j>=0; j--){
                result[i+j+1] = result[i+j+1] + (num1Array[i]-'0')*(num2Array[j]-'0');
            }
        }
        
        String product = "";
        for( int i= result.length-1, carray=0; i>=0;i--){   // carray at one loop will make code simple to write
            int sum = result[i]+ carray;
            result[i]=sum%10;
            carray = sum/10;
            product = String.valueOf(result[i]) + product;
        }
        
        return product.charAt(0)=='0'?product.substring(1, product.length()):product;
    }
}
