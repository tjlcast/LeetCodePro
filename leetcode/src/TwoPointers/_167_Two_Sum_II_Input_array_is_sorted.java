package TwoPointers;

public class _167_Two_Sum_II_Input_array_is_sorted {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3} ;
		int target = 4 ;
		
		int[] work = new _167_Two_Sum_II_Input_array_is_sorted().work(numbers, target) ;
		System.out.println("work: " + work) ;
	}
	
	public int[] work(int[] numbers, int target) {
		return new Solution().twoSum(numbers, target) ;
	}
	
	public class Solution {
	    public int[] twoSum(int[] numbers, int target) {
	        for(int i=0; i<numbers.length-1; i++) {
	            int num = numbers[i] ;
	            int pos = find(numbers, i+1, numbers.length-1, target-num) ;
	            if (pos != -1) {
	                int[] ans = {i+1, pos+1} ;
	                return ans ;
	            }
	        }
	        return null ;
	    }
	    
	    public int find(int[] numbers, int l, int r, int target) {
	       
	        
	        while(l <= r) {
	            int mid = (l+r)/2 ;
	            if (numbers[mid] == target) return mid ;
	            else if (target > numbers[mid]) l = mid+1 ;
	            else r = mid-1 ;
	        }
	        return -1 ;
	    }
	}

}
