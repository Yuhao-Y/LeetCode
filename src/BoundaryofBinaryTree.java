import java.util.ArrayList;
import java.util.List;

public class BoundaryofBinaryTree
{
    public List<Integer> getBoundary( TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if( root ==null ) return result;
        
        result.add( root.val );
        
        if(root.left==null&&root.right==null) return result;
        
        TreeNode node = root.left;
        while(node!=null) {         // get the left boundary
            if(node==null||node.left==null&&node.right==null) break;
            result.add( node.val );
            node = node.left;
            
        }
        
        dfs( root, result);     // get the bottom boundary
        
        node = root.right;
        while(node!=null) {     // get the right boundary
            if(node==null||node.left==null&&node.right==null) break;
            result.add( node.val );
            node = node.right;
            
        }
        
        return result;
    }
    
    public void dfs( TreeNode root, List<Integer> result) {
        if( root.left==null&& root.right==null) {
            result.add( root.val );
            return;
        }
        
        if( root.left!=null) dfs(root.left, result);
        if( root.right!=null) dfs(root.right, result);
    }
    
    public static void main( String[] args) {
        
        TreeNode root = new TreeNode( 0 );
        TreeNode one = new TreeNode( 1 );
        TreeNode two = new TreeNode( 2 );
        TreeNode three = new TreeNode( 3 );
        TreeNode four = new TreeNode( 4 );
        TreeNode five = new TreeNode( 5 );
        TreeNode six = new TreeNode( 6 );
        root.left = one;
        root.right = two;
        two.left = three;
        
        System.out.println( new BoundaryofBinaryTree().getBoundary( root ) );
    }
}
