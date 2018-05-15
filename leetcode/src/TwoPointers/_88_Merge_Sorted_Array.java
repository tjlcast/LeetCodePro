package TwoPointers;

import java.util.ArrayList;

public class _88_Merge_Sorted_Array {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 0, 0, 0 };
		int m = 4;
		int[] nums2 = { 4, 5, 6 };
		int n = 3;

		new _88_Merge_Sorted_Array().work(nums1, m, nums2, n);

		for (int i = 0; i < m + n; i++) {
			System.out.println(nums1[i]);
		}
	}

	public void work(int[] nums1, int m, int[] nums2, int n) {
		new Solution().merge(nums1, m, nums2, n);
	}

	public class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int pos1 = 0;
			int pos2 = 0;

			while (pos1 < m || pos2 < n) {
				int n1 = Integer.MAX_VALUE;
				int n2 = Integer.MAX_VALUE;

				if (pos1 < m) {
					n1 = nums1[pos1];
				}
				if (pos2 < n) {
					n2 = nums2[pos2];
				}

				if (n1 > n2) {
					list.add(n2);
					pos2++;
				} else {
					list.add(n1);
					pos1++;
				}
			}

			for (int i = 0; i < list.size(); i++) {
				nums1[i] = list.get(i);
			}
		}
	}

}
