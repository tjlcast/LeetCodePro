package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {

	}

	/**
	 * url:https://leetcode.com/problems/subsets/#/description
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		ArrayList<List<Integer>> ansSet = new ArrayList<List<Integer>>();
		ansSet.add(new ArrayList<Integer>());

		for (Integer num : nums) {
			ArrayList<List<Integer>> tempSet = new ArrayList<List<Integer>>();
			for (List<Integer> aSet : ansSet) {
				tempSet.add(aSet);
				List<Integer> newSet = new ArrayList<Integer>(aSet);
				newSet.add(num);
				tempSet.add(newSet);
				ansSet = tempSet;
			}
		}
		return ansSet;
	}

	/**
	 * url: https://leetcode.com/problems/palindrome-partitioning/#/description
	 * for _test
	 * 
	 * @param s
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<List<String>> dp(String s) {
		ArrayList<List<String>> ans = new ArrayList<List<String>>();
		ArrayList<String> tmpSet = new ArrayList<String>();

		// when s is empty
		if (s.length() == 0)
			return ans;

		// when length of s is zero, s must be P.
		if (s.length() == 1) {
			tmpSet.add(s);
			ans.add(tmpSet);
			return ans;
		}

		for (int i = 1; i <= s.length(); i++) {
			// get right str by i
			String leftStr = s.substring(0, i);
			String rightStr = s.substring(i);

			if (isP(leftStr)) {
				List<List<String>> rightSet = dp(rightStr);
				for (List<String> item : rightSet) {
					item.add(leftStr);
					ans.add(item);
				}
				if (leftStr.equals(s)) {
					tmpSet.add(leftStr);
					ans.add(tmpSet);
				}
			}
		}
		return ans;
	}

	private boolean isP(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		String word = "ABCCD";
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		boolean ans = new Solution().exist(board, word);
		System.out.println(ans);
	}

	/**
	 * https://leetcode.com/problems/word-search/#/description
	 * 
	 * @param board
	 * @param word
	 * @return
	 */
	int[][] isV;

	public boolean exist(char[][] board, String word) {
		boolean ans = false;
		int rows = board.length;
		if (rows == 0)
			return true;
		int cols = board[0].length;
		isV = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				ans = ans || go(board, word, i, j);
			}
		}

		return ans;
	}

	private boolean go(char[][] board, String word, int row, int col) {
		boolean ans = false;

		if (word.length() == 0)
			return true;
		int rows = board.length;
		if (rows == 0)
			return true;
		int cols = board[0].length;

		if (row < 0 || row >= rows || col < 0 || col >= cols || isV[row][col] == 1)
			return false;
		int ch = word.charAt(0);
		if (ch == board[row][col]) {
			isV[row][col] = 1;
			ans = ans || go(board, word.substring(1), row + 1, col);
			ans = ans || go(board, word.substring(1), row, col + 1);
			ans = ans || go(board, word.substring(1), row - 1, col);
			ans = ans || go(board, word.substring(1), row, col - 1);
		}
		isV[row][col] = 0;

		return ans;
	}
}
