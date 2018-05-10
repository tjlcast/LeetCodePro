package hadoop.removeDup;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by tangjialiang on 2018/5/2.
 */
public class DelSameMain {
    /**
     * 对于常规的App一般做下面的配置
     *
     * 1/ 配置App的JarClass
     *
     * 2/ 配置Mapper的class和其输出类型[class]
     *
     * 3/ 配置Reducer的class和其输出类型[class]
     *
     * 4/ 配置该App的输入路径和输出路径
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration() ;

        Job job = new Job(conf);
        job.setJarByClass(DelSameMain.class);

        job.setMapperClass(DelsameMap.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setReducerClass(DelsameReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.waitForCompletion(true) ;
    }
}
