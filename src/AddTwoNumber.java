
public class AddTwoNumber
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        
        recursive( l1, l2, 0, sentinel);
        
        return sentinel.next;
    }
    
    public void recursive( ListNode l1, ListNode l2, int carry, ListNode node){
        if(l1 != null || l2 != null || carry!=0){
            int val = (l1==null?0:l1.val) + (l2==null?0:l2.val) + carry;
            carry = val/10;
            val = val%10;
            
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
            
            node.next = new ListNode( val );
            recursive( l1, l2, carry, node.next);
        }else{
            return;
        }
    }
    
    public ListNode recursiveWithOutSentinel( ListNode l1, ListNode l2, int carry){
        ListNode node = null;
        if(l1 != null || l2 != null || carry!=0){
            if( l1==null&&carry==0&&l2!=null ) return l2;
            else if( l2==null&&carry==0&&l1!=null ) return l1;
            
            int val = (l1==null?0:l1.val) + (l2==null?0:l2.val) + carry;
            carry = val/10;
            val = val%10;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
            node = new ListNode( val );
            node.next = recursiveWithOutSentinel( l1, l2, carry);
        }
        
        return node;
    }
}
