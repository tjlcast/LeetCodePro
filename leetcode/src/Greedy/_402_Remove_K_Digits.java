package Greedy;


public class _402_Remove_K_Digits {

	public static void main(String[] args) {
		String num = "1432219";
		int k = 5 ;

		String res = new _402_Remove_K_Digits().work(num, k);
		System.out.println("res: " + res);
	}

	String work(String num, int k) {
		return new Solution().removeKdigits(num, k);
	}

	class Solution {
		public String removeKdigits(String num, int k) {
			StringBuilder sb = new StringBuilder(num) ;
			
	        for(int i=0; i<k; i++) {
	        	int pos = 0 ;
	        	while(pos<sb.length()-1 && Integer.parseInt(sb.substring(pos, pos+1)) <= Integer.parseInt(sb.substring(pos+1, pos+2))) 
	        		pos++ ;
	        	sb.delete(pos, pos+1) ;
	        }
	        
	        while(sb.length()>=1 && sb.substring(0, 1).equals("0")) sb.delete(0, 1) ;
	        if (sb.length()==0) sb.append("0") ;
	        
	        return new String(sb) ;
	    }
	}
}
