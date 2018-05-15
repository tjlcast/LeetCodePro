package _test;

/**
 * Created by tangjialiang on 2017/5/15.
 */
public class bSearchLeftRange {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3 ,3 , 4, 4, 4, 4, 5} ;
        int target = 9 ;
        int leftRange = new bSearchLeftRange().findLeftRange(nums, target);
        System.out.println("leftRange: " + leftRange) ;
    }

    int findLeftRange(int[] nums, int target) {
        int left = 0 ;
        int right = nums.length-1 ;

        while(left < right) {
            int mid = (left + right) / 2 ;

            if (nums[mid] == target) {
                if (left != mid) {left = mid ;}
                else {right = mid ;}
            } else if (nums[mid] < target) {
                left = mid + 1 ;
            } else { // > target
                right = mid - 1 ;
            }
        }

        return (nums[left]==target)?(left):(-1) ;
    }
}
