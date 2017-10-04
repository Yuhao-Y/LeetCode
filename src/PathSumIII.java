import java.util.LinkedList;

public class PathSumIII
{
    public int pathSum( TreeNode root, int sum )
    {
        if( root == null )
            return 0;

        return dfs( root, sum ) + pathSum( root.left, sum ) + pathSum( root.right, sum );
    }

    private int dfs( TreeNode root, int sum )
    {
        if( root == null )
            return 0;

        return ( root.val == sum ? 1 : 0 ) + dfs( root.left, sum - root.val )
            + dfs( root.right, sum - root.val );

    }

    public static void main( String[] args )
    {
        TreeNode one = new TreeNode( 1 );
        TreeNode two = new TreeNode( 2 );
        TreeNode three = new TreeNode( 3 );
        TreeNode four = new TreeNode( 4 );
        TreeNode five = new TreeNode( 5 );
        TreeNode six = new TreeNode( 6 );
        TreeNode seven = new TreeNode( 7 );

        four.left = two;
        two.left = one;
        two.right = three;
        four.right = six;
        six.left = five;
        six.right = seven;

        System.out.println( new PathSumIII().pathSum( four, 6 ) );
    }
}
