
public class ExpressionAddOperator
{
    
    public int evalMethod( String exp ) {
        if( exp == null || exp.length()<=0 ) return 0;
        
        char[] expression = exp.toCharArray();
        
        for( int i = 0; i < expression.length ; i++) {
            
            
            
        }
        
        return 0;
    }
    
    String[] operator = new String[]{"","+","-"};
    
    public int expressionAddOperator( String str, int target ) {
        
        if( str == null || str.length()<=0 ) return 0;
        
        return helper( str.toCharArray(), "", 0, target );
    }
    
    public int helper( char[] str, String res, int index, int target ) {
        int count = 0;
        if( index == str.length-1) {
            res+=str[index];
            System.out.println(  res  );
            if( evalMethod( res )==target) count++;
            if( evalMethod( "-"+res ) == target ) count++;
            return count;
        }
        
        res +=str[index];
        
        for( int i=0; i< operator.length ; i++) {
            count += helper( str, res+operator[i], index+1, target);
        }
        
        return count;
    }
    
    public static void main( String[] args ) {
        
        System.out.println( new ExpressionAddOperator().expressionAddOperator( "123", 6 ) );
    }
}
