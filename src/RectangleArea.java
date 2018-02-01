
public class RectangleArea
{
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);
        int sum = area1+area2;
        
        if(C>=E&&A<=G){
            if(B<=H&&D>=F){
                int length = Math.min(G,C)-Math.max(E,A);
                int width = Math.min(D,H)-Math.max(B,F); 
                sum -= length*width;
            }
        }
        
        return sum;
    }
}
