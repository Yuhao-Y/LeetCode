import java.util.LinkedList;

public class MaximumDepthofBinaryTree
{
    public int maxDepth( TreeNode root )
    {
        if( root == null )
            return 0;

        //return dfs( root, 1, 1 );
        return bfs( root );
    }

    private int dfs( TreeNode root, int maxLevel, int curLevel )
    {
        if( root.left == null && root.right == null )
            return Math.max( curLevel, maxLevel );

        if( root.left != null )
        {
            maxLevel = Math.max( maxLevel, dfs( root.left, maxLevel, curLevel + 1 ) );
        }

        if( root.right != null )
        {
            maxLevel = Math.max( maxLevel, dfs( root.right, maxLevel, curLevel + 1 ) );
        }

        return maxLevel;
    }

    private int bfs( TreeNode root )
    {
        int level = 0;

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add( root );

        while( nodeList.size() != 0 )
        {
            int length = nodeList.size();
            while(length>0)
            {
                TreeNode tempe = nodeList.poll();
                if(tempe.left!=null) nodeList.add(tempe.left);
                if(tempe.right!=null) nodeList.add(tempe.right);
                length--;
            }
            level++;
        }
        
        return level;
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
        //two.right = three;
        four.right = six;
        six.left = five;
        //five.right = seven;
        System.out.println( new MaximumDepthofBinaryTree().maxDepth( four ) );
    }
}
