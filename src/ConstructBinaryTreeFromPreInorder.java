import java.util.Arrays;
import java.util.LinkedList;

public class ConstructBinaryTreeFromPreInorder
{
    public TreeNode buildTree( int[] preorder, int[] inorder )
    {
        if( preorder.length != inorder.length )
            return null;
        if( preorder.length == 0 )
            return null;

        TreeNode root = new TreeNode( preorder[0] );

        root = dfs( preorder, inorder,0, inorder.length, 0 );
        return root;
    }

    public TreeNode dfs( int preorder[], int[] inorder, int inorderStart, int inorderEnd, int inStartIndex )
    {
        if( inorderStart>=inorderEnd || inStartIndex >= preorder.length )
            return null;
        int i = inorderStart;
        TreeNode root = new TreeNode( preorder[inStartIndex] );
        for( ; i < inorderEnd; i++ )
        {
            if( inorder[i] == root.val )
                break;
        }

        root.left = dfs( preorder, inorder, inorderStart, i, inStartIndex + 1 );
        root.right = dfs( preorder, inorder, i + 1, inorderEnd, inStartIndex + i - inorderStart + 1 );

        return root;
    }

    public void bfs( TreeNode root )
    {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add( root );
        while( stack.size() != 0 )
        {
            int length = stack.size();
            for( int i = 0; i < length; i++ )
            {
                TreeNode node = stack.poll();
                System.out.print( node.val );
                if( node.left != null )
                    stack.add( node.left );
                if( node.right != null )
                    stack.add( node.right );
            }
            System.out.println( "" );
        }

    }

    public static void main( String[] args )
    {
        ConstructBinaryTreeFromPreInorder c = new ConstructBinaryTreeFromPreInorder();
        c.bfs( c.buildTree( new int[] { 1,2,3 }, new int[] { 1,2,3} ) );
    }
}
