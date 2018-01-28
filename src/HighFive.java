import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, PriorityQueue<Integer>> list = new HashMap<Integer, PriorityQueue<Integer>>();
        
        
        for(int i=0;i<results.length;i++){
            if(!list.containsKey(results[i].id)){
                list.put(results[i].id,new PriorityQueue(5, new Comparator<Integer>(){
                    public int compare( Integer o1, Integer o2){
                        if(o1<o2) return -1;
                        else return 1;
                        }
                }));
            }
            
            list.get(results[i].id).add(results[i].score);
            
            if(list.get(results[i].id).size()>5){
                list.get(results[i].id).poll();
            }
            
        }
        
        Map<Integer, Double> result = new HashMap<Integer, Double>();
        for(Integer  id: list.keySet()){
            double sum = 0;
            for( Integer score:list.get(id)){
                sum+=score;
            }
            result.put(id,sum/list.get(id).size());
        }
        
        return result;
        
    }
    
    public static void main( String[] args) {
        
        Record[] records = new Record[6];
        records[0] = new Record(0,99);
        records[1] = new Record(0,99);
        records[2] = new Record(0,99);
        records[3] = new Record(0,99);
        records[4] = new Record(0,99);
        records[5] = new Record(0,90);
        
        System.out.println( new HighFive().highFive( records ) );
    }

}

class Record {
     public int id, score;
     public Record(int id, int score){
         this.id = id;
         this.score = score;
     }
}