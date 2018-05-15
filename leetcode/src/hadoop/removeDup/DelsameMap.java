package hadoop.removeDup;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by tangjialiang on 2018/5/2.
 */
public class DelsameMap extends Mapper<LongWritable, Text, Text, Text>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.length() > 0) {
            context.write(new Text(line.trim()), new Text(""));
        }
    }
}
