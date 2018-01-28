import java.util.ArrayList;
import java.util.HashMap;

public class RotateList
{
    public ListNode rotateRight(ListNode head, int k) {
        if( head == null||head.next==null || k == 0 ) return head;
        
        ListNode fast = head;
        int length=1;
        while(fast.next!=null){
            fast=fast.next;
            length++;
        }
        
        k = k%length;
        
        if(k==0) return head;
        ListNode slow = head;
        for( int i=0;i<length-k-1;i++){   //length-k-1 is because we need to set the new lits's last node's next to null
            slow = slow.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
    
    public static void main( String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add( 3 );
        list.add( 2 );
        list.add( 1 );
        list.remove( new Integer(1) );
        
        
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put( 3, 3 );
        map.put( 2, 2 );
        map.put( 1, 1 );
        map.remove( 1 );
        System.out.println( map.toString() );
    }
}
