package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/29.
 */
public class Page_204 {
    /**
     * 统计一个数字在排序数字中出现的次数，
     * 例如输入排序数组{1, 2, 3, 3, 3, 3, 4, 5},
     * 由于3在这个数组中出现了4次，故输出4。
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5} ;
        int k = 3 ;
        Page_204 page_204 = new Page_204();
        int work = page_204.work(nums, k);
        System.out.println("work: " + work) ;
    }

    public int work(int[] nums, int k) {
        MySolution mySolution = new MySolution();
        int numberOfK = mySolution.getNumberOfK(nums, k);
        return numberOfK ;
    }

    static class MySolution {

        public int getNumberOfK(int[] nums, int k) {
            int total = 0 ;
            int s = 0 ;
            int e = nums.length-1 ;
            int firstK = getFirstK(nums, s, e, k);
            int lastK = getLastK(nums, s, e, k);
            if (lastK >= firstK) total = lastK - firstK + 1 ;
            return total ;
        }

        private int getFirstK(int[] nums, int s, int e, int k) {
            int ans = -1;
            int mid = (s + e) / 2 ;

            if (k < nums[mid]) {
                ans = getFirstK(nums, s, mid-1, k) ;
            } else if (k > nums[mid]) {
                ans = getFirstK(nums, mid+1, e, k) ;
            } else {
                // 在mid与目标值相同的情况下，把范围向右缩小
                // 如果是相同值的边界，直接返回mid
                if (mid==0 || (mid>0 && nums[mid-1]!=k)) { // border: 到头 || 后面没有相同的数字
                    return mid ;
                } else {
                    ans = getFirstK(nums, s, mid - 1, k);
                }
            }

            return ans ;
        }


        private int getLastK(int[] nums, int s, int e, int k) {
            int ans = -1 ;
            int mid = (s + e) / 2 ;

            if (k < nums[mid]) {
                ans = getLastK(nums, s, mid-1, k) ;
            } else if (k > nums[mid]) {
                ans = getLastK(nums, mid+1, e, k) ;
            } else {
                if (mid==0 || (mid<nums.length-1 && nums[mid+1]!=k)) {
                    return mid ;
                } else {
                    ans = getLastK(nums, mid+1, e, k) ;
                }
            }

            return ans ;
        }
    }
}
