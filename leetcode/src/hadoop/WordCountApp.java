package hadoop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * Created by tangjialiang on 2018/3/29.
 */
public class WordCountApp {
    static String INPUT_PATH = "hdfs://localhost:9000/hello" ;
    static String OUTPUT_PATH = "hdfs://localhost:9000/out" ;

    public static void main(String[] args) throws URISyntaxException, IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration() ;
        FileSystem fileSystem = FileSystem.get(new URI(INPUT_PATH), conf) ;
        Path outPath = new Path(OUTPUT_PATH) ;
        if (fileSystem.exists(outPath)) {
            fileSystem.delete(outPath, true) ;
        }

        Job job = new Job(conf, WordCountApp.class.getSimpleName()) ;

        // 1.1 指定读取的文件位置
        FileInputFormat.setInputPaths(job, INPUT_PATH) ;
        // 指定如何对输入的文件进行格式化，把输入文件每一行解析为键值对
        // job.setInputFormatClass(TextInputFormat.class) ;

        // 1.2 指定自定义的map类
        job.setMapperClass(MyMapper.class);
        // map输出的<k,v>类型，如果<k3,v3>的类型与<k2,v2>的类型一直，则可以忽略
        // job.setOutpputKeyClass(Text.class) ;
        // job.setOutputValueClass(LongWritable.class) ;

        // 1.3 分区
        // job.setPartitionerClass(org.apache.hadoop.mapreduce.lib.partition.HashPartitioner.class)
        // 第一个reduce任务运行
        // job.setNumReduceTasks(1) ;

        // 1.4 排序，分组

        // 1.5 归约

        // 2.2 指定自定义reduce类
        job.setReducerClass(MyReducer.class) ;
        // 指定reduce的输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 2.3指定写出到哪里
        FileOutputFormat.setOutputPath(job, outPath);
        // 指定输出文件的格式化类
        //job.setOutputFormatClass(TextOutputFormat.class);

        // 把job提交给jobtracker运行
        job.waitForCompletion(true) ;
    }

    /**
     * key1:    表示mapper输入的偏移量
     * value1:  表示行文本内容
     * key2:    表示行中出现的单词
     * value2:  表示行中出现的单词的次数
     */
    static class MyMapper extends
            Mapper<LongWritable, Text, Text, LongWritable> {
        @Override
        protected void map(LongWritable key1, Text value1, Context context) throws IOException, InterruptedException {
            String[] splited = value1.toString().split("\t") ;
            for (String word :
                    splited) {
                context.write(new Text(word), new LongWritable(1));
            }
        }
    }

    /**
     * key2:    表示文本中的单词
     * value2:  表示文本中单词的次数
     * key3:    表示行中出现不同的单词
     * value3:  表示行中出现不同单词的总次数
     */
    static class MyReducer extends
            Reducer<Text, LongWritable, Text, LongWritable> {
        @Override
        protected void reduce(Text key2, Iterable<LongWritable> values2, Context context) throws IOException, InterruptedException {
            Long times = 0L ;
            for (LongWritable count :
                    values2) {
                times += count.get();
            }
            context.write(key2, new LongWritable(times));
        }
    }
}
