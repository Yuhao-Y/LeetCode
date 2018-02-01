
public class LowestCommonAncestorBinaryTree
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //p and q must in tree. If p and q can be not in the tree, this method is not available any more
        if(root==null||root==p||root==q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left!=null&&right!=null) return root;
        if(left!=null) return left;
        else if(right!=null) return right;
        else return null;
        
    }
    
    //this method still worked even the A or B is not in the tree
    TreeNode result = null;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root==null) return null;
        dfs(root, A, B);
        return result;
    }
    
    public boolean dfs( TreeNode root, TreeNode A, TreeNode B){
        if( root == null) return false;
        if(root==A&&root==B) { result = root;return false;}
        
        boolean left = dfs( root.left, A, B);
        boolean right = dfs( root.right, A, B);
        
        if(left&&right){ result = root; return false;}
        
        if((left||right)&&(root==A||root==B)){ result = root; return false;} // if one of the two node is the children of another node  
        
        return root==A||root==B||left||right;
    }
    
    public static void main( String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(5);
        one.right = two;
        two.right = three;
        three.right = four;
        four.right = five;
        
        System.out.println( new LowestCommonAncestorBinaryTree().lowestCommonAncestor( one, three, six ) );
    }
}
