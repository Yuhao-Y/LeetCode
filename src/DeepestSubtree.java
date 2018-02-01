import java.util.ArrayList;
import java.util.List;

public class DeepestSubtree
{
    int maxDepth = 0;
    MultipleTreeNode res = null;
    
    public MultipleTreeNode findDeepestSubtree( MultipleTreeNode root ) {
        
        if( root == null || root.childrens.size() == 0 ) return root;
        
        
        helper( root, 0);
        
        return res;
    }
    
    private int helper( MultipleTreeNode root, int depth ) {
        if( root.childrens.size() == 0 ) {
            if( depth>= maxDepth ) {
                maxDepth = depth;
                res = root;
            }
            return depth;
        }
        
        int count = 0;
        int curMax = 0;
        int lastMax = maxDepth;
        for( MultipleTreeNode node : root.childrens ) {
            
            int tmp = helper( node, depth+1);
            if( lastMax!=maxDepth) {        // means maxDepth is change, the previous count is invalid
                count = 0;
                lastMax = maxDepth;
            }
            if( tmp == maxDepth ) count++;
            curMax = Math.max( curMax, tmp );
        }
        
        if( count>1) res = root;
        
        return curMax;
        
    }
    
    public static void main( String[] args ) {
        
        MultipleTreeNode one = new MultipleTreeNode( 1 );
        MultipleTreeNode two = new MultipleTreeNode( 2 );
        MultipleTreeNode three = new MultipleTreeNode( 3 );
        MultipleTreeNode four = new MultipleTreeNode( 4 );
        MultipleTreeNode five = new MultipleTreeNode( 5 );
        MultipleTreeNode six = new MultipleTreeNode( 6 );
        
        one.childrens.add( two );
        one.childrens.add( three );
        one.childrens.add( four );
        three.childrens.add( five );
        three.childrens.add( six );
        
        System.out.println( new DeepestSubtree().findDeepestSubtree( one ).val );
        
    }
}

class MultipleTreeNode{
    
    List<MultipleTreeNode> childrens;
    int val;
    public MultipleTreeNode( int val ) {
        this.val = val;
        childrens = new ArrayList<MultipleTreeNode>();
    }
    
}