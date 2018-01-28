
public class BestTimeToBuyAndSellWithTransactionFee
{
public int maxProfit(int[] prices, int fee) {
        
        if( prices == null || prices.length<=1) return 0;
        
        int hold = 0, preHold = Integer.MIN_VALUE, notHold = 0, preNotHold = 0;
        
        for( int i = 0 ; i < prices.length ; i++){
            hold = Math.max( preHold, preNotHold - prices[i] - fee); //only can calculate the transaction fee here, because preHold is MIN_VALUE
            notHold = Math.max( preNotHold, preHold + prices[i]);
            preHold = hold;
            preNotHold = notHold;
        }
        
        return notHold;
    }
}
