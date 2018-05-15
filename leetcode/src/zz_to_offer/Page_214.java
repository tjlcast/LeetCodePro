package zz_to_offer;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/8/30.
 */
public class Page_214 {
    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个树，
     * 使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对。
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7, 11, 15} ;
        int k = 15 ;

        Page_214 page_214 = new Page_214();
        List<List> work = page_214.work(nums, k);
        for(List couple: work) {
            System.out.println("a: " + couple.get(0) + " b: " + couple.get(1)) ;
        }
    }

    public List<List> work(int[] nums, int k) {
        MySolution1 mySolution = new MySolution1();
        List<List> twoNumsEqualS = mySolution.findTwoNumsEqualS(nums, k);
        return twoNumsEqualS ;
    }

    class MySolution {
        /**
         * tips: 通常的数组遍历，第二个数使用二分查找（数组有序）。
         */
        private List<List> ans = new LinkedList<List>() ;

        public List<List> findTwoNumsEqualS(int[] nums, int k) {
            int s = 0 ;
            int e = nums.length-1 ;
            for(s=0; s<nums.length; s++) {
                int aNum = nums[s] ;
                int bNum = bSearch(nums, s + 1, e, k - aNum);
                if (bNum == -1) continue; ;
                LinkedList<Integer> integers = new LinkedList<Integer>(Arrays.asList(aNum, bNum));
                ans.add(integers) ;
            }

            return ans ;
        }

        /**
         *  二分查找
         * @param nums
         * @param s beging position(include)
         * @param e end position(include)
         * @param k find k
         * @return  return the k's position
         */
        private int bSearch(int[] nums, int s, int e, int k) {

            while(s <= e) {
                int mid = (s + e) / 2 ;
                if (nums[mid] == k) {
                    return nums[mid] ;
                } else if (k < nums[mid]) {
                    e = mid - 1 ;
                } else {
                    s = mid + 1 ;
                }
            }

            return -1 ;
        }
    }

    class MySolution1 {
        /**
         * tips：设置一个窗口，该窗口覆盖第二个数的查找范围。通过改变该窗口的大小来寻找相等数据对。
         */
        private List<List> ans = new LinkedList<List>() ;

        public List<List> findTwoNumsEqualS(int[] nums, int k) {
            int s = 0 ;
            int e = nums.length - 1 ;

            while(s<e && e<nums.length) {
                int sum = nums[e] + nums[s] ;
                if (k == sum) {
                    LinkedList<Integer> objects = new LinkedList<>(Arrays.asList(nums[s], nums[e]));
                    ans.add(objects) ;
                    s = s + 1 ;
                } else if (sum < k) {
                    s += 1 ;
                } else {
                    e -= 1 ;
                }
            }

            return ans ;
        }

    }
}
