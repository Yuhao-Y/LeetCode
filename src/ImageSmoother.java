
public class ImageSmoother
{
    public int[][] imageSmoother(int[][] M) {
        
        if( M==null ) return M;
        
        int[][] res = new int[M.length][M[0].length];
        
        for( int i=0; i < M.length; i++ ){
            for( int j=0; j <M[0].length; j++ ){
                int sum=0;
                int count=0;
                for( int m = i==0?0:i-1; m<=Math.min( i+1, M.length-1); m++ ){
                    for( int n = j==0?0:j-1; n<= Math.min( j+1, M[0].length-1 ); n++){
                        sum += M[m][n];
                        count++;
                    }
                }
                
                res[i][j] = sum/count;
                
            }
        }
        
        return res;
    }
}
