import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidBinarySearchTree
{
    public boolean isValidBST( TreeNode root )
    {
        if(root==null) return true;
        
        return dfs(root.left,Double.NEGATIVE_INFINITY,root.val)&&dfs(root.right,root.val, Double.POSITIVE_INFINITY);
    }
    
    private boolean dfs( TreeNode root, double minValue, double maxValue)
    {
        if(root ==null) return true;
        
        if(root.val>=maxValue||root.val<=minValue) return false;
        
        return dfs(root.left,minValue,Math.min( maxValue, root.val ) )&&dfs(root.right, Math.max( minValue, root.val ), maxValue);
    }
    
    public List<TreeNode> BinaryTreeTraversal( TreeNode root)
    {
        List<TreeNode> result = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while(root!=null||stack.size()!=0)
        {
            while(root!=null)
            {
                stack.push( root );
                //result.add( root ); //preorder
                root = root.left;
            }
            
            root = stack.pop();
            //result.add( root ); //inorder
            if(pre!=null&&root.val<=pre.val) return null;
            pre = root;
            root = root.right;
            
        }
        
        return result;
    }
    
    public static void main( String args[] )
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
        six.left = five;
        six.right = seven;
        
        System.out.print( new ValidBinarySearchTree().isValidBST( four ) );
        System.out.print( new ValidBinarySearchTree().BinaryTreeTraversal( four ) );
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public String toString()
    {
        return String.valueOf( val );
    }
    
    TreeNode(int x)
    {
        val = x;
    }
}
