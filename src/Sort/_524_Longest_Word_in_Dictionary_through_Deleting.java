package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _524_Longest_Word_in_Dictionary_through_Deleting {

	public static void main(String[] args) {
		String s = "abpcplea" ;
		ArrayList<String> d = new ArrayList<String>() ;
		d.add("z") ;
		d.add("z") ;
		d.add("q") ;
		d.add("o") ;
		d.add("m") ;
		
		String work = new _524_Longest_Word_in_Dictionary_through_Deleting().work(s, d) ;
		System.out.println("work: " + work);

	}
	
	public String work(String s, List<String> d) {
		return new Solution().findLongestWord(s, d) ;
	}
	
	public class Solution {
	    public String findLongestWord(String s, List<String> d) {
	    	Collections.sort(d, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.compareTo(o2) == -1) {
						return -1 ;
					} 
					return 1 ;
				}
			});
	    	
	    	String ans = "" ;
	    	for(String str :  d) {
	    		if(isSubStr(s, str) && str.length()>ans.length()) {
	    			ans = str ;
	    		}
	    	}
	        return ans ;
	    }
	    
	    public boolean isSubStr(String str, String sub) {
	    	int pos = 0 ;
	    	for(int i=0; i<sub.length(); i++) {
	    		if (pos<str.length()) {
	    			while(pos<str.length() && !str.substring(pos, pos+1).equals(sub.substring(i, i+1))) {pos++;}
	    		} else {
	    			return false ;
	    		}
	    	}
	    	
	    	if (pos>=str.length()) return false ;
	    	return true ;
	    }
	}
}
