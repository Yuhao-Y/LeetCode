import java.util.LinkedList;

public class MergeTwoSortedList
{
    public ListNode mergeTwoLists( ListNode l1, ListNode l2 )
    {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            
            tail = tail.next;
        }
        
        tail.next = l1==null?l2:l1;
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        return head.next; 
    }
    
    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        if(l1.val<=l2.val){
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }

    public static void main( String[] args )
    {
        ListNode l1 = new ListNode( 0 );

        MergeTwoSortedList m = new MergeTwoSortedList();
        System.out.println( m.mergeTwoLists( null, null ).val );
    }

}
