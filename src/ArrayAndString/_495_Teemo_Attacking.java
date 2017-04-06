package ArrayAndString;

public class _495_Teemo_Attacking {

	public static void main(String[] args) {
		int[] timeSeries = {0, 1,2};
		int duration = 2 ;
		
		int work = new _495_Teemo_Attacking().work(timeSeries, duration) ;
		System.out.println("work result is : " + work);
	}
	
	public int work(int[] timeSeries, int duration) {
		return new Solution().findPoisonedDuration(timeSeries, duration);
	}
	
	public class Solution {
		public int findPoisonedDuration(int[] timeSeries, int duration) {
	        int ans = 0 ;
	        
	        int lastPos = -9 ;
	        for(int i=0; i<timeSeries.length; i++) {
	            int pos = timeSeries[i]-1 ;
	            int end = pos + duration - 1 ;
	            
	            if (lastPos < pos) {
	                ans += duration ;
	                lastPos = end ;
	            } else if (pos <= lastPos && lastPos<end) {
	                ans += (end - lastPos) ;
	                lastPos = end ;
	            } else {
	                
	            }
	        }
	        
	        return ans ;
	    }
	}

}
