
public class ImplementTrie
{
    class TreeNode{
        public char value;
        public boolean isWord=false;
        public TreeNode[] children = new TreeNode[26];
        public TreeNode( char c)
        {
            value = c;
        }
    }
    
    private TreeNode root;
    /** Initialize your data structure here. */
    public ImplementTrie()
    {
        root = new TreeNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert( String word )
    {
        TreeNode t = root;
        char[] wordArray = word.toCharArray();
        for( int i=0;i<word.length();i++)
        {
            if(t.children[wordArray[i]-'a']==null)
            {
                t.children[wordArray[i]-'a'] = new TreeNode(wordArray[i]);
            }
            t = t.children[wordArray[i]-'a'];
        }
        t.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search( String word )
    {
        TreeNode t = root;
        char[] wordArray = word.toCharArray();
        for( int i=0;i<word.length();i++)
        {
            if(t.children[wordArray[i]-'a']==null)
            {
                return false;
            }
            t = t.children[wordArray[i]-'a'];
        }
        return t.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith( String prefix )
    {
        TreeNode t = root;
        char[] wordArray = prefix.toCharArray();
        for( int i=0;i<prefix.length();i++)
        {
            if(t.children[wordArray[i]-'a']==null)
            {
                return false;
            }
            t = t.children[wordArray[i]-'a'];
        }
        return true;
    }
}
