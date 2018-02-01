import java.util.Stack;

public class InorderSuccessorInBST
{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if( root == null ) return null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while( node!=null || !stack.isEmpty()) {
            while( node != null) {
                stack.push( node );
                node = node.left;
            }
            
            node = stack.pop();
            
            if( node == p ) {
                if( node.right!=null) {
                    node = node.right;
                    while( node.left!=null) node = node.left;
                    return node;
                }else {
                    return stack.size() == 0?null:stack.pop();
                }
            }
               
                
            node = node.right;
        }
        
        return null;
    }
    
    
    //This method cannot work if p is not in the root
    public TreeNode inorderSuccessorRecursive( TreeNode root, TreeNode p ) {
        if( root ==null || p == null ) return null;
        
        if( p.val>=root.val) return inorderSuccessorRecursive( root.right, p );
        else {
            TreeNode node = inorderSuccessorRecursive( root.left, p);
            return (node==null)?root:node;
        }
            
    }
    
    
    public static void main( String[] args ) {
        
        TreeNode root = new TreeNode( 0 );
        TreeNode one = new TreeNode( 1 );
        TreeNode two = new TreeNode( 2 );
        TreeNode three = new TreeNode( 3 );
        TreeNode four = new TreeNode( 4 );
        TreeNode five = new TreeNode( 5 );
        root.right = three;
        three.left = one;
        three.right = five;
        
        System.out.println( new InorderSuccessorInBST().inorderSuccessorRecursive( root, one ) );
        
    }
}
