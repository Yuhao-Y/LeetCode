import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView
{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        result.add(root.val);
        while(queue.size()!=0){
            int length = queue.size();
            while(length-->0){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            
            result.add(queue.getLast().val);
        }
        
        return result;
    }
    
    public List<Integer> rightSideViewRecursive( TreeNode root ){
        List<Integer> list = new ArrayList<Integer>();
        
        if( root == null ) return list;
        
        helper( root, list, 0 );
        
        return list;
    }
    
    private void helper( TreeNode root, List<Integer> list, int level ){
        
        if( root == null ) return;
        
        if( list.size() == level ){
            
            list.add( root.val );
            
        }
        
        helper( root.right, list, level+1 );
        helper( root.left, list, level+1 );
        
    }
}
