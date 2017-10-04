
public class HouseRobber
{
    public int rob( int[] nums )
    {
        int pre = 0, prePre = 0, stash = 0;
        for( int i = 0; i < nums.length; i++ )
        {
            stash = Math.max( prePre+nums[i], pre );
            prePre = pre;
            pre = stash;
        }

        return stash;
    }

    public static void main( String args[] )
    {
        int[] stash = new int[] { 3, 6, 2, 1 };
        System.out.println( new HouseRobber().rob( stash ) );
    }
}
