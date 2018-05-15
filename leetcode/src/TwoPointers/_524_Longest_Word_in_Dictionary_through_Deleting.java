package TwoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _524_Longest_Word_in_Dictionary_through_Deleting {
	public static void main(String[] args) {
		String s = "abpcplea" ;
		ArrayList<String> d = new ArrayList<String>() ;
		d.add("ale") ;
		d.add("apple") ;
		d.add("monkey") ;
		d.add("plea") ;
		
		String work = new _524_Longest_Word_in_Dictionary_through_Deleting().work(s, d) ;
		System.out.println("work: " + work) ;
	}
	
	public String work(String s, List<String> d) {
		return new Solution().findLongestWord(s, d) ;
	}
	
	public class Solution {
	    public String findLongestWord(String s, List<String> d) {
	    	Collections.sort(d, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() > o2.length()) {
						return -1 ;
					} else if (o1.length() < o2.length()){
						return 1 ;
					} else {
						return (o1.compareTo(o2));
					}
				}
			});
	    	
	    	for(String str : d) {
	    		if (isSubStr(s,  str)) return str ;
	    	}
	    	
	        return "" ;
	    }
	    
	    public boolean isSubStr(String str, String s) {
	    	int begin = 0 ;
	    	for(int i=0; i<s.length(); i++) {
	    		String word = s.substring(i, i+1) ;
	    		int indexOf = str.indexOf(word, begin) ;
	    		if (indexOf == -1) return false ;
	    		begin = (indexOf + 1) ;
	    	} 
	    	return true ;
	    }
	}
}
