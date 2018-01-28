import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SprseMatrixMultiplication
{
    public int[][] multiplyBruteForce(int[][] A, int[][] B) {
        // write your code here
        
        int[][] res = new int[A.length][B[0].length];
        
        for( int i=0;i< A.length; i++){
            for( int j = 0; j <B[0].length; j++ ){
                for( int k=0; k < A[0].length; k++)
                    res[i][j] += A[i][k]* B[k][j];
            }
        }
        
        return res;
    }
    
    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        
        int[][] res = new int[A.length][B[0].length];
        
        HashSet<Integer>[] listA = new HashSet[A.length];
        HashSet<Integer>[] listB = new HashSet[B[0].length];
        
        for( int i =0; i <A.length;i++){
            listA[i] = new HashSet<Integer>();
            for( int j=0; j< A[0].length; j++ ){
                if( A[i][j] !=0 ) listA[i].add(j);
            }
        }
        
        for( int i =0; i <B[0].length;i++){
            listB[i] = new HashSet<Integer>();
            for( int j=0; j< B.length; j++ ){
                if( B[j][i] !=0 ) listB[i].add(j);
            }
        }
        
        for( int i=0; i < listA.length ; i++)
            for( int j=0; j < listB.length; j++ ){
                for( Integer x:listA[i] ){
                    if( listB[j].contains(x) )
                        res[i][j]+=A[i][x]*B[x][j];
                }
            }
        
        return res;
    }
    
    public int[][] multiply2(int[][] A, int[][] B){

        int[][] res = new int[A.length][B[0].length];
        HashMap<Integer, ArrayList<Integer>> hmRow = new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Integer>> hmCol = new HashMap<Integer,ArrayList<Integer>>();

        for (int i = 0; i < A.length; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < A[0].length;j++){
                if (A[i][j] != 0){
                    row.add(A[i][j]);
                    hmRow.put(i,row);
                }
            }
        }
        for (int i = 0; i < B[0].length; i++){
            ArrayList<Integer> col = new ArrayList<>();
            for (int j = 0; j < B.length; j++){
                if (B[i][j] != 0){
                    col.add(B[i][j]);
                    hmCol.put(i,col);
                }
            }
        }

        
        for (int i = 0; i < res.length; i++){
            for (int j = 0; j < res[0].length; j++){
                for (Integer aRow: hmRow.get(i)){
                    if (hmCol.get(j).contains(aRow))
                    res[i][j] += A[i][aRow] * B[aRow][j];
                }
            }
        }
        return res;
    }
}
