
public class DiameterOfBinaryTree
{
    int maxPath = 0 ;

    public int diameterOfBinaryTree( TreeNode root )
    {
         dfs( root );
        return maxPath;
    }
    
    public int dfs( TreeNode root ){
        if( root == null ) return 0;
        
        int left = dfs( root.left);
        int right = dfs( root.right);
        
        maxPath = Math.max( maxPath, left+right );
        
        return Math.max( left, right )+1;
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
