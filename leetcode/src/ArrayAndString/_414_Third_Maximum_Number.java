package ArrayAndString;

import java.util.Iterator;
import java.util.PriorityQueue;

public class _414_Third_Maximum_Number {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		int work = new _414_Third_Maximum_Number().work(nums);
		System.out.println("work : " + work);
	}

	public int work(int[] nums) {
		return new Solution().thirdMax(nums);
	}

	class Solution {
		public int thirdMax(int[] nums) {
			PriorityQueue<Integer> q = new PriorityQueue<Integer>(3);

			for (int i = 0; i < nums.length; i++) {
				if (!q.contains(nums[i])) {
					q.add(nums[i]);
					if (q.size() > 3) {
						q.poll();
					}
				}
			}

			if (q.size() == 3)
				return q.peek();

			int ans=0;
			Iterator<Integer> iterator = q.iterator();
			while (iterator.hasNext()) {
				ans = iterator.next();
			}
			return ans;
		}

	}
}
