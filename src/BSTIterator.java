import java.util.LinkedList;

public class BSTIterator
{
    TreeNode root;
    LinkedList<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        this.root = root;
        stack = new LinkedList<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        return !stack.isEmpty()||root!=null;
    }

    /** @return the next smallest number */
    public int next() {
        while( root!=null ){
            stack.push(root);
            root = root.left;
        }
        
        root = stack.pop();
        int result = root.val;
        root = root.right;
        
        return result;
    }
}
