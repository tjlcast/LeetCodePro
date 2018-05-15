package zz_to_offer;

import Utils.SortUtils;

/**
 * Created by tangjialiang on 2017/8/28.
 */
public class Page_163 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2} ;
        int work = new Page_163().work(nums, nums.length);
        System.out.println("work is: " + work) ;
    }

    public int work(int[] nums, int length) {
        return new MySolution1().moreThanHalfNum(nums, length) ;
    }

    class MySolution {
        /**
         * 保存两个值：一个是数组中的一个数字，一个是次数。当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的
         * 数字相同，则次数加一；如果下一数字和之前保存的数字不同，则次数减1。如果次数为0，需要保存下一个数字，并把次数设为1。
         */
        public int moreThanHalfNum(int[] nums, int length) {
            int val = -1 ;
            int times = 0 ;
            for(int i=0; i<length; i++) {
                if (times == 0) {
                    val = nums[i] ;
                    continue;
                }
                if (val == nums[i]) {
                    times += 1 ;
                } else {
                    times -= 1 ;
                }
            }
            return val ;
        }
    }

    class MySolution1 {
        /**
         * 使用快排的Partition的方法
         * @return
         */
        public int moreThanHalfNum(int[] nums, int len) {
            int mid = (0 + nums.length-1) / 2 ;
            int i = find(nums, 0, nums.length - 1, mid);
            return i;
        }

        /**
         * @param nums datas
         * @param start inclusive
         * @param end inclusive
         * @return
         */
        private int find(int[] nums, int start, int end, int mid) {
            System.out.println("s: " + start + " end: " + end + " mid: " + mid) ;

            int l = SortUtils.partition(nums, start, end) ;
            int flag = nums[l] ;

            if (l == mid) return flag ;

            if (l < mid) return find(nums, l+1, end, mid) ;
            else return find(nums, start, l-1, mid) ;
        }
    }
}
