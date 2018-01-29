package MulitThreads.fork_join;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by tangjialiang on 2018/1/29.
 */
public class SumTask extends RecursiveTask<Long> {

    static final int THRESHOLD = 100 ;
    long[] arry ;
    int start ;
    int end ;

    public SumTask(long[] array, int start, int end) {
        this.arry = array ;
        this.start = start ;
        this.end = end ;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // the task is small, doesn't need multiThread.
            long sum = 0 ;
            for(int i=start; i<end; i++) {
                sum += arry[i] ;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            System.out.println(String.format("compute %d-%d = %d", start, end, sum)) ;
            return sum ;
        }

        int middle = (start + end) / 2 ;
        System.out.println(String.format("split %d-%d ===> %d-%d, %d-%d", start, end, start, middle, middle, end)) ;


        SumTask subTask1 = new SumTask(this.arry, start, middle) ;
        SumTask subTask2 = new SumTask(this.arry, middle, end) ;
        invokeAll(subTask1, subTask2);

        // wait sub task finish !!
        Long subTask1Result = subTask1.join();
        Long subTask2Result = subTask2.join();
        Long result = subTask1Result + subTask2Result ;
        System.out.println(String.format("%d-%d result is: %d", start, end, result)) ;
        return result ;
    }

    public static void main(String[] args) {
        long[] array = new long[1000] ;
        array = fillRandom(array) ;

        ForkJoinPool fjp = new ForkJoinPool() ;
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length) ;

        // count runtime
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis() ;

        // show result
        System.out.println("Fork/Join sum: " + result + " in " + (endTime-startTime) + " ms.");
    }

    public static long[] fillRandom(long[] array) {
        Random random = new Random() ;
        return Arrays.stream(array).map(e -> random.nextLong()).toArray() ;
    }
}
