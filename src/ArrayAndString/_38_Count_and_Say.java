package ArrayAndString;

public class _38_Count_and_Say {

	public static void main(String[] args) {
		int n = 6 ;
		String work = new _38_Count_and_Say().work(n) ;
		System.out.println("work: " + work) ;
	}
	
	public String work(int n) {
		return new Solution().countAndSay(n) ;
	}
	
	
	public class Solution {
		StringBuilder ans = null ; 
		
	    public String countAndSay(int n) {
	        String g = "1" ;
	        for(int i=1; i<n; i++) {
	            g = around(g) ;
	        }
	        return g ;
	    }
	    
	    public String around(String str) {
	        ans = new StringBuilder() ; 
	        
	        int pos = 0 ;
	        while(pos < str.length()) {
	        	char c = str.charAt(pos) ;
	        	int count=0 ;
	        	while(pos < str.length()) {
	        		char curC = str.charAt(pos) ;
	        		if (c != curC) {
	        			String t = String.valueOf(c) ;
		        		ans.append(count + t) ;
		        		break ;
	        		}
	        		pos++ ;
	        		count++ ;
	        	}
	        	if (pos == str.length() && count!=0) {
	        		String t = String.valueOf(c) ;
	        		ans.append(count + t) ;
	        	}
	        }
	        
	        return ans.toString() ;
	    }
	}

}
