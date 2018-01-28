
public class SumOfLeftLeaves
{
    int res = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        
        helper( root );
        return res;
    }
    
    public int helper( TreeNode node ){
        
        if( node ==null ) return 0;
        if( node.left == null && node.right == null ){
            return node.val;
        } 
        
        int left = helper( node.left);
        res = res + left;
        helper( node.right );
        
        return 0;
    }
    
    public int sumOfLeftLeaves2(TreeNode root) {
        if ( root == null){
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null ){
            sum += root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    
    public static void main( String[] args ) {
        
        TreeNode root = new TreeNode( 0 );
        TreeNode one = new TreeNode( 1 );
        TreeNode two = new TreeNode( 2 );
        TreeNode three = new TreeNode( 3 );
        TreeNode four = new TreeNode( 4 );
        TreeNode five = new TreeNode( 5 );
        four.left = two;
        four.right = five;
        two.left = one;
        two.right = three;
        
        System.out.println( new SumOfLeftLeaves().sumOfLeftLeaves( one ) );
        
    }
}
