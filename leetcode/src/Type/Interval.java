package Type;

/**
 * Created by tangjialiang on 2017/9/8.
 */
public class Interval {
    public int start ;
    public int end ;
    public Interval() {start=0; end=0; }
    public Interval(int s, int e) {start=s; end=e;}

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
