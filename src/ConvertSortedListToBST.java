
public class ConvertSortedListToBST
{
    public TreeNode sortedListToBST(ListNode head) {
        if( head == null ) return null;
        
        return helper( head );    
    }
    
    public TreeNode helper( ListNode head ){
        if( head == null) return null;
        if( head.next == null ) return new TreeNode( head.val ); // avoid the dead loop.
        
        ListNode fast = head, slow = head, pre = null;
        while( fast != null && fast.next!=null ){
            
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode node = new TreeNode( slow.val );
        pre.next = null;
        
        node.left = helper( head);
        node.right = helper( slow.next);
        
        return node;
        
    }
}
