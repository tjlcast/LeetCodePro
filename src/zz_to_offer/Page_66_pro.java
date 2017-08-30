package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/22.
 */
public class Page_66_pro {
    /**
     * 在旋转数组里找到指定的数字。
     */
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 8, 1, 2, 3} ;
        int k = 1 ;
        int work = new Page_66_pro().work(nums, k, 0, nums.length - 1);
        System.out.println("work is: " + work) ;
    }

    public int work(int[] nums, int k, int begin, int end) {
        return new MySolution().findNumFromInput(nums, k, begin, end) ;
    }

    class MySolution {
        /**
         * if containing return the postition, otherwise return -1
         * tips: 注意，在进行数据段选择时，优先对旋转数组的形状进行判断，即比较数据段的第一个元素nums[start]与中间的元素nums[mid].
         */
        public int findNumFromInput(int[] nums, int k, int begin, int end) {
            int mid = (begin + end) / 2 ;
            int midNum = nums[mid] ;

            if (midNum == k) return mid ;
            if (begin == end) return -1 ;

            if (midNum >= nums[begin]) {
                if (k > midNum || k < nums[begin]) {
                    return findNumFromInput(nums, k, mid+1, end) ;
                } else {
                    // use bSearch find [begin, mid)
                    return bSearch(nums, k, begin, mid-1) ;
                }
            } else {
                if (k < midNum || k > nums[end]) {
                    return findNumFromInput(nums, k, begin, mid-1) ;
                } else {
                    // use bSearch find (mid, end]
                    return bSearch(nums, k, mid+1, end) ;
                }
            }
        }

        /**
         * 非递归二分查找。
         */
        private int bSearch(int[] nums, int k, int begin, int end) {

            while(begin != end) {
                int mid = (begin + end) / 2 ;
                if (nums[mid] == k) return mid ;

                if (k > nums[mid]) {
                    begin = mid + 1 ;
                }
                if (k < nums[mid]) {
                    end = mid - 1 ;
                }
            }

            if (nums[begin] == k) return begin ;

            return -1 ;
        }
    }
}
