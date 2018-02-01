import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList
{
    //N is the total numbers of nodes, k is the length of lists
    
    //O(NK)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1) return lists[0];
        ListNode head = new ListNode(1);
        int min = -1;
        ListNode current = head;
        
        do{
            min = -1;            
            for( int i=0;i<lists.length;i++){
                if(lists[i]!=null){
                    if(min<0) min = i;
                    else{
                        if(lists[i].val<lists[min].val) min = i;
                    }
                }
            }
            
            if(min>=0){
                current.next = lists[min];
                current = current.next;
                if(lists[min]!=null) lists[min]=lists[min].next;
            }
            
        }while(min>=0);
        
        return head.next;
    }
    
    //O(NlogK)
    public ListNode mergeKListsQueue(ListNode[] lists) {
        if(lists==null|| lists.length==0) return null;
        if(lists.length==1) return lists[0];
        
        ListNode head = new ListNode(1);
        ListNode current = head;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            
            @Override
            public int compare(ListNode n1,ListNode n2){
                if(n1.val<n2.val){
                    return -1; 
                }else{
                    return 1;
                }
            }
        });
        
        for( int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                queue.add(lists[i]);
        }
        
        while(!queue.isEmpty()){
            current.next = queue.poll();
            current = current.next;
            
            if(current.next!=null){
                queue.add(current.next);
            }
        }
        
        return head.next;
    }
    
    
    //O(NlogK)
    //Divide the lists need logK times
    // n is the length of each list in lists
    // for the last round: the time of merge is k/2, and the time of each compare n*2, so total times is nk=N
    // for the last but one round: the time of merge is k/4, and the time of each compare n*4, so total times is nk=N
    // the number of all round the logK, so the total time is nklogK = NlogK
    public ListNode mergeKListsMergeSort(ListNode[] lists) {
        if(lists==null|| lists.length==0) return null;
        if(lists.length==1) return lists[0];
        
        return mergeList(lists,0,lists.length-1);
    }
    
    public ListNode mergeList(ListNode[] lists, int lo, int hi){
        if(lo == hi) return lists[lo];
        
        int mid = lo+(hi-lo)/2;
        
        ListNode left = mergeList(lists, lo,mid);
        ListNode right = mergeList(lists, mid+1,hi);
        return mergeTwoLists(left,right);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        if(l1.val<=l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
