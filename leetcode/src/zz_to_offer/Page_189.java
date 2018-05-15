package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/29.
 */
public class Page_189 {
    /**
     * 在数组中的两个数字如果前面一个数字大于后面的数字，
     * 则这两个数字组成一个逆序对，输入一个数组，求出这个
     * 数组中的逆序对的总数。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4} ;
        int work = new Page_189().work(nums);
        System.out.println("work is: " + work) ;
    }

    public int work(int[] nums) {
        MySolution mySolution = new MySolution();
        int i = mySolution.inversePairs(nums);
        return i ;
    }

    class MySolution {
        /**
         * tips： 可以在归并操作 + 有序数组（定位）在 log(n)*n 的时间中做完
         */
        int[] mergeArr = null ;

        public int inversePairs(int[] nums) {
            mergeArr = new int[nums.length] ;
            int i = divideAndMerge(nums, 0, nums.length - 1);
            return i ;
        }

        private int divideAndMerge(int[] nums, int s, int e) {
            if (s == e) return 0 ;
            System.out.println("s: " + s + " e: " + e) ;

            // divide
            int mid = (s + e) / 2 ;
            int rTotal = divideAndMerge(nums, s, mid) ;
            int lTotal = divideAndMerge(nums, mid+1, e) ;
            int curTotal = 0 ;

            // merge
            int aBegin = s ;
            int bBegin = mid+1 ;
            int cBegin = s ;
            while(aBegin<=mid || bBegin<=e) {
                int aVal = (aBegin<=mid) ? (nums[aBegin]) : (Integer.MAX_VALUE) ;
                int bVal = (bBegin<=e) ? (nums[bBegin]) : (Integer.MAX_VALUE) ;

                if (aVal < bVal) {
                    mergeArr[cBegin++] = aVal ;
                    aBegin++ ;
                } else {
                    curTotal += (mid - aBegin + 1) ;
                    mergeArr[cBegin++] = bVal ;
                    bBegin++ ;
                }
            }

            // copy to nums
            for(int i=s; i<=e; i++) {
                nums[i] = mergeArr[i] ;
            }

            // final answer
            return rTotal + lTotal + curTotal ;
        }
    }
}
