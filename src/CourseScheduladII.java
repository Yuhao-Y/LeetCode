import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduladII
{
     int[] findOrder(int numCourses, int[][] prerequisites) {
        
         if( numCourses == 0) return new int[]{};
    
         int[] result = new int[numCourses];
         int index = 0;
         int[] degree = new int[numCourses];
         List<Integer>[] list = new ArrayList[numCourses];
    
         for(int i=0;i<prerequisites.length;i++ ){
             if( list[prerequisites[i][1]]==null) list[prerequisites[i][1]] = new ArrayList<Integer>();
             list[prerequisites[i][1]].add(prerequisites[i][0]);
             degree[ prerequisites[i][0] ]++;
         }
    
         Queue<Integer> queue = new LinkedList<Integer>();
         for( int i=0; i< degree.length; i++){
             if( degree[i]==0){
                 queue.offer(i);
                 result[index++] = i;
             }
         }
    
        while( !queue.isEmpty()){
             int i = queue.poll();
             if(list[i]==null) continue;    // the node no out will be null in the list
             for( Integer j: list[i]){   // immediate operate the out node by use adjacency list
                 if(--degree[j] ==0 ){
                     queue.offer(j);
                     result[index++] = j;
                 }
             }
        }
    
    return index != numCourses?new int[]{}:result;
    }

}
