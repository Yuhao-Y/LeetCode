
public class RotateFunction
{
    //O(n^2)
    public int maxRotateFunctionWithBruteForce(int[] A) {
        
        if( A==null || A.length == 0 ) return 0;
        
        int res=Integer.MIN_VALUE;
        for( int i=0; i < A.length; i++ ){
            
            int sum = 0;
            for( int j=i; j< i+A.length; j++ ){
                int index = j%A.length;
                sum+=A[index]*(j-i);
            }
            
            res = Math.max( res, sum );
            
        }
        
        return res;
    }
    
    //O(n)
    // sum[i] = 0*A0+1*A1+2*A2+...+n*An
    // sum[i-1] = 0*A1+1*A2+...(n-1)Bn+ n*B0
    // sum[i] - sum[i-1] = A0+A1+A2+A3+...+An-(n+1)*A0  
    // assume sum = A0+A1+A2+...+An
    // sum[i] = sum[i-1] + sum - (n+1)*A0
    public int maxRotateFunction(int[] A) {
        
        if( A==null || A.length == 0 ) return 0;
        
        int sum = 0;
        int preValue = 0;
        for( int i=0; i < A.length; i++ ){
            preValue += i*A[i];
            sum += A[i];
        }
        
        int res=preValue;
        
        for( int i=1; i < A.length; i++ ){
            preValue = preValue + sum - (A.length)*A[A.length - i];
            res = Math.max( res, preValue );
            
        }
        
        return res;
    }
}
