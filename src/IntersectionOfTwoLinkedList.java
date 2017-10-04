
public class IntersectionOfTwoLinkedList
{
    public ListNode getIntersectionNode( ListNode headA, ListNode headB )
    {
        if( headA == null || headB == null )
            return null;


        return solution1(headA, headB);
    }

    private ListNode solution1( ListNode headA, ListNode headB )
    {
        int lengthA = 0, lengthB = 0;
        ListNode nodeA = headA, nodeB = headB;
        while( nodeA != null )
        {
            nodeA = nodeA.next;
            lengthA++;
        }

        while( nodeB != null )
        {
            nodeB = nodeB.next;
            lengthB++;
        }

        while( lengthA > lengthB )
        {
            headA = headA.next;
            lengthA--;
        }

        while( lengthB > lengthA )
        {
            headB = headB.next;
            lengthB--;
        }
        
        while(headA!=null&&headB!=null) {
            if(headA==headB) return headA;
            
            headA=headA.next;
            headB=headB.next;
        }

        return null;
    }
    
    private ListNode solution2( ListNode headA, ListNode headB )
    {
        ListNode nodeA = headA, nodeB = headB;
        
        while(nodeA!=nodeB)
        {
            nodeA = nodeA==null?headB:nodeA.next;
            nodeB = nodeB==null?headA:nodeB.next;
        }
        
        return nodeA;
        
    }
    
    
}
