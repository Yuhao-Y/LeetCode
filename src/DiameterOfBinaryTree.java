
public class DiameterOfBinaryTree
{
    int diameter = 0;

    public int diameterOfBinaryTree( TreeNode root )
    {
        dfs( root, 1 );
        return diameter;
    }

    private int dfs( TreeNode node, int level )
    {
        if( node == null )
            return level-1;

        int leftLevel = dfs( node.left, level+1 );
        int rightLevel = dfs( node.right, level+1 ) ;
        diameter = Math.max( leftLevel + rightLevel - level - level, diameter );

        return Math.max( leftLevel, rightLevel );
    }

    public static void main( String[] args )
    {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        
        four.left = two;
        two.left = one;
        two.right = three;
        four.right = six;
        //six.left = five;
        //six.right = seven;
        
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree( four ));
    }
}
