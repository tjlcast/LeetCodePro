package ArrayAndString;

public class _287_Find_the_DuplicateNumber {
	public static void main(String[] args) {
		int[] nums = {1, 1, 2} ;
		int work = new _287_Find_the_DuplicateNumber().work(nums) ;
		System.out.println(work);
	}

	public int work(int[] nums) {
		return new Solution().findDuplicate(nums) ;
	}

	class Solution {
        public int findDuplicate(int[] nums) {
            int ans =-1;
            for(int i=0; i<nums.length; i++) {
                int num = nums[i] ;
                while(num!=(i+1)) {
                    if (nums[num-1] == num) {
                        return num ;
                    }
                    
                    int temp = nums[i] ;
                    nums[i] = nums[num-1] ;
                    nums[num-1] = temp ;
                    
                    num = nums[i] ;
                }
            }
            return ans ;
        }
	}
}
