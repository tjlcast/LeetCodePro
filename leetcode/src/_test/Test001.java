package _test;

import java.util.List;

/**
 * Created by tangjialiang on 2018/3/14.
 */
public class Test001 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4} ;

        Test001 test = new Test001() ;
        int duplicate3 = test.findDuplicate3(nums);

        System.out.println(duplicate3) ;
    }

    int findDuplicate3(int[] nums)
    {
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
