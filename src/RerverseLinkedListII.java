
public class RerverseLinkedListII
{
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if( head == null ||  m == n ) return head;
        
        ListNode sentinal = new ListNode( 0 );
        sentinal.next = head;
        ListNode preM = null, nextN = null, newTail = null, node = sentinal;
        
        for( int i=1;i<m;i++){
            node = node.next;
        }
        
        preM = node;
        newTail = preM.next;
        node = newTail;
        for( int i=0;i<(n-m);i++){
            node = node.next;
        }
        nextN = node.next;
        node.next = null;
        ListNode newHead = reverse(preM.next);
        preM.next = newHead;
        newTail.next = nextN;
        
        
        return sentinal.next;
    }
    
    public ListNode reverse( ListNode head){
        
        ListNode newHead = null;
        while( head != null){
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
    
    public ListNode reverseBetweenInsert(ListNode head, int m, int n) {
        if( head == null ||  m == n ) return head;
        
        ListNode sentinal = new ListNode( 0 );
        sentinal.next = head;
        ListNode cur = sentinal;
        
        for( int i=1; i<m;i++){
            cur = cur.next;
        }
        
        ListNode pre = cur;
        ListNode tail = pre.next;
        cur = tail.next;
         
        for( int i=0;i<(n-m);i++){  //remove a node and insert this node to the certarin index
            tail.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = tail.next;
        }
        
        
        return sentinal.next;
    }
    
    public static void main( String[] args ) {
        ListNode one = new ListNode( 1 );
        ListNode two = new ListNode( 2 );
        ListNode thr = new ListNode( 3 );
        ListNode four = new ListNode( 4 );
        ListNode five = new ListNode( 5 );
        one.next = two;
        two.next = thr;
        thr.next = four;
        four.next = five;
        System.out.println( new RerverseLinkedListII().reverseBetween( one,2,4 ) );
    }
}
