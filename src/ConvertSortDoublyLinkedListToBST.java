
public class ConvertSortDoublyLinkedListToBST
{
    public TreeNode convert( DoublyLinkedList head){
        
        if( head == null ) return null;
        if( head.next ==null ) return new TreeNode( head.val);
        
        TreeNode root = null;
        if( head.pre!=null) head.pre.next = null;
        
        DoublyLinkedList slow = head, fast = head;
        
        while( fast!=null&& fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        root = new TreeNode( slow.val );
        
        if( slow.pre!=null)
            slow.pre.next = null;
        
        if( slow.next!=null)
            slow.next.pre = null;
        
        root.left = convert( head );
        root.right = convert( slow.next);
        
        
        return root;
    }
    
    public static void main( String[] args ) {
        DoublyLinkedList head = new DoublyLinkedList(2);
        DoublyLinkedList f = new DoublyLinkedList(5);
        DoublyLinkedList s = new DoublyLinkedList(6);
        DoublyLinkedList e = new DoublyLinkedList(8);
        DoublyLinkedList n = new DoublyLinkedList(9);
        DoublyLinkedList t = new DoublyLinkedList(10);
        DoublyLinkedList tail = new DoublyLinkedList(12);

        head.next = f;
        f.pre = head;

        f.next = s;
        s.pre = f;

        s.next = e;
        e.pre = s;

        e.next = n;
        n.pre = e;

        n.next = t;
        t.pre = n;

        t.next = tail;
        tail.pre = t;

        head.pre = tail;
        tail.next = head;      
        
        TreeNode treeHead = new ConvertSortDoublyLinkedListToBST().convert( head );
        
        inorder( treeHead );
    }
    
    static public void inorder( TreeNode node ) {
        if( node ==null ) return;
        
        inorder(node.left);
        System.out.println(  node.val );
        inorder( node.right);
    }
    
}
