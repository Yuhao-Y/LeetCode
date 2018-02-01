import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeMaximumPathSum
{
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        if( root == null ) return 0;
        
        helper( root );
        return maxSum;
    }
    
    public int helper( TreeNode root ) {
        
        if( root == null ) return 0;
        
        int left = Math.max( helper( root.left ), 0 );
        int right = Math.max( helper( root.right ), 0 );
        
        maxSum = Math.max( maxSum, left + right + root.val );
        
        return root.val + Math.max( left, right );
        
    }
    
    public List<Integer> maxPathSumPrint( TreeNode root ){
        if( root == null ) return null;
        
        List<Integer> list = new ArrayList<Integer>();
        
        helperPintPath( root, list );
        
        return list;
    }
    
    HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    public int helperPintPath( TreeNode root, List<Integer> list ) {
        
        if( root == null ) return 0;
        
        int left = Math.max( helperPintPath( root.left, list ), 0 );
        int right = Math.max( helperPintPath( root.right, list ), 0 );
        
        int sum = left + right + root.val;
        map.put( root, sum );   //record every nodes' max path sum.
        if( sum > maxSum ) {
            updatePath( root, left, right, list );
            maxSum = sum;
        }
        
        return root.val + Math.max( left, right );
        
    }
    
    private void updatePath( TreeNode root, int left, int right,  List<Integer> list ) {
        list.clear();
        
        int tmp = left;
        TreeNode tmpNode = root.left;
        
        //construct the path by check the path sum of every children node.
        while( tmp != 0 && tmpNode!=null ) {
            list.add( 0, tmpNode.val );
            tmp = tmp - tmpNode.val;
            if( map.containsKey( tmpNode.left ) && map.get( tmpNode.left ) == tmp ) tmpNode = tmpNode.left;
            else tmpNode = tmpNode.right;
        }
        
        list.add( root.val );
        tmp = right;
        tmpNode = root.right;
        
        while( tmp != 0 && tmpNode!=null ) {
            list.add( tmpNode.val );
            tmp = tmp - tmpNode.val;
            if( map.containsKey( tmpNode.left ) && map.get( tmpNode.left ) == tmp ) tmpNode = tmpNode.left;
            else tmpNode = tmpNode.right;
        }
    }
    
    public static void main( String[] args ) {
        
        TreeNode one = new TreeNode( 1 );
        TreeNode two = new TreeNode( 2 );
        TreeNode three = new TreeNode( 3 );
        TreeNode four = new TreeNode( -4 );
        one.left = two;
        one.right = three;
        three.left = four;
        
        System.out.println(  new BinaryTreeMaximumPathSum().maxPathSumPrint( one ) );
        
    }
}
