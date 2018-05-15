package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author tangjialiang
 * 长度不同的字符比较可以通过结合两个字符传，从而转换为比较两个长度相同的字符串。
 * Tips：
 * 		compareTo()比较两个字符串的字典序。
 *
 */
public class _179_Largest_Number {

	public static void main(String[] args) {

		int[] nums = {0, 0} ;
		String work = new _179_Largest_Number().work(nums) ;
		System.out.println("work: " + work);
	}
	
	public String work(int[] nums) {
		return new Solution().largestNumber(nums) ;
	}
	
	public class Solution {
	    public String largestNumber(int[] nums) {
	    	ArrayList<String> list = new ArrayList<String>() ;
	    	for(int i=0; i<nums.length; i++) {
	    		list.add(nums[i]+"") ;
	    	}
	    	
	    	Collections.sort(list, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					String str1 = o1 + o2 ;
					String str2 = o2 + o1 ;
					
					if (str1.compareTo(str2) < 0) {
						return 1 ;
					} 
					return -1 ;
				}
			});
	    	
	    	StringBuilder sb = new StringBuilder() ;
	    	for(String str : list) {
	    		sb.append(str) ;
	    	}
	    	int pos = 0 ;
	    	while(pos < sb.length()) {
	    		if (sb.charAt(pos) != '0') {
	    			break ;
	    		}
	    		pos++ ;
	    	}
	    	if (pos >= sb.length()) {
	    		sb = new StringBuilder() ;
	    		sb.append('0') ;
	    	} else {
	    		sb.delete(0, pos) ;
	    	}
	        return sb.toString() ;
	    }
	}

}
