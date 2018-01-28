import java.util.Stack;

public class ConvertBSTToDoublyLinkedList
{
    
    
    public DoublyLinkedList convert( TreeNode root ) {
        
        if( root == null ) return null;
        
        DoublyLinkedList head = null;
        DoublyLinkedList listNode = null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while( node!=null || !stack.isEmpty() ) {
            
            while( node!=null) {
                stack.add( node );
                node = node.left;
            }
            
            node = stack.pop();
            
            if( head==null && listNode==null) {
                head = new DoublyLinkedList( node.val );
                listNode = head;
            }else{
                listNode.next = new DoublyLinkedList( node.val );
                listNode.next.pre = listNode;
                listNode = listNode.next;
            }
            
            node = node.right; 
        }
        
        listNode.next = head;
        head.pre =listNode;
        
        return head;
    }
    
    DoublyLinkedList tail;
    public DoublyLinkedList convert2( TreeNode root ) {
        if( root == null ) return null;
        DoublyLinkedList dummy = new DoublyLinkedList( 0 );
        tail = dummy;
        
        helper( root);
        
        dummy.next.pre = tail;
        tail.next = dummy.next;
        
        return dummy.next;
    }
    
    public void helper( TreeNode node) {
        if( node == null ) return;
        
        helper( node.left);
        
        tail.next = new DoublyLinkedList( node.val );
        tail.next.pre = tail;
        tail = tail.next;
        
        helper(node.right);
        
    }
    
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode( 0 );
        TreeNode one = new TreeNode( 1 );
        TreeNode two = new TreeNode( 2 );
        TreeNode three = new TreeNode( 3 );
        TreeNode four = new TreeNode( 4 );
        TreeNode five = new TreeNode( 5 );
        four.left = two;
        four.right = five;
        two.left = one;
        two.right = three;
        
        DoublyLinkedList head = new ConvertBSTToDoublyLinkedList().convert2( four );
        
        DoublyLinkedList node = head;
        boolean isFirst = true;
        while( node!= head || isFirst ) {
            isFirst = false;
            System.out.println(  node.val );
            node = node.next;
        }
        
    }
    
}

class DoublyLinkedList{
    
    int val;
    DoublyLinkedList next;
    DoublyLinkedList pre;
    DoublyLinkedList( int val ){
        this.val = val;
    }
}


