import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree
{
public int widthOfBinaryTree(TreeNode root) {
        
        if( root == null ) return 0;
        
        List<Integer> list = new ArrayList<Integer>();
        
        return helper( root, 0, 1, list );
    }
    
    private int helper( TreeNode node, int level, int index, List<Integer> list ){
        
        if( node == null ) return 0;
        if( list.size()<=level) list.add(index);
        
        int maxWidth = index - list.get(level )+1;
        return Math.max( maxWidth, Math.max( helper( node.left, level+1, 2*index-1, list ), helper( node.right, level+1, 2*index, list ) ) );
    }
}
