package BackTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public Solution() {
		
	}
	
	

	/**
	 * https://leetcode.com/problems/palindrome-partitioning/#/description
	 * 
	 * @param s
	 * @return
	 */
	public List<List<String>> partition(String s) {
		return partitionDp(s) ;
	}

	private List<List<String>> partitionDp(String s) {
		
		LinkedList<String> aSet = new LinkedList<String>();
		List<List<String>> localAns = new LinkedList<List<String>>() ;
		
		if (s.length() == 0) {
			return localAns ;
		}
		
		if (s.length() == 1 ) {
			aSet.add(s);
			localAns.add(aSet) ;
			return localAns;
		}
		
		for(int i=1; i<=s.length(); i++) {
			String leftStr = s.substring(0, i) ;
			if (isPalindrome(leftStr)) {
				List<List<String>> rightSet = partitionDp(s.substring(i)) ;
				
				for(List<String> tempSet : rightSet) {
					tempSet.add(leftStr) ;
					if (!localAns.contains(tempSet)){
						localAns.add(tempSet) ;
					}
				}
				
				if (leftStr.equals(s)) {
					LinkedList<String> temp = new LinkedList<String>();
					temp.add(leftStr) ;
					localAns.add(temp) ;
				}
			}
		}
		
		return localAns ; 
	}
	
	private boolean isPalindrome(String s) {
		int left=0, right=s.length()-1 ;
		while(left<right) {
			if (s.charAt(left) != s.charAt(right)) return false ;
			left++ ;
			right-- ;
		}
		return true ;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3} ;
		List<List<Integer>> ans = new Solution().subsets(nums) ;
		System.out.print(ans) ;
	}
	
	/**
	 * https://leetcode.com/problems/subsets/#/description
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		ArrayList<List<Integer>> ansSet = new ArrayList<List<Integer>>() ;
		ansSet.add(new ArrayList<Integer>()) ;
		
		for(Integer num : nums) {
			ArrayList<List<Integer>> tempSet = new ArrayList<List<Integer>>() ;
			for(List<Integer> aSet : ansSet) {
				tempSet.add(aSet) ;
				List<Integer> newSet = new ArrayList<Integer>(aSet) ;
				newSet.add(num) ;
				tempSet.add(newSet) ;
				ansSet = tempSet ;
			}
		}
		return ansSet ;
    }

}
