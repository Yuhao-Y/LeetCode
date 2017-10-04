import java.util.LinkedList;

public class InventBinaryTree
{
    public TreeNode invertTree( TreeNode root )
    {
        dfs( root );
        return root;
    }

    private void dfs( TreeNode node )
    {
        if( node == null )
            return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        dfs( node.left );
        dfs( node.right );

    }

    private void bfs( TreeNode node )
    {
        LinkedList<TreeNode> quene = new LinkedList<TreeNode>();
        quene.add( node );
        while( quene.size() != 0 )
        {
            int length = quene.size();
            for( int i = 0; i < length; i++ )
            {
                node = quene.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                quene.add( node.left );
                quene.add( node.right );
            }
        }
    }
}
