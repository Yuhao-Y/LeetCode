import java.util.Arrays;

public class SolveTheEquation
{
    public String solveEquation(String equation) {
        
        String[] equations = equation.split("=");
        int[] left = sum( equations[0] );
        int[] right = sum( equations[1] );
        
        int x = left[0]- right[0];
        int value = left[1]- right[1];
        
        if(x==0&&value==0) return "Infinite solutions";
        else if (x==0&&value!=0) return "No solution";
        else return "x="+String.valueOf(0-value/x);
    }
    
    public int[] sum( String equation){
        equation = equation.replaceAll("-","+-");
        String[] elements = equation.split("\\+");
        
        int x=0, value=0;
        for(String element : elements){
            if(element.equals( "" )) continue;
            if( element.equals( "x" )||element.equals( "+x" )) x = x+1;
            else if( element.equals( "-x" )) x = x-1;
            else if(element.charAt(element.length()-1)=='x') x = x+ Integer.valueOf( element.substring( 0,element.length()-1 ));
            else value = value + Integer.valueOf( element.substring( 0,element.length() ));
        }
        
        return new int[]{x, value};
    }

    public static void main( String[] args) {
        System.out.println( new SolveTheEquation().solveEquation( "-x=-1" ) );
    }
}
