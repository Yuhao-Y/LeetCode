import java.util.LinkedList;

public class SymmetricTree
{
    public boolean isSymmetric( TreeNode root )
    {
        if(root==null) return true;
        if( root.left == null && root.right == null )
            return true;

        //also can just use one LinkedList
        LinkedList<TreeNode> left = new LinkedList<TreeNode>();
        LinkedList<TreeNode> right = new LinkedList<TreeNode>();
        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;
        while( leftRoot != null || rightRoot != null || left.size() != 0 || right.size() != 0 )
        {
            while(leftRoot!=null&&rightRoot!=null)
            {
                if(leftRoot.val!=rightRoot.val) return false;
                
                left.push( leftRoot );
                right.push( rightRoot );
                leftRoot = leftRoot.left;
                rightRoot = rightRoot.right;
            }
            
            if(leftRoot!=null||rightRoot!=null) return false;
            
            leftRoot = left.pop();
            leftRoot = leftRoot.right;
            
            rightRoot = right.pop();
            rightRoot = rightRoot.left;
        }

        return true;
    }
    
    public static void main(String args[])
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
        System.out.println( new SymmetricTree().isSymmetric( four ) );
    }
}
