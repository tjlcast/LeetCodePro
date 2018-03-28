package zz_to_to_offer.solution;

import java.util.* ;
import java.io.* ;

/**
 * Created by tangjialiang on 2018/3/26.
 */
public class Solution08 {

    static public class Solution {
        private HashMap<Integer, Integer> rec = new HashMap<>() ;
        private int n ;

        public Solution() {
            rec.put(0, 1) ;
            rec.put(1, 1) ;
            rec.put(2, 2) ;
        }

        public int JumpFloorII(int target) {
            this.n = target ;
            return jump(target) ;
        }

        private int jump(int target) {
            if (target<0) return 0 ;
            if(rec.containsKey(target)) return rec.get(target) ;
            int sum = 0 ;
            for(int i=1; i<=n; i++) {
                sum += jump(target-i) ;
            }
            rec.put(target, sum) ;

            return rec.get(target) ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String iStr1 = null ;
        iStr1 = br.readLine() ;
        int n = Integer.parseInt(iStr1) ;

        Solution sol = new Solution() ;
        int i = sol.JumpFloorII(n);

        System.out.println("The work is: " + i) ;
    }
}
