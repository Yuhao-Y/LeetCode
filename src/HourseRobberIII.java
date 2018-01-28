
public class HourseRobberIII
{
    public int rob( TreeNode root )
    {

        int[] result = traverseTree( root );
        return Math.max( result[0], result[1] );
    }

    public int[] traverseTree( TreeNode root )
    {

        int[] result = new int[] { 0, 0 };

        if( root == null )
            return result;

        int[] leftValue = traverseTree( root.left );
        int[] rightValue = traverseTree( root.right );

        result[0] = root.val + leftValue[1] + rightValue[1];
        result[1] = Math.max( leftValue[0], leftValue[1] ) + Math.max( rightValue[0], rightValue[1] );

        return result;

    }
}
