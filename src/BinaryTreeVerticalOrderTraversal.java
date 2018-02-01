import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeVerticalOrderTraversal
{
        /*
         * @param root: the root of tree
         * @return: the vertical order traversal
         */
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if(root == null) return result;
            int minRow = 0, maxRow = 0;
            
            HashMap<TreeNode, Integer> nodeRow = new HashMap<TreeNode, Integer>(); // key is the node, value is the index of the node
            HashMap<Integer, List<Integer>> rowNodes = new HashMap< Integer, List<Integer>>(); //key is the row index, value is the collection of all the node
            
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            nodeRow.put(root,0);
            
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add( root.val );
            rowNodes.put(0, tmp );
            
            while(!queue.isEmpty()){
                for( int i = queue.size();i>0;i--){
                    
                    TreeNode node = queue.poll();
                    int nodeIndex = nodeRow.get(node);
                    TreeNode left = node.left, right = node.right;
                    
                    minRow = Math.min( minRow,nodeIndex-1 );
                    maxRow = Math.max( maxRow,nodeIndex+1 );
                    
                    if(left != null){
                        queue.add(left);
                        nodeRow.put(left,nodeIndex-1);
                        if(!rowNodes.containsKey(nodeIndex-1)) rowNodes.put(nodeIndex-1, new ArrayList<Integer>());
                        rowNodes.get(nodeIndex-1).add(left.val);
                    }
                    
                    if(right != null){
                        queue.add(right);
                        nodeRow.put(right,nodeIndex+1);
                        if(!rowNodes.containsKey(nodeIndex+1)) rowNodes.put(nodeIndex+1, new ArrayList<Integer>());
                        rowNodes.get(nodeIndex+1).add(right.val);
                    }
                }
            }
            
            while(minRow<=maxRow) result.add(rowNodes.get(minRow++));
            return result;
    }
    
    public static void main( String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        
        root.left = one;
        one.right = two;
        root.right = three;
        
        System.out.println( new BinaryTreeVerticalOrderTraversal().verticalOrder( root ));
    }
}
