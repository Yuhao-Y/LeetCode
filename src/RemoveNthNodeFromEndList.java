public class RemoveNthNodeFromEndList
{
    public ListNode removeNthFromEnd( ListNode head, int n )
    {
        ListNode fast = head, slow = head;

        for( int i = 0; i < n; i++ )
        {
            fast = fast.next;
        }

        while( fast != null && fast.next != null )
        {
            fast = fast.next;
            slow = slow.next;
        }

        if( fast == null )
        {
            head = slow.next;
        }else if( slow == head)
        {
            head = slow;
            slow.next = slow.next.next;
        }
        else
        {
            slow.next = slow.next.next;
        }

        return head;
    }

    public static void main( String[] args )
    {
        ListNode head1 = new ListNode( 1 );
        //ListNode head2 = new ListNode( 2 );
        head1.next = null;
        //head2.next = null;

        RemoveNthNodeFromEndList r = new RemoveNthNodeFromEndList();

        System.out.println( r.removeNthFromEnd( head1, 1 ) );
    }
}

class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
    }
}
