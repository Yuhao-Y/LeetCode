import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetRandomO1
{
    /** Initialize your data structure here. */
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    java.util.Random rand = new java.util.Random();
    public InsertDeleteGetRandomO1() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;   //use the map.containsKey is much faster than list.contain
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        int lastIndex = list.size()-1;
        if(index<lastIndex){
            int newVal = list.get(lastIndex);
            list.set(index,newVal);
            map.put(newVal,index);
            index = lastIndex;
        }
        
        list.remove(index);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
