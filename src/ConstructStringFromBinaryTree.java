
public class ConstructStringFromBinaryTree
{
    public String tree2str(TreeNode t) {
        if( t== null ) return "";
        
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        
        if( left==""&&right=="") return String.valueOf(t.val);
        else if( left!=""&&right=="") return t.val+"("+left+")";
        else return t.val+"("+left+")("+right+")";
    }
}
