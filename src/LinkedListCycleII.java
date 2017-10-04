
public class LinkedListCycleII
{
    public ListNode detectCycle( ListNode head )
    {
        if( head == null )
            return null;

        boolean isCycle = false;

        ListNode fast = head, slow = head;

        while( fast.next != null && fast.next.next != null )
        {
            fast = fast.next.next;
            slow = slow.next;
            if( fast == slow )
            {
                isCycle = true;
                break;
            }
        }

        if( isCycle == true )
        {
            fast = head;
            while( fast != slow )
            {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }

        return null;
    }

    public static void main( String[] args )
    {
        ListNode head = new ListNode( 1 );
        ListNode node1 = new ListNode( 2 );
        ListNode node2 = new ListNode( 3 );
        ListNode node3 = new ListNode( 4 );
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println( new LinkedListCycleII().detectCycle( head ).val );
    }
}
