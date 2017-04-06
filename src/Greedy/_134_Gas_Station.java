package Greedy;

public class _134_Gas_Station {

	public static void main(String[] args) {
		int[] gas = {6,1,4,3,5} ;
		int[] cost = {3,8,2,4,2} ;
		int work = new _134_Gas_Station().work(gas, cost) ;
		System.out.println("pos is: " + work);
	}
	
	public int work(int[] gas, int[] cost) {
		return new Solution().canCompleteCircuit(gas, cost) ;
	}
	
	/**
	 * @author tangjialiang
	 * the direction of car is confirmed(n to n+1).
	 */
	public class Solution {
		
	    public int canCompleteCircuit(int[] gas, int[] cost) {
	    	int len = gas.length ;
	    	int[] rest = new int[gas.length] ;
	    	
	    	int judgeCount = 0 ;
	    	for(int i=0; i<len; i++) {
	    		rest[i] = gas[i] - cost[i] ;
	    		judgeCount += rest[i] ;
	    	}
	    	if (judgeCount < 0) return -1 ;
	    	
	    	// dp (mdzz)
	    	int beginPos = 0 ;
	    	int count = 0 ;
	    	for(int i=0; i<len; i++) {
	    		count += rest[i] ;
	    		if (count < 0) {
	    			beginPos = (i + 1) % (len + 1) ;
	    			count = 0 ;
	    		}
	    	}
	    	
	    	return beginPos ;
	    }
	}
}
