
public class SwapNodesInPairs
{
    public ListNode nodeA, nodeB;

    public ListNode swapPairs( ListNode head )
    {
        if( head != null && head.next != null )
        {
            ListNode node = new ListNode( 0 );
            node.next = head;
            swap( node );
            head = node.next;
        }

        return head;

    }

    private void swap( ListNode node )
    {
        if( node == null || node.next == null || node.next.next == null )
        {
            return;
        }

        nodeA = node.next;
        nodeB = node.next.next;

        node.next = nodeB;
        nodeA.next = nodeB.next;
        nodeB.next = nodeA;

        swap( node.next.next );
    }

    public ListNode swapPairs2( ListNode head )
    {
        if( head == null || head.next == null )
            return head;

        nodeA = head.next;
        head.next = swapPairs2(head.next.next);
        nodeA.next = head;
        
        return head;
    }
}
