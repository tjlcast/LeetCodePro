package Utils;

import java.util.Vector;

/**
 * Created by tangjialiang on 2017/8/28.
 */

public class SortUtils {

    public static void main(String[] args) {
        //int[] arrs = {3, 2, 1, 4, 5, 6, 7} ;
        int[] arrs = {20, 17, 8, 7, 16, 3} ;
        SmallHeap bigHeap = new SmallHeap(arrs);
        bigHeap.show();
        bigHeap.add(10) ;
        bigHeap.show();
        int remove = bigHeap.remove();
        bigHeap.show();
        System.out.print(remove);
    }

    /**
     * 对数组进行分段操作，start与end为闭区间
     * @return 最后放置的下标
     */
    public static int partition(int[] nums, int start, int end) {
        int l = start ;
        int r = end ;
        int flag = nums[start] ;

        while(l < r) {
            while(l < r && nums[r] >= flag) r-- ;
            nums[l] = nums[r] ;
            while(l < r && nums[l] <= flag) l++ ;
            nums[r] = nums[l] ;
        }

        nums[l] = flag ;
        return l ;
    }

    /**
     * 快排
     * @param nums
     */
    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) return ;

        int partition = partition(nums, start, end);
        quickSort(nums, start, partition-1);
        quickSort(nums, partition+1, end);
    }
}


/**
 * 堆的接口
 */
interface Heap {
    public void add(int i) ;

    public int remove() ;
}


/**
 * 小根堆
 * 注意：对接口的操作均为数据序号
 */
class SmallHeap implements Heap {
    private Vector<Integer> datas = null ;
    private int k = -1 ;

    public SmallHeap (int k) {
        this.k = k ;
        datas = new Vector<>(k) ;
    }

    public SmallHeap(int[] datas) {
        this.k = datas.length ;
        this.datas = new Vector<>(k) ;
        for(int data: datas) {
            this.datas.add(data) ;
        }

        for (int order=k; order>0; order--) {
            adjust(order);
        }
    }

    private void adjust(int pos) {
        if (pos > datas.size()) return ;

        int val = datas.get(pos - 1) ;
        int leftVal = (pos*2 > k) ? (Integer.MAX_VALUE) : (datas.get(pos*2 - 1)) ;
        int rightVal = (pos*2+1 > k) ? (Integer.MAX_VALUE) : (datas.get(pos*2+1 - 1)) ;

        int minVal = (leftVal < rightVal) ? (leftVal) : (rightVal) ;
        int minPos = (leftVal < rightVal) ? (pos*2) : (pos*2+1) ;

        if ((minVal!=Integer.MAX_VALUE) && (minPos<=k) && (val>minVal)) {
            datas.set(pos - 1, minVal) ;
            datas.set(minPos - 1, val) ;

            adjust(minPos);
        }
    }

    public void show() {
        for(int i: this.datas) {
            System.out.print(i + " ");
        }
        System.out.println() ;
    }

    @Override
    public void add(int i) {
        int num = i ;

        this.datas.add(num) ;
        int order = datas.size() ;
        while(order > 1) {
            adjust(order);
            order = order / 2;
        }
    }

    @Override
    public int remove() {
        if (datas.size() == 0) throw new ArrayIndexOutOfBoundsException() ;

        Integer integer = datas.get(0);
        int lastNum = datas.get(datas.size() - 1);
        datas.remove(datas.size() - 1) ;

        datas.set(0, lastNum) ;
        adjust(1);

        return integer;
    }
}


/**
 * 大根堆
 * 注意：接口的操作均为数据序号
 */
class BigHeap implements Heap{
    private Vector<Integer> datas = null ;
    private int k = -1 ;

    public BigHeap(int k) {
        this.k = k ;
        datas = new Vector<>(k) ;
    }

    public BigHeap(int[] datas) {
        this.k = datas.length ;
        this.datas = new Vector<Integer>(this.k) ;
        for(int data: datas) {
            this.datas.add(data) ;
        }

        // from leaves to root adust each node.
        for(int i=this.datas.size(); i>=1; i--) {
            adjust(i); ;
        }
    }

    /**
     * 递归调整以pos为根的子树
     * @param pos: the 'pos' is order
     */
    private void adjust(int pos) {
        if (pos > datas.size()) return ;

        int val = datas.get(pos-1) ;
        int leftVal = (pos*2 > datas.size()) ? (Integer.MIN_VALUE) : (datas.get(pos*2 - 1)) ;
        int rightVal = (pos*2+1 > datas.size()) ? (Integer.MIN_VALUE) : (datas.get(pos*2+1 - 1)) ;

        int maxVal = (leftVal > rightVal) ? (leftVal) : (rightVal) ;
        int maxPos = (leftVal > rightVal) ? (pos * 2) : (pos * 2 + 1) ;

        if ((maxVal!=Integer.MIN_VALUE) && (val < maxVal) && maxPos <= datas.size()) {
            // do swap and adjust children
            int swap = datas.get(pos- 1) ;
            datas.set(pos - 1, maxVal) ;
            datas.set(maxPos - 1, swap) ;

            adjust(maxPos);
        }

    }

    public void show() {
        System.out.println("datas: ") ;
        for(int i: this.datas) {
            System.out.print(i + " ") ;
        }
        System.out.println() ;
    }

    /**
     * 向大根堆增加元素
     * @param i
     */
    @Override
    public void add(int i) {
        int num = i ;

        datas.add(num) ;
        int order = datas.size() ;
        while(order > 1) {
            adjust(order);
            order = order / 2 ;
        }
    }

    /**
     * 返回并删除大根堆最大值
     * @return
     */
    @Override
    public int remove() {
        if (datas.size()==0) throw new ArrayIndexOutOfBoundsException() ;

        int num = datas.get(0) ;
        int lastNum = datas.get(datas.size() - 1);
        datas.remove(datas.size()-1) ;
        datas.set(0, lastNum) ;
        adjust(1);

        return num;
    }
}
