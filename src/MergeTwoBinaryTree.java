
public class MergeTwoBinaryTree
{
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        return dfs(t1,t2);
    }
    
    private TreeNode dfs( TreeNode t1, TreeNode t2){
        if(t1==null&&t2==null) return null;
        else if(t1==null) return t2;    //return the whole subset of the tree if other one is null, this would save time
        else if(t2==null) return t1;
        
        //int newNodeValue = 0;
        //if(t1!=null) newNodeValue+=t1.val;
        //if(t2!=null) newNodeValue+=t2.val;
        
        TreeNode node = new TreeNode(t1.val+t2.val);
        
        node.left = dfs(t1==null?null:t1.left,t2==null?null:t2.left);
        node.right = dfs(t1==null?null:t1.right,t2==null?null:t2.right);
        
        return node;
    }
}
