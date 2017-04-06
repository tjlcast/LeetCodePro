package Greedy;

public class _392_Is_Subsequence {

	public static void main(String[] args) {
		String s = "aa" ;
		String t = "ahbgdc" ;

		boolean res = new _392_Is_Subsequence().work(s, t);
		System.out.println("res: " + ((res)?"Yes!":"No!"));
	}

	boolean work(String s, String t) {
		return new Solution().isSubsequence(s, t);
	}

	class Solution {
	    public boolean isSubsequence(String s, String t) {
	    	String temp = s ;
	    	s = t ;
	    	t = temp ;
	    	
	    	int posFromS = 0 ;
	    	for(int i=0; i<t.length(); i++) {
	    		String word = t.substring(i, i+1)  ;
	    		
	    		while(posFromS<s.length() && !s.substring(posFromS, posFromS+1).equals(word)) {
	    			posFromS++ ;
	    		}
	    		if (posFromS>=s.length()) return false ;
	    		posFromS++ ;
	    		
	    	}
	    	
	        return true ;
	    }
	}
}
