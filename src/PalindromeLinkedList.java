
public class PalindromeLinkedList
{
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode fast= head, slow = head;
        while(fast.next!=null&&fast.next.next!=null){  //the slow will stop at the first element of the two mid element if the list size is even
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode newHead = null;
        //newHead.next = null;
        slow = slow.next;
        while(slow!=null){
            ListNode tmp = slow.next;
            slow.next = newHead;
            newHead = slow;
            slow = tmp;
        }
        
        slow = head;
        while(newHead!=null){
            if(slow.val!=newHead.val) return false;
            slow = slow.next;
            newHead = newHead.next;
        }
        
        return true;
        
    }
    
    public static void main( String[] args ) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b; b.next = c; c.next = d; d.next = e;e.next = f;
        ListNode slow=a,fast =a;
        while(fast.next!=null&&fast.next.next!=null) {
            slow=slow.next;
            fast = fast.next.next;
            
        }
        System.out.println( slow.val );

        
    }
}
