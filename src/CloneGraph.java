import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph
{
    public UndirectedGraphNode cloneGraph( UndirectedGraphNode node )
    {
        // write your code here
        if( node == null )
            return null;
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();

        UndirectedGraphNode newNode = new UndirectedGraphNode( node.label );
        //set.add(node);
        dfs( node, newNode, set );
        
        return newNode;
    }

    public void dfs( UndirectedGraphNode node, UndirectedGraphNode newNode, HashSet<UndirectedGraphNode> set )
    {
        if( node == null )
            return;
        
        if(set.contains( node )) return;
        
        set.add( node );
        for( UndirectedGraphNode temp : node.neighbors )
        {
            UndirectedGraphNode newNeighbor = new UndirectedGraphNode( temp.label );
            newNode.neighbors.add( newNeighbor );
            //if(!set.contains(node)){
            //set.add(temp);
            //if(temp!=node)
            dfs( temp, newNeighbor, set );
            //}
        }

        return;
    }
    
    public UndirectedGraphNode bfs( UndirectedGraphNode node ){
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while(queue.size()!=0){
            UndirectedGraphNode tmpe = queue.poll();
            if(!map.containsKey(tmpe.label)){
                map.put(tmpe.label,new UndirectedGraphNode(tmpe.label));
            }
            for(UndirectedGraphNode neighbor:tmpe.neighbors ){
                if(map.containsKey(neighbor.label)){
                    map.get(tmpe.label).neighbors.add(map.get(neighbor.label));
                }else{
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                    map.get(tmpe.label).neighbors.add(newNode);
                    map.put(newNode.label,newNode);
                    queue.add(neighbor);
                }
            }
        }
        return map.get(node.label); 
    }
}

class UndirectedGraphNode
{
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x)
    {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
