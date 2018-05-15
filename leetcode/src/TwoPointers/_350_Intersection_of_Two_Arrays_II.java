package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class _350_Intersection_of_Two_Arrays_II {

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1} ;
		int[] nums2 = {2, 2} ;
		
		int[] work = new _350_Intersection_of_Two_Arrays_II().work(nums1, nums2) ;
		System.out.print("work: " + work);
	}
	
	public int[] work(int[] nums1, int[] nums2) {
		return new Solution().intersect(nums1, nums2) ;
	}
	
	public class Solution {
	    public int[] intersect(int[] nums1, int[] nums2) {
	    	ArrayList<Integer> ans = new ArrayList<Integer>() ;
	        Arrays.sort(nums1) ;
	        Arrays.sort(nums2) ;
	        
	        int len1 = nums1.length ;
	        int len2 = nums2.length ;
	        
	        if (len1 < len2) {
	            int[] temp = nums1 ;
	            nums1 = nums2 ;
	            nums2 = temp ;
	            len1 = nums1.length ;
	            len2 = nums2.length ;
	        }
	        
	        int pos1 = 0 ;
	        int pos2 = 0 ;
	        while(pos2 < len2 && pos1 < len1) {
	            while(pos1<len1 && nums2[pos2]>nums1[pos1]) {
	                pos1++ ;
	            }
	            if (pos1 < len1 && pos2 < len2 && nums1[pos1]==nums2[pos2]) {
	                ans.add(nums1[pos1]) ;
	                pos1++ ;
	                pos2++ ;
	            }
	            if (pos1 < len1 && pos2 < len2 && nums1[pos1]>nums2[pos2]) {
	                pos2++ ;
	            }
	        }
	        
	        int[] ansArr = new int[ans.size()] ;
	        for(int i=0; i<ans.size(); i++) ansArr[i] = ans.get(i) ;
	        return ansArr ;
	    }
	}

}
