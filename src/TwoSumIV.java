import java.util.HashSet;

public class TwoSumIV
{
    public boolean findTarget(TreeNode root, int k) {
        
        return helper( root, new HashSet<Integer>(), k);
    }
    
    public boolean helper( TreeNode node, HashSet<Integer> set, int k){
        if( node==null) return false;
        
        if( set.contains( k - node.val)) return true;
        else set.add(node.val);
        
        return helper( node.left, set, k)||helper( node.right, set, k);
    }
}
