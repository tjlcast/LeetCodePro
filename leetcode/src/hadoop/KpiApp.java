package hadoop;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
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
public class KpiApp {
    static final String INPUT_PAHT = "hdfs://localhost:9000/wlan" ; // wlan是一个文件夹，日志文件放在/wlan下
    static final String OUTPUT_PATH = "hdfs://locaohost:9000/out" ;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        final Job job = new Job(new Configuration(),
                KpiApp.class.getName()) ;

        // 打包运行
        job.setJarByClass(KpiApp.class);

        // 1.1 指定输入文件路径
        FileInputFormat.setInputPaths(job, INPUT_PAHT);
        // 指定哪个类用来格式化输入文件
        job.setInputFormatClass(TextInputFormat.class);

        // 1.2 指定自定义的Mapper类
        job.setMapperClass(MyMapper.class);
        // 指定<k2, v2>的类型
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(KpiWritable.class);

        // 1.3 指定分区类
        job.setPartitionerClass(KpiPartitioner.class);
        job.setNumReduceTasks(2); // 分成两个区

        // 1.4 TODO 排序，分区

        // 1.5 TODO 归约

        // 2.2 指定自定义的reduce类
        job.setReducerClass(MyReducer.class);
        // 指定Reducer的输出<k3, v3>类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(KpiWritable.class);

        // 2.3 指定输出到哪里
        FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));
        // 指定输出文件的格式化类
        job.setOutputFormatClass(TextOutputFormat.class);

        // 把job提交到JobTracker运行
        job.waitForCompletion(true) ;
    }

    static class KpiPartitioner extends HashPartitioner<Text, KpiWritable> {
        @Override
        public int getPartition(Text key, KpiWritable value, int numReduceTasks) {
            return (key.toString().length() == 1L) ? 0 : 1 ; // 0 代的是手机号码 1 代表非手机号码
        }
    }

    /**
     * key      表示输入行的增量
     * value    表示输入的行
     *
     * key1     表示一个用户标志（手机或其他）
     * value1   表示一个用户的流量Kpi
     */
    static class MyMapper extends Mapper<LongWritable, Text, Text, KpiWritable> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] split = value.toString().split("\t");
            String msisdn = split[1];
            Text k2 = new Text(msisdn);
            KpiWritable kpiWritable = new KpiWritable(split[6], split[7],
                    split[8], split[9]);
            context.write(k2, kpiWritable);
        }
    }

    /**
     * k2        表示整个文件中不同的手机号码
     * v2        表示该手机号在不同时段的流量的集合
     */
    static class MyReducer extends Reducer<Text, KpiWritable, Text, KpiWritable> {
        @Override
        protected void reduce(Text key, Iterable<KpiWritable> values, Context context) throws IOException, InterruptedException {
            long upPackNum = 0L ;
            long downPackNum = 0L ;
            long upPayLoad = 0L ;
            long downPayLoad = 0L ;

            for (KpiWritable kpiWritable :
                    values) {
                upPackNum += kpiWritable.upPackNum;
                downPackNum += kpiWritable.downPackNum ;
                upPayLoad += kpiWritable.upPayLoad ;
                downPayLoad += kpiWritable.downPayLoad ;
            }

            final KpiWritable kpiWritable = new KpiWritable(upPackNum, downPackNum, upPayLoad, downPayLoad) ;
            context.write(key, kpiWritable);
        }
    }
}

class KpiWritable implements Writable {
    long upPackNum ;
    long downPackNum ;
    long upPayLoad ;
    long downPayLoad ;

    public KpiWritable() {
    }

    public KpiWritable(String upPackNum, String downPackNum, String upPayLoad, String downPayLoad) {
        this(Long.parseLong(upPackNum), Long.parseLong(downPackNum), Long.parseLong(upPayLoad), Long.parseLong(downPayLoad)) ;
    }

    public KpiWritable(long upPackNum, long downPackNum, long upPayLoad, long downPayLoad) {
        this.upPackNum = upPackNum;
        this.downPackNum = downPackNum;
        this.upPayLoad = upPayLoad;
        this.downPayLoad = downPayLoad;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.upPackNum);
        dataOutput.writeLong(this.downPackNum);
        dataOutput.writeLong(this.upPayLoad);
        dataOutput.writeLong(this.downPayLoad);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.upPackNum = dataInput.readLong() ;
        this.downPackNum = dataInput.readLong() ;
        this.upPayLoad = dataInput.readLong() ;
        this.downPayLoad = dataInput.readLong() ;
    }

    @Override
    public String toString() {
        return this.upPayLoad + "\t" + this.upPayLoad + "\t"
                + this.upPayLoad + "\t" + this.downPayLoad ;
    }
}
