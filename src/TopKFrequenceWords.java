import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequenceWords
{
    public List<String> topKFrequentWithBucketSort(String[] words, int k) {
        
        List<String> res = new ArrayList<String>();
        
        if( words.length == 0 || k==0 ) return res;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for( int i=0; i < words.length; i++ ){
            map.put( words[i], map.getOrDefault( words[i],0 )+1 );
        }
        
        LinkedList<String>[] buckets = new LinkedList[words.length];
        
        for( String str : map.keySet() ) {
            
            int index = map.get( str );
            if( buckets[index] == null ) buckets[index] = new LinkedList<String>();
            buckets[index].add( str );
            
        }
        
        int i = buckets.length-1;
        while( k>0 ){
            
            while( buckets[i]==null||buckets[i].size()==0 ){
                i--;
            }
            
            if( buckets[i].size()>1 )
                Collections.sort( buckets[i] );
            
            while(buckets[i].size()>0 && k>0 ){
                res.add( buckets[i].poll() );
                k--;
            }
        }
        
        return res;
    }

    
    public List<String> topKFrequentWithTries(String[] words, int k) {
        
        List<String> res = new ArrayList<String>();
        
        if( words.length == 0 || k==0 ) return res;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for( int i=0; i < words.length; i++ ){
            map.put( words[i], map.getOrDefault( words[i],0 )+1 );
        }
        
        TriesNode[] buckets = new TriesNode[words.length];
        
        for(String str: map.keySet() ){
            
            int index = map.get( str );
            
            if( buckets[index]==null ) buckets[index] = new TriesNode();
            
            addWords( buckets[index], str, 0 );
        }
        
        for( int i = buckets.length-1; i>=0; i-- ){
            if(buckets[i] == null ) continue;
            if( res.size() == k ) break;
            getWords( buckets[i], res, k, "");
        }
        
        return res;
    }
    
    public void addWords( TriesNode node, String str, int index  ){
        
        if( index == str.length()){
            node.isWord = true;
            return;
        }
        
        if( node.children[str.charAt(index) - 'a' ] ==null)
            node.children[str.charAt(index) - 'a' ] = new TriesNode();
        
        addWords( node.children[ str.charAt(index) - 'a' ], str, index+1 );
    }
    
    public void getWords( TriesNode node, List<String> list, int k, String str ){
        
        if( node==null ) return;
        
        if( node.isWord == true )list.add(str);
        
        if( list.size() == k ) return;
        
        
        for( int i=0; i <node.children.length; i++ ){
            if( node.children[i]!=null){
                char c = (char)(i+'a');
                getWords( node.children[i], list,k , str+c );
            }
        }
    }
    
}

class TriesNode{
    
    TriesNode[] children = new TriesNode[26];
    boolean isWord = false;
    
    public TriesNode(){
        
    }
    
}
