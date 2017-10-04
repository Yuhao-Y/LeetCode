import java.util.LinkedList;

public class FlattenBinaryTreetoLinkedList
{
    public void flatten( TreeNode root )
    {
        if( root == null )
            return;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        TreeNode originalRoot = root;
        TreeNode newRoot = new TreeNode( 0 );
        TreeNode node = newRoot;
        while( root != null || stack.size() != 0 )
        {
            while( root != null )
            {
                node.right = new TreeNode( root.val );
                node = node.right;
                stack.push( root );
                root = root.left;

            }

            root = stack.pop();
            root = root.right;

        }

        originalRoot.left = null;
        originalRoot.right = newRoot.right;
    }

    public void flatten2( TreeNode root )
    {
        if( root == null )
            return;
        
        flatten2(root.left);
        flatten2(root.right);
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right!=null) root = root.right;
        root.right = temp;
        
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

    public static void main( String args[] )
    {
        TreeNode one = new TreeNode( 1 );
        TreeNode two = new TreeNode( 2 );
        TreeNode three = new TreeNode( 3 );
        TreeNode four = new TreeNode( 4 );
        TreeNode five = new TreeNode( 5 );
        TreeNode six = new TreeNode( 6 );
        TreeNode seven = new TreeNode( 7 );

        //four.left = two;
        //two.left = one;
        //two.right = three;
        //four.right = six;
        //six.left = five;
        //six.right = seven;

        FlattenBinaryTreetoLinkedList f = new FlattenBinaryTreetoLinkedList();
        f.flatten2( four );
        f.bfs( four );
    }
}
