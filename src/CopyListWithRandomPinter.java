import java.util.HashMap;

public class CopyListWithRandomPinter
{
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;

        
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode point = head;
        RandomListNode newList = new RandomListNode(0);
        RandomListNode newPoint = newList;
        while( point!=null){
            RandomListNode node = new RandomListNode(point.label);
            newPoint.next = node;
            newPoint = newPoint.next;
            map.put(point,node);
            point = point.next;
        }
        
        point = head; 
        newPoint = newList.next;
         while( point!=null){
            newPoint.random = map.get(point.random);
            newPoint = newPoint.next;
            point = point.next;
        }
        String s = ";";
        return newList.next;
    }
}

class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };
