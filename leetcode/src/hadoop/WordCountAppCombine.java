package hadoop;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

/**
 * Created by tangjialiang on 2018/3/29.
 */

 /**
 17  * 问：为什么使用Combiner？
 18  * 答：Combiner发生在Map端，对数据进行规约处理，数据量变小了，传送到reduce端的数据量变小了，传输时间变短，作业的整体时间变短。
 19  *
 20  * 问：为什么Combiner不作为MR运行的标配，而是可选步骤呢？
 21  * 答：因为不是所有的算法都适合使用Combiner处理，例如求平均数。
 22  *
 23  * 问：Combiner本身已经执行了reduce操作，为什么在Reducer阶段还要执行reduce操作呢？
 24  * 答：combiner操作发生在map端的，处理一个任务所接收的文件中的数据，不能跨map任务执行；只有reduce可以接收多个map任务处理的数据。
 25  *
 26  */

public class WordCountAppCombine {

    public static String INPUT_PATH = "" ;
    public static String OUTPUT_PATH = "" ;

    public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        final FileSystem fileSystem = FileSystem.get(new URI(INPUT_PATH), conf) ;
        final Path outPath = new Path(OUTPUT_PATH) ;
        if (fileSystem.exists(outPath)) {
            fileSystem.delete(outPath, true) ;
        }

        // 0.0 创建任务对象
        final Job job = new Job(conf,
                WordCountApp.class.getName()) ;

        job.setJarByClass(WordCountApp.class);

        // 1.1 指定读取的文件位置
        FileInputFormat.setInputPaths(job, INPUT_PATH);
        // 指定输入文件的格式化类
        // job.setInputFormatClass(TextInputFormat.class);

        // 1.2 指定自定义的map
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        // 1.3 分区
        // job.setPartitionerClass(HashPartitioner.class);
        // 有一个分区
        // job.setNumReduceTasks(1);

        // 1.4 TODO 排序、分组

        // 1.5 规约
        job.setCombinerClass(MyCombiner.class);
        // 指定相关的输出<k, v>类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 2.2 指定自定义reduce类
        job.setReducerClass(MyReducer.class);
        // 指定Reducer的输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 2.3 指定写出到哪里
        FileOutputFormat.setOutputPath(job, outPath);
        // 指定最终输入文件格式类
        job.setOutputFormatClass(TextOutputFormat.class);

        // 把job提交到jobtracker运行
        job.waitForCompletion(true) ;
    }

    static class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] split = value.toString().split("\t");
            for (String word :
                    split) {
                context.write(new Text(word), new LongWritable(1));
            }
        }
    }

    static class MyReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
            Long times = 0L ;
            for (LongWritable i :
                    values) {
                times += i.get() ;
            }
            context.write(key, new LongWritable(times));
        }
    }

    static class MyCombiner extends Reducer<Text, LongWritable, Text, LongWritable> {
        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
            long times = 0L ;
            for (LongWritable time :
                    values) {
                times += time.get() ;
            }
            context.write(key, new LongWritable(times));
        }
    }
}
