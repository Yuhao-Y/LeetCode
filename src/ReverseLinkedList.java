
public class ReverseLinkedList
{
    public ListNode reverseList( ListNode head )
    {
        if( head == null || head.next == null )
            return head;

        ListNode newHead = null;

        while( head != null )
        {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        
        return newHead;
    }
    
    public ListNode reverseListRecursive( ListNode head ) {
        
        if( head == null ) return null;
        
        return helper( null, head );
    }
    
    public ListNode helper( ListNode last, ListNode node ) {
        
        if( node == null) return last;
        
        ListNode tmp = node.next;
        
        node.next = last;
        last = node;
        
        return helper( last, tmp);
        
    }
}
