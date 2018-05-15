package zz_to_to_offer.page;

/**
 * Created by tangjialiang on 2018/2/27.
 */
public class Page64 {

    /*
    * 实现快速排序
    * */

    public static void quickSort(int[] data) {
        qsort(data, 0, data.length-1);
    }

    private static void qsort(int[] data, int start, int end) {
        if (start < end) {
            int index = partition(data, start, end);
            qsort(data, start, index-1) ;
            qsort(data, index+1, end) ;
        }
    }

    private static int partition(int[] data, int start, int end) {
        int pivot = data[start] ;

        while(start < end) {
            while(start < end && data[end] >= pivot) end-- ;
            data[start] = data[end] ;
            while(start < end && data[start] <= pivot) start++ ;
            data[end] = data[start] ;
        }

        data[start] = pivot ;
        return start ;
    }

    private static void _3qsort(int[] data, int start, int end) {
        if (start > end) return ;

        int lt = start ;
        int gt = end ;
        int i = start + 1 ;
        int qivot = data[start] ;

        while(i <= gt) {
            if (qivot < data[i]) {
                swap(data, i, gt--);
            } else if (qivot > data[i]) {
                swap(data, i++, lt++);
            } else {
                i++ ;
            }
        }

        _3qsort(data, start, lt-1);
        _3qsort(data, gt+1, end);
    }

    private static void swap(int[] data, int i, int j) {
        int tmp = data[i] ;
        data[i] = data[j] ;
        data[j] = tmp ;
    }

    public static void main(String[] args) {
        int[] data = {2, 3, 4, 5, 1, 2, 23, 42, 43, 34} ;

        Page64._3qsort(data, 0, data.length-1);

        for(Integer num : data) {
            System.out.println(num + " ") ;
        }
        System.out.println() ;
    }
}
