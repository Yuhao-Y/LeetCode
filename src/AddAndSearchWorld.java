
public class AddAndSearchWorld
{
    /** Initialize your data structure here. */
    class TrieNode {
        char value;
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
        public TrieNode( char value){
            this.value = value;
        }
    }
    
    TrieNode root;
    
    public AddAndSearchWorld() {
        root = new TrieNode(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
        TrieNode node = root;
        char[] wordArray = word.toCharArray();
        
        for( int i=0; i<word.length(); i++){
            
            if( node.children[wordArray[i]-'a']==null){
                node.children[wordArray[i]-'a'] = new TrieNode(wordArray[i]);
            }
            
            node = node.children[wordArray[i]-'a'];
            
        }
        
        node.isEnd = true;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
        TrieNode node = root;
        return dfs( node, word.toCharArray(), 0);
        
    }
    
    public boolean dfs( TrieNode node, char[] wordArray, int index){
        
        if( node==null || index>wordArray.length) return false;
        
        if( index == wordArray.length) {
            if(node.isEnd) return true;
            else return false;
        }
        
        if(wordArray[index]!='.'){
            if(node.children[wordArray[index]-'a'] ==null){
                return false;
            }
            else{ 
                if(dfs( node.children[wordArray[index]-'a'], wordArray, index+1)) 
                    return true;
            }
        }else{
            for( int i=0; i<node.children.length; i++ ){
                if(dfs( node.children[i], wordArray, index+1)) return true;
            }
        }
        
        return false;
    }
}
