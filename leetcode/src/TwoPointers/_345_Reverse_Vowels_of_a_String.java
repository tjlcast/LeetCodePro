package TwoPointers;

import java.util.ArrayList;

public class _345_Reverse_Vowels_of_a_String {

	public static void main(String[] args) {
		String s = "hello" ;
		String work = new _345_Reverse_Vowels_of_a_String().work(s) ;
		System.out.println("work:¡¡" + work) ;
	}
	
	public String work(String s) {
		return new Solution().reverseVowels(s) ;
	}
	
	public class Solution {
	    ArrayList<Character> vowels = new ArrayList<Character>() ;
	    
	    public Solution() {
	        vowels.add('a') ;
	        vowels.add('A') ;
	        vowels.add('e') ;
	        vowels.add('E') ;
	        vowels.add('i') ;
	        vowels.add('I') ;
	        vowels.add('o') ;
	        vowels.add('O') ;
	        vowels.add('u') ;
	        vowels.add('U') ;
	    }
	    public String reverseVowels(String s) {
	       StringBuilder sb = new StringBuilder(s) ;
	       int l = 0 ;
	       int r = s.length()-1 ;
	       
	       while(l < r) {
	           while(l<r && !isVowel(sb.charAt(l))) l++ ;
	           while(l<r && !isVowel(sb.charAt(r))) r-- ;
	           
	           if (l<r) {
	        	   char t = sb.charAt(l) ;
	        	   sb.setCharAt(l, sb.charAt(r));
	        	   sb.setCharAt(r, t);
	           }
	           l++ ;
        	   r-- ;
	       }
	       
	       return sb.toString() ;
	    }
		public boolean isVowel(char word) {
	        return vowels.contains(word) ;
	    }
	}
}
