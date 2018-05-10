package TheSmartUtils;

import java.util.Arrays;

/**
 * Created by tangjialiang on 2018/1/30.
 */
public class SmallHeap {
    int capacity ;
    int size ;
    int datas[] ;

    public SmallHeap(int size) {
        this.capacity = size+1 ;
        this.size = 0 ;
        datas = new int[capacity] ;
    }

    public SmallHeap(int[] datas) {
        this.capacity = datas.length+1 ;
        this.size = datas.length ;
        this.datas = new int[this.capacity] ;

        for(int i=datas.length-1; i>=0; i--) {
            this.datas[i+1] = datas[i] ;
            adjuestDown(i+1);
        }
    }

    private void build() {
        for(int pos=size; pos>0; pos--) {
            adjuestDown(pos);
        }
    }

    private void adjuestDown(int pos) {
        datas[0] = datas[pos] ;

        for(int childPos=pos*2; childPos<=this.size; childPos*=2) {
            if (childPos+1<=this.size && datas[childPos]>datas[childPos+1]) childPos+=1 ;

            if (datas[0] > datas[childPos]) {
                datas[pos] = datas[childPos] ;
                pos = childPos ;
            } else {
                break ;
            }
        }
        datas[pos] = datas[0] ;
    }

    public void add(int val) {
        // add the val to the last position
        if (size >= capacity) {
            return ;
        }

        datas[++size] = val ;
        int pos = size ;

        while(pos != 0) {
            adjuestDown(pos);
            pos = pos / 2 ;
        }
    }

    public int remove() {
        if (size <= 0) {
            return -1 ;
        }

        int val = datas[1] ;
        datas[1] = datas[size--] ;

        adjuestDown(1);
        return val ;
    }


    public static void main(String[] args) {
        int[] datas = {4, 5, 2, 1} ;
        SmallHeap sh = new SmallHeap(datas) ;

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
