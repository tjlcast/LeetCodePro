package zz_to_to_offer.solution;

import java.util.* ;
import java.io.* ;

/**
 * Created by tangjialiang on 2018/3/26.
 */
public class Solution09 {
    static public class Solution {
        private HashMap<Integer, Integer> rec = new HashMap<>() ;

        public Solution() {
            rec.put(0, 0) ;
            rec.put(1, 1) ;
            rec.put(2, 2) ;
        }
        public int RectCover(int target) {
            if(rec.containsKey(target)) return rec.get(target) ;
            int sum = RectCover(target-1) + RectCover(target-2) ;
            rec.put(target, sum) ;
            return rec.get(target) ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String iStr1 = null ;
        iStr1 = br.readLine() ;

        int target = Integer.parseInt(iStr1) ;

        Solution sol = new Solution() ;
        int i = sol.RectCover(target);

        System.out.println("The work is: " + i) ;
    }
}
