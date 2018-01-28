
public class MergeSortedArray
{
    public void merge(int[] A, int m, int[] B, int n) {
        int k = m+n-1;
        m--;n--;
        while(m>-1&&n>-1) A[k--]=(A[m]>B[n])?A[m--]:B[n--];
        
        while(n>-1) A[k--]=B[n--];
    }
}
