package TheSmartUtils;

/**
 * Created by tangjialiang on 2018/1/30.
 */
public class BigHeap {
    final static int DEFAULT_CAPACITY = 10001 ;

    int capacity ;
    int size ;
    int[] datas ;

    public BigHeap() {
        capacity = DEFAULT_CAPACITY ;
        size = 0 ;
        datas = new int[capacity] ;
    }

    public BigHeap(int[] input_datas) {
        capacity = DEFAULT_CAPACITY ;
        size = input_datas.length ;
        datas = new int[capacity] ;

        for(int pos=input_datas.length-1; pos>=0; pos--) {
            datas[pos+1] = input_datas[pos] ;
            adjustDown(pos+1);
        }
    }

    public void add(int value) {
        if (size >= capacity) return ;

        datas[++size] = value ;
        for(int pos=size; pos>0; pos/=2) {
            adjustDown(pos);
        }
    }

    public int remove() {
        if (size <= 0) return -1 ;

        int val = datas[1] ;
        datas[1] = datas[size--] ;
        adjustDown(1) ;

        return val;
    }

    public void adjustDown(int pos) {
        datas[0] = datas[pos] ;

        for(int childPos=pos*2; childPos<=size; childPos++) {
            if (childPos+1<size && datas[childPos+1]>datas[childPos]) childPos++ ;

            if (datas[pos] < datas[childPos]) {
                datas[pos] = datas[childPos] ;
                pos = childPos ;
            } else {
                break ;
            }
        }
        datas[pos] = datas[0] ;
    }

    public static void main(String[] args) {
        int[] datas = {4, 5, 2, 1} ;
        BigHeap sh = new BigHeap(datas) ;

        System.out.println("smallheap test") ;

        while(sh.size != 0) {
            int remove = sh.remove();
            System.out.println(remove) ;
        }

        System.out.println("the heap is empty") ;

        sh.add(9);
        sh.add(23) ;

        System.out.println(sh.remove()) ;

        sh.add(8) ;

        System.out.println(sh.remove()) ;
        System.out.println(sh.remove()) ;

        System.out.println(sh.size) ;
    }
}
