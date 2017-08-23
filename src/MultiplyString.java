
public class MultiplyString
{
    public String multiply( String num1, String num2 )
    {
        if( num1.equals( "0" ) || num2.equals( "0" ) )
        {
            return "0";
        }

        String result = "";
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        int[] resultDigital = new int[num1Array.length + num2Array.length];
        for( int i = num1Array.length - 1; i >= 0; i-- )
        {
            for( int j = num2Array.length - 1; j >= 0; j-- )
            {
                int num1Index = Character.getNumericValue( num1Array[i] );
                int num2Index = Character.getNumericValue( num2Array[j] );
                int digitalIndex = num1Array.length - 1 - i + num2Array.length - 1 - j;
                resultDigital[digitalIndex] = resultDigital[digitalIndex] + num1Index * num2Index;

                if( resultDigital[digitalIndex] > 9 )
                {
                    resultDigital[digitalIndex + 1] = resultDigital[digitalIndex + 1]
                        + resultDigital[digitalIndex] / 10;
                    resultDigital[digitalIndex] = resultDigital[digitalIndex] % 10;
                    digitalIndex++;
                }
            }
        }

        for( int digital : resultDigital )
        {
            result = digital + result;
        }

        return result.substring( 0, 1 ).equals( "0" ) ? result.substring( 1 ) : result;
    }

    public static void main( String[] args )
    {
        MultiplyString m = new MultiplyString();
        System.out.println( m.multiply( "7967", "7067" ) );
    }
}
