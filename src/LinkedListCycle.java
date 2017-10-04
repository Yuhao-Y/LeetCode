
public class LinkedListCycle
{
    // let the current node point to head. And list will back to head if it have loop. 
    //But the original struct of the list has been destroied
    public boolean hasCycle( ListNode head )
    {
        if(head==null) return true;
        
        ListNode node = head.next;
        
        while(node!=null&&node!=head)
        {
            ListNode tmp = node.next;
            node.next = head;
            node = tmp;
        }
        
        return true;
    }
    
    //use fast and slow point
    public boolean hasCycle2( ListNode head )
    {
        if(head==null) return false;
        
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) return true;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        head.next = node1;
        
        System.out.println( new LinkedListCycle().hasCycle2( head ) );
    }
}
