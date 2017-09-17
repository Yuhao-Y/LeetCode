import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals
{
    public List<Interval> merge( List<Interval> intervals )
    {
        LinkedList<Interval> result = new LinkedList<Interval>();

        //sort list firstly.
        Collections.sort( intervals, new IntervalCompartor() );

        for( Interval interval : intervals )
        {
            if( result.size() == 0 )
                result.push( interval );
            else
            {
                Interval topInterval = result.getLast();
                if( topInterval.end < interval.start )
                {
                    result.add( interval );
                }
                else
                {
                    topInterval.end = Math.max( topInterval.end, interval.end );
                }
            }
        }

        return result;
    }

    private class IntervalCompartor
        implements
        Comparator<Interval>
    {

        @Override
        public int compare( Interval o1, Interval o2 )
        {
            return o1.start - o2.start;
        }

    }

    public static void main( String[] args )
    {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add( new Interval( 1, 4 ) );
        intervals.add( new Interval( 0, 5 ) );

        System.out.println( new MergeIntervals().merge( intervals ) );
    }

}

class Interval
{
    int start;
    int end;

    Interval()
    {
        start = 0;
        end = 0;
    }

    Interval(int s, int e)
    {
        start = s;
        end = e;
    }

    public String toString()
    {
        return start + " " + end;
    }
}
