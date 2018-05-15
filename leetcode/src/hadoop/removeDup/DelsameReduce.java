package hadoop.removeDup;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import javax.xml.soap.Text;
import java.io.IOException;

/**
 * Created by tangjialiang on 2018/5/2.
 */
public class DelsameReduce extends Reducer<Text, Text, Text, NullWritable>{
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        context.write(key, NullWritable.get());
    }
}
