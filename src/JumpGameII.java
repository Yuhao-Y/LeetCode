
public class JumpGameII
{
    public int jump( int[] nums )
    {

        int step = 0;
        int maxDistance = 0;
        int lastPostion = 0;

        for( int i = 0; i < nums.length - 1; i++ )
        {
            maxDistance = Math.max( maxDistance, nums[i] + i );
            if( lastPostion == i )
            {
                step++;
                lastPostion = maxDistance;
            }
        }

        return step;
    }
}
