package TwoPointers;

public class _125_Valid_Palindrome {

	public static void main(String[] args) {
		String s = "0p" ;
		boolean work = new _125_Valid_Palindrome().work(s) ;
		System.out.println("work: " + work);
	}
	
	public boolean work(String s) {
		return new Solution().isPalindrome(s) ;
	}
	
	public class Solution {
	    public boolean isPalindrome(String s) {
	        StringBuilder sb = new StringBuilder(s.toLowerCase()) ;
	        
	        int l = 0 ;
	        int r = sb.length()-1 ;
	        
	        while(l < r) {
	        	while(l < sb.length() && !isWord(sb.charAt(l))) l++ ;
	        	while(0 <= r && !isWord(sb.charAt(r))) r-- ;
	        	
	        	if (l < r) {
	        		if (sb.charAt(l) != sb.charAt(r)) return false ;
	        		l++ ;
	        		r-- ;
	        	}
	        }
	        return true ;
	    }
	    
	    public boolean isWord(char word) {
	    	if (('a' <= word && word <= 'z') || ('0' <= word && word <= '9')) return true ;
	    	return false ;
	    }
	}

}
