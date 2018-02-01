
public class ReorderList
{
    public void reorderList(ListNode head) {
        // write your code here
        if(head==null||head.next==null) return;
        ListNode fast = head, low = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            low = low.next;
        }
        
        ListNode mid = low;
        ListNode pre = low;
        low = low.next;
        while(low!=null){
            ListNode tmp = low.next;
            low.next = pre;
            pre = low;
            low = tmp;
        }
        mid.next = null;
        
        fast = head;
        while(fast!=mid){
            ListNode tmp1 = fast.next;
            ListNode tmp2 = pre.next;
            fast.next = pre;
            pre.next = tmp1;
            fast = tmp1;
            pre = tmp2;
        }
        
        mid = null;
    }
    
    public static void main( String[] args) {
        ListNode one =new ListNode(1);
        ListNode two =new ListNode(2);
        ListNode three =new ListNode(3);
        ListNode four =new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        
        ListNode fast = one, slow  = one;
        while(fast!=null&&fast.next!=null) {   //slow will end at the second mid element
            fast = fast.next.next;
            slow = slow.next;
        }
        
        System.out.println( slow.val );
        
        fast = one; slow  = one;
        while(fast.next!=null&&fast.next.next!=null) {  //slow will end at the first mid element
            fast = fast.next.next;
            slow = slow.next;
        }
        
        System.out.println( slow.val );
        
        //new ReorderList().reorderList( one );
    }
}
