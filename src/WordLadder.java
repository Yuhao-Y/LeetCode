import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        
        HashSet<String> dict = new HashSet<String>(wordList);
        LinkedList<String> history = new LinkedList<String>();
        history.add(beginWord);
        int count = 1;
        while( !history.contains(endWord)){
            for(int length = history.size();length>0;length--){
                char[] words = history.poll().toCharArray();
                for( int i=0;i<words.length;i++){
                    char tmpChar = words[i];
                    for( char j='a';j<='z';j++){
                        words[i]=j;
                        String tmp = String.valueOf(words);
                        if(dict.contains(tmp)){
                            history.add(tmp);
                            dict.remove(tmp);
                        }
                        
                    }
                    words[i] = tmpChar;
                }
                
                if(history.size()==0) return 0;

            }
            count++;
        }
        return count;
    }
    
    //find the shortest path by search from two vertex is faster than from one vertex
    public int ladderLengthWithTwoBFS(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        
        HashSet<String> dict = new HashSet<String>(wordList);
        LinkedList<String> history = new LinkedList<String>();
        LinkedList<String> endHistory = new LinkedList<String>();
        history.add(beginWord);
        endHistory.add(endWord);
        int count = 1;
        while( history.size()!=0&&endHistory.size()!=0){
            
            //swap to find the path from the side which have less vertexs
            if(history.size()>=endHistory.size()){
                LinkedList<String> tmp = history;
                history = endHistory;
                endHistory = tmp;
            }
            
            for(int length = history.size();length>0;length--){
                char[] words = history.poll().toCharArray();
                for( int i=0;i<words.length;i++){
                    char tmpChar = words[i];
                    for( char j='a';j<='z';j++){
                        words[i]=j;
                        String tmp = String.valueOf(words);
                        
                        if(endHistory.contains(tmp)) return count+1;
                        
                        if(dict.contains(tmp)){
                            history.add(tmp);
                            dict.remove(tmp);
                        }
                        
                    }
                    words[i] = tmpChar;
                }
                
                if(history.size()==0) return 0;

            }
            count++;
        }
        return count;
    }
    
    public static void main( String[] args) {
        List<String> list = new ArrayList<String>();
        list.add( "hot" );
        list.add( "dog" );
        list.add( "dot" );
        
        System.out.println( new WordLadder().ladderLength( "hot", "dog", list ) );
        
    }
}
