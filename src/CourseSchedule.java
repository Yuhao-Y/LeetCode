import java.util.LinkedList;

public class CourseSchedule
{
    //topological sorting
    public boolean canFinish( int numCourses, int[][] prerequisites )
    {
        int[][] adjacencyMatric = new int[numCourses][numCourses];
        int[] courseInDegree = new int[numCourses];

        for( int i = 0; i < prerequisites.length; i++ )
        {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if(adjacencyMatric[ready][pre]==0)
                courseInDegree[pre]++;
            adjacencyMatric[ready][pre] = 1;
        }
    
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for( int i = 0; i < courseInDegree.length; i++ )
        {
            if( courseInDegree[i] == 0 )
                queue.add( i );
        }

        int count = 0;
        while( queue.size() != 0 )
        {
            int vertical = queue.poll();
            count++;
            for( int i = 0; i < numCourses; i++ )
            {
                if( adjacencyMatric[vertical][i] !=0 )
                {
                    if( (--courseInDegree[i]) == 0 )
                    {
                        queue.add( i );
                    }
                }
            }
        }

        return count == numCourses;
    }
    
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if(prerequisites==null) return false;
        
        int[][] adjacencyMatrices = new int[numCourses][numCourses];
        for(int i=0;i<prerequisites.length;i++){
            adjacencyMatrices[prerequisites[i][0]][prerequisites[i][1]]=1;
        }
        
        for( int i=1,j=2;i<prerequisites.length;i++,j++){
            if(adjacencyMatrices[prerequisites[i][0]][prerequisites[i][1]]!=1) continue;
            
            adjacencyMatrices[prerequisites[i][0]][prerequisites[i][1]] = j;
            
            if(!dfs(prerequisites[i][1],j,adjacencyMatrices)) return false;
            
        }
        
        return true;
    }
    
    private boolean dfs( int endPoint, int flag, int[][] adjacencyMatrices){
        for( int i=0;i<adjacencyMatrices.length;i++){
            if(adjacencyMatrices[endPoint][i]==flag) return false;
            
            if(adjacencyMatrices[endPoint][i]==0||adjacencyMatrices[endPoint][i]!=1) continue;
            
            adjacencyMatrices[endPoint][i]=flag;
            
            if(!dfs(i,flag,adjacencyMatrices)) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
    }
}
