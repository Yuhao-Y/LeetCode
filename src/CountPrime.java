
public class CountPrime
{
    public int countPrimes(int n) {
        if(n<3) return 0;

        boolean[] prime = new boolean[n];
        int count = n/2;      //only need to count the odd number
        for( int i=3;i*i<n;i+=2){    //j start with i, and j*i will always large than n if i*i>=n; let i+=2, only calculate odd number
            if(prime[i]==false){ 
                for( long j=i;j*i<prime.length;j+=2){ //j+=2, only calculate odd; use Long to avoid out of Integer's bound.
                    long index = j*i;
                    if(index<prime.length&&prime[(int)index]==false){
                        prime[(int)index]=true;
                        count--;
                    }
                }
            }
        }
        
        return count;
        
    }
}
