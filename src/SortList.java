
public class SortList
{
    public ListNode sortList( ListNode head )
    {
        if( head == null )
            return head;

        return merge( head );
    }

    public void sort( ListNode head, ListNode tail )
    {

        if( head.next == tail || head == tail )
            return;

        ListNode node = head;
        ListNode mid = tail;
        while( node != null && node.next != mid && node.next != null )
        {
            if( node.next.val >= mid.val )
            {
                ListNode tmp = node.next;
                node.next = tmp.next;
                int[] a = new int[10];
                int[] b = new int[10];
                tmp.next = tail.next;
                tail.next = tmp;
                tail = tail.next;

            }
            else
            {
                node = node.next;
            }

        }

        sort( head, node );
        sort( mid, tail );

        return;
    }

    public ListNode merge( ListNode head )
    {
        if( head == null || head.next == null )
            return head;
        
        //divide List into two part
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(fast!=null&&fast.next!=null)
        {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        pre.next = null;

//        ListNode head1 = head;
//        ListNode head2 = head.next;
//        ListNode tmp1 = head1;
//        ListNode tmp2 = head2;
//
//        while( tmp1.next != null && tmp2.next != null )
//        {
//            tmp1.next = tmp1.next.next;
//            tmp2.next = tmp2.next.next;
//            if(tmp1.next!=null)
//                tmp1 = tmp1.next;
//            if(tmp2.next!=null)
//                tmp2 = tmp2.next;
//        }
//
//        tmp1.next = null;
//        tmp2.next = null;
//
//        head1 = merge( head1 );
//        head2 = merge( head2 );
        
        //recursive divide part1
        ListNode head1 = merge( head );
        //recursive divide part2
        ListNode head2 = merge( slow );

        //sort part1 and part2
        return mergeSort( head1, head2 );
    }

    public ListNode mergeSort( ListNode head1, ListNode head2 )
    {
        ListNode sentinel = new ListNode( 0 );
        ListNode tmp = sentinel;

        while( head1 != null && head2 != null )
        {
            if( head1.val <= head2.val )
            {
                tmp.next = head1;
                head1 = head1.next;
            }
            else
            {
                tmp.next = head2;
                head2 = head2.next;
               
            }
            tmp = tmp.next;
        }

        if( head1 == null )
            tmp.next = head2;

        if( head2 == null )
            tmp.next = head1;

        return sentinel.next;
    }

    public static void main( String[] args )
    {
        ListNode one = new ListNode( 1 );
        ListNode two = new ListNode( 2 );
        ListNode three = new ListNode( 3 );
        three.next = two;
        two.next = one;

        ListNode head = new SortList().sortList( three );
        while( head != null )
        {
            System.out.println( head.val );
            head = head.next;
        }
    }
}
