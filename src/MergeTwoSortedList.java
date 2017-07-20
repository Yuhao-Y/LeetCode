
public class MergeTwoSortedList
{
    public ListNode mergeTwoLists( ListNode l1, ListNode l2 )
    {
        if( l1 == null && l2 == null )
        {
            return null;
        }
        ListNode head = null;

        if( ( l1 != null ) && ( l2 == null || l1.val <= l2.val ) )
        {
            head = l1;
            l1 = l1.next;
        }
        else if( ( l2 != null ) && ( l1 == null || l1.val > l2.val ) )
        {
            head = l2;
            l2 = l2.next;
        }

        ListNode current = head;

        while( l1 != null || l2 != null )
        {
            if( ( l1 != null ) && ( l2 == null || l1.val <= l2.val ) )
            {
                current.next = l1;
                l1 = l1.next;
            }
            else if( ( l2 != null ) && ( l1 == null || l1.val > l2.val ) )
            {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        return head;
    }

    public static void main( String[] args )
    {
        ListNode l1 = new ListNode( 0 );

        MergeTwoSortedList m = new MergeTwoSortedList();
        System.out.println( m.mergeTwoLists( null, null ).val );
    }

}
