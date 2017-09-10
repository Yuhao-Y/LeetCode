
public class BestTimeToBuyAndSell
{
    public int maxProfit( int[] prices )
    {
        int result = 0;
        if( prices.length <= 0 )
            return 0;
        int minBuy = prices[0];
        for( int i = 1; i < prices.length; i++ )
        {
            minBuy = ( minBuy > prices[i - 1] ? prices[i - 1] : minBuy );
            int profil = prices[i] - minBuy;
            result = ( profil > 0 && profil > result ) ? profil : result;
        }

        return result;
    }

    public int maxProfit2( int[] prices )
    {
        int maxProfit = 0;

        int maxCur = 0;
        int minIndex = 0;
        for( int i = 0; i < prices.length; i++ )
        {
            maxCur = Math.max( 0, prices[i] - prices[minIndex] );
            if( maxCur == 0 )
            {
                minIndex = i;
            }
            maxProfit = Math.max( maxProfit, maxCur );

        }

        return maxProfit;
    }

    public static void main( String[] args )
    {
        System.out.println( new BestTimeToBuyAndSell().maxProfit2( new int[] { 7, 1, 5, 3, 6, 4 } ) );
    }
}
