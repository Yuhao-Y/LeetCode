
public class SplitLinkedListInParts
{
    public ListNode[] splitListToParts(ListNode root, int k) {
        
        if( root == null ) return new ListNode[k];
        
        ListNode node = root;
        int length = 0;
        while( node!=null ){
            length++;
            node = node.next;
        }
        
        int size = length/k;
        int mode = length%k;
        ListNode[] res = new ListNode[k];
        
        node = root;
        for( int i=0; i<k; i++ ){
            res[i] = node;
            int listLength = i<mode?size+1:size;
            for( int j=0; j<listLength-1; j++ ){
                node = node.next;
            }
            
            if( node!=null){
                ListNode tmp = node;
                node = node.next;
                tmp.next=null;
            }
        }
        
        return res;
        
    }
}
