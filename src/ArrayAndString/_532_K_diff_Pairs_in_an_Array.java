package ArrayAndString;

import java.util.Arrays;
import java.util.HashMap;

public class _532_K_diff_Pairs_in_an_Array {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		int k = 2;
		int work = new _532_K_diff_Pairs_in_an_Array().work(nums, k);
		System.out.println("pos is: " + work);
	}

	public int work(int[] nums, int k) {
		return new Solution().findPairs(nums, k);
	}

	class Solution {
		public int findPairs(int[] nums, int k) {
			if (k < 0) return 0 ;

			Arrays.sort(nums);

			HashMap<Integer, Integer> recorder = new HashMap<Integer, Integer>();

			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] - nums[j] == k || nums[j] - nums[i] == k) {
						Integer integer = recorder.get(nums[i]);
						if (integer == null
								|| (recorder.get(integer) == null || !recorder.get(integer).equals(nums[i]))) {
							recorder.put(nums[i], nums[j]);
						}
					}
				}
			}

			return recorder.keySet().size();
		}

	}

}
