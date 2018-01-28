
public class BestTimeToBuyAndSellII
{
    public int maxProfit(int[] prices) {
        
        if( prices==null || prices.length<=0 ) return 0;
        
        int hold = 0, preHold = Integer.MIN_VALUE, notHold = 0, preNotHold = 0;
        //preHold must MIN_VALUE, otherwise first not hold will not correct
        
        for( int i=0; i < prices.length ; i++ ){
            hold = Math.max( preHold, preNotHold - prices[i]);
            notHold = Math.max( preNotHold, preHold + prices[i] );
            preHold = hold;
            preNotHold = notHold;
        }
        
        return notHold;
        
    }
}
