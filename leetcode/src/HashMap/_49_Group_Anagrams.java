package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class _49_Group_Anagrams {

	public static void main(String[] args) {
		String[] strs = {"hello", "olleh", "apple", "banana", "anaban"} ;
		List<List<String>> work = new _49_Group_Anagrams().work(strs) ;
		System.out.println(work);
		work.hashCode() ;
	}
	
	public List<List<String>> work (String[] strs) {
		return new Solution().groupAnagrams(strs) ;
	}
	
	public class Solution {
	    public List<List<String>> groupAnagrams(String[] strs) {
	    	HashMap<String, List<String>> dict = new HashMap<String, List<String>>() ;
	        for(String s : strs) {
	        	char[] charL = s.toCharArray() ;
	        	Arrays.sort(charL);
	        	System.out.println(charL);
	        	String key = new String(charL) ;
	        	List<String> value = dict.get(key)!=null ? dict.get(key) : new LinkedList<String>() ;
	        	value.add(s) ;
	        	dict.put(key, value) ;
	        }
	        LinkedList<List<String>> res = new LinkedList<>() ;
	        for(List<String> v : dict.values()){
	        	res.add(v) ;
	        }
	        return res ;
	    }
	}

}
