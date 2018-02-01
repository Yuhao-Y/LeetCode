import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal
{
    public List<List<Integer>> levelOrder( TreeNode root )
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if( root == null )
            return result;

        //recursive( result, root, 0 ); //dfs method
        iterator(result, root); //bfs method
        return result;
    }

    private void iterator( List<List<Integer>> result, TreeNode root )
    {
        if( root == null )
            return;

        LinkedList<TreeNode> tempTreeNode = new LinkedList<TreeNode>();
        tempTreeNode.add( root );
        while( tempTreeNode.size() > 0 )
        {
            int length = tempTreeNode.size();
            LinkedList<Integer> treeNodeValue = new LinkedList<Integer>();
            for( int i = 0; i < length; i++ )
            {
                TreeNode node = tempTreeNode.poll();
                treeNodeValue.add( node.val );
                if(node.left!=null)
                    tempTreeNode.add( node.left );
                if(node.right!=null)
                tempTreeNode.add( node.right );
            }
            result.add( treeNodeValue );
        }

    }

    private void recursive( List<List<Integer>> result, TreeNode root, int level )
    {
        if( root == null )
            return;
        if( result.size() <= level )
            result.add( new LinkedList<Integer>() );

        result.get( level ).add( root.val );

        recursive( result, root.left, level + 1 );
        recursive( result, root.right, level + 1 );

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

        four.left = two;
        two.left = one;
        two.right = three;
        four.right = six;
        six.left = five;
        six.right = seven;

        System.out.println( new BinaryTreeLevelOrderTraversal().levelOrder( four ) );
    }
}
