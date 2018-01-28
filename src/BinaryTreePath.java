import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath
{
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> res = new ArrayList<String>();
        if( root == null ) return res;
        
        helper( root, "", res);
        
        return res;
    }
    
    public void helper( TreeNode node, String str, List<String> res ){
        
        if( node.left == null && node.right == null ) {
            res.add( str+node.val);
            return;
        }
        
        if( node.left!=null ) helper( node.left, str+node.val+"->", res);
        
        if( node.right!=null ) helper( node.right, str+node.val+"->", res);
        
    }
}
