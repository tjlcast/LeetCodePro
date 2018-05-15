package hadoop.SortData;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by tangjialiang on 2018/5/2.
 */
public class SortedReducer extends Reducer<IntWritable, Text, IntWritable, IntWritable> {
    private IntWritable num = new IntWritable(1) ;

    @Override
    protected void reduce(IntWritable key, Iterable<Text> values,
                          Reducer<IntWritable, Text, IntWritable, IntWritable>.Context context) throws IOException, InterruptedException {
        for (Text text :
                values) {
            context.write(num, key);
            num = new IntWritable(num.get() + 1) ;
        }
    }
}
