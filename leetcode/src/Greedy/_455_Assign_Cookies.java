package Greedy;

import java.util.Arrays;

public class _455_Assign_Cookies {
	class Solution {
		public int findContentChildren(int[] g, int[] s) {
			Arrays.sort(g);
			Arrays.sort(s);

			int sRight = 0;
			int count = 0;

			for (int i = 0; i < g.length; i++) {
				while (sRight < s.length && s[sRight] < g[i]) {
					sRight++;
				}

				if (sRight < s.length) {
					count++;
					sRight++;
				}
			}

			return count;
		}
	}
}
