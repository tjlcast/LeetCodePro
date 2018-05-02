package hadoop.SortData;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by tangjialiang on 2018/5/2.
 */
public class SortMap extends Mapper<LongWritable, Text, IntWritable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString() ;
        if (line.length() > 0) {
            context.write(new IntWritable(Integer.parseInt(line.trim())),
                    new Text(""));
        }
    }
}
