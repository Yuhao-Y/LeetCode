
public class ComplexNumberMultipication
{
    public String complexNumberMultiply(String a, String b) {
        
        int[] count = new int[2];
        
        String[] aArray = a.split("\\+");
        String[] bArray = b.split("\\+");
        
        int realA = Integer.valueOf( aArray[0] );
        int imgA = Integer.valueOf( aArray[1].substring( 0, aArray[1].length()-1 ) );
        int realB = Integer.valueOf(bArray[0]);
        int imgB = Integer.valueOf( bArray[1].substring(0, bArray[1].length()-1 ) );
        
        count[0] = realA*realB+(-1)*imgA*imgB;
        count[1] = realA*imgB+realB*imgA;
        
        return count[0]+"+"+count[1]+"i";
        
    }
}
