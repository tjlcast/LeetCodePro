package zz_to_offer;

import Utils.SortUtils;
import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by tangjialiang on 2017/8/28.
 */
public class Page_167 {
    public static void main(String[] args) {
        //int[] arrs = {1, 2, 3, 4, 5, 6, 7, 8} ;
        int[] arrs = {6, 7, 8, 1, 2, 3, 4, 5} ;
        int k = 3 ;

        int[] work = new Page_167().work(arrs, k);

        for(int i: work) {
            System.out.println(i) ;
        }
    }

    public int[] work(int[] nums, int k) {
        return new MySolution().getLeastNumbers(nums, k) ;
    }

    class MySolution {
        int[] getLeastNumbers(int[] nums, int k) {
            int l = 0 ;
            int r = nums.length-1 ;
            int partition = SortUtils.partition(nums, l, r);

            while(partition != k-1) {
                if (partition > k-1) {
                    partition = SortUtils.partition(nums, l, partition-1) ;
                } else {
                    partition = SortUtils.partition(nums, partition+1, r) ;
                }
            }

            // partition == k-1
            int[] ints = Arrays.copyOf(nums, k);
            return ints ;
        }
    }

    class MySolution1 {

        class KSet {
            private int k = -1 ;
            private TreeSet set = null ;

            public KSet(int k) {
                this.k = k ;
                set = new TreeSet() ;
            }

            public void add(int i) {
                if (set.size() == k) {
                    set.pollFirst() ;
                }
                set.add(i) ;
            }

            public int[] getAll() {
                int[] arrs = new int[set.size()] ;
                Object[] objects = set.toArray();
                for(int i=0; i<arrs.length; i++) {
                    arrs[i] = (Integer) objects[i] ;
                }
                return arrs ;
            }
        }

        int[] getLeastNumbers(int[] nums, int k) {
            KSet kSet = new KSet(k);
            for(int i : nums) {
                kSet.add(i) ;
            }

            int[] all = kSet.getAll();

            return all ;
        }
    }
}
