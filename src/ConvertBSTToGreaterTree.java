import java.util.LinkedList;

public class ConvertBSTToGreaterTree
{

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
       
        inorder( root);
        return root;
    }
    
    public void inorder( TreeNode root ) {
        if( root ==null ) return;
        
        inorder(root.right);
        root.val += sum;
        sum = root.val;
        inorder( root.left );
    }
    
    public TreeNode convertBSTIterator(TreeNode root) {
        if( root ==null ) return null;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        int sum = 0;
        TreeNode node = root;
        
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node = node.right;
            }
            
            TreeNode tmp = stack.pop();
            sum = tmp.val+sum;
            tmp.val = sum;
            node = tmp.left;
        }
        
        
        return root;
        
    }
}
