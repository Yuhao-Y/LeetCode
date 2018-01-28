
public class Search2DMatrixI
{
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length<=0||matrix[0].length<=0) return false;
        int startX =0, startY = 0, endX = matrix.length, endY = matrix[0].length;
        for( ; startX<endX;startX++){
            if(target==matrix[startX][startY]||target==matrix[startX][endY-1]) return true;
            if(target>matrix[startX][startY]&&target<matrix[startX][endY-1]) break;
        }
        
        if(startX<endX){
            while(startY<=endY){
                int midY = (startY+endY)/2;
                int midValue = matrix[startX][midY];
                if(target==midValue) return true;
                else if(target>midValue) startY = midY+1;
                else endY = midY-1;
            }
        }
        
        return false;
    }
    
    public boolean searchMatrixTreat2DAsArray(int[][] matrix, int target) {
        if(matrix==null||matrix.length<=0||matrix[0].length<=0) return false;
        
        int start = 0, end = matrix.length*matrix[0].length-1;
        int m = matrix.length, n = matrix[0].length;
    
        while(start<=end){
            int mid = (start+end)/2;
            int x = mid/n, y = mid%n;
            
            if(target==matrix[x][y]) return true;
            else if( target>matrix[x][y]) start = mid+1;
            else end =mid-1;
            
        }
        
        return false;
    }
}
