import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ModifyPirce
{
    public int findModifyPirces( String[] orgItem, float[] orgPirce, String[] sellItem, float[] sellPrice ) {
        
        int count = 0;
        HashMap<String, Float> map = new HashMap<String, Float>();
        
        for( int i=0; i < orgItem.length; i++ ) {
            map.put( orgItem[i], orgPirce[i] );
        }
        
        for( int i=0; i < sellItem.length; i++ ) {
            if( map.getOrDefault( sellItem[i], -0.01f )!=sellPrice[i] ) {
                count++;
            }
        }
        
        
        
        return count;
    }
    
    public static void main( String[] args ) {
        String[] orgItem = new String[] {"rice","sugar","wheat", "cheese"};
        String[] sellItem = new String[] {"rice","cheese","wheata"};
        float[] orgPrice = new float[] {16.89f,56.92f,20.89f,345.99f};
        float[] sellPrice = new float[] {18.99f,400.89f, 20.80f};
        
        System.out.println( new ModifyPirce().findModifyPirces( orgItem, orgPrice, sellItem, sellPrice) );
        
        
        HashSet<String> set = new HashSet<String>();
        
        for( Iterator<String> it = set.iterator();it.hasNext(); ) {
            it.next();
        }
    }
}
