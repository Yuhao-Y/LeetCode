import java.util.ArrayList;
import java.util.List;

public class JumpGame
{
    public boolean canJump( int[] nums )
    {
        int max = 0;

        for( int i = 0; i < nums.length; i++ )
        {
            if(i>max) return false;
            max = Math.max( max, i+nums[i] );
        }
        
        return true;
    }
    
    public boolean canJump2(int[] A) {
        int distance = 0;
        boolean result = false;
        for( int i=A.length-1;i>=0;i--){
            if(A[i]>=distance){
                distance = 1;
                result = true;
            }else{
                distance++;
                result = false;
            }
        }
        
        return result;
    }
    
    public List<Integer> printJumpPath( int[] nums ){
        
        List<Integer> res  = new ArrayList<Integer>();
        
        helper( nums, 0, res );
        return res;
    }
    
    private boolean helper( int[] nums, int index, List<Integer> res ) {
        if( index > (nums.length-1) ) return true;
        if( nums[index]== 0 ) return false;
        
        res.add( index );
        
        for( int i = index+1;  i <= nums[index]+index; i++) {
            
            if( helper( nums, i, res)) return true;
           
        }
        
        res.remove(  res.size()-1 );
        return false;
    }
    
    public List<Integer> printJumpPath2( int[] nums ){
        
        List<Integer>[] record = new ArrayList[nums.length+1];
        List<Integer> res = new ArrayList<Integer>();
        
        record[0] = new ArrayList<Integer>( nums[0] );
        
        for( int i = 1; i < record.length ; i++) {
            for( int j = 0; j <i ; j++) {
                if( record[j]!=null && (j+nums[j])>=i ) {
                    
                    if( record[i] == null ) record[i] = new ArrayList<Integer>();
                    record[i].add( j );
                }
            }
        }
        
        if( record[record.length-1]!=null ) {
            int i = record.length-1;
            
            while( i>0 ) {
                res.add( 0, record[i].get( 0 ) );
                i = record[i].get( 0 );
            }
        }
        
        return res;
    }

    public static void main( String[] args )
    {
        System.out.println( new JumpGame().printJumpPath2( new int[] { 2,3,1,1,1 } ) );
    }
}
