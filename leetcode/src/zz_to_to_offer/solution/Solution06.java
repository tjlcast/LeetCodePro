package zz_to_to_offer.solution;

import java.io.* ;
import java.util.* ;

/**
 * Created by tangjialiang on 2018/3/26.
 */
public class Solution06 {

    static public class Solution {
        private HashMap<Integer, Integer> rec = null ;

        public Solution() {
            rec = new HashMap<>() ;
            rec.put(1, 1) ;
            rec.put(0, 0) ;
        }

        public int Fibonacci(int n) {
            if (rec.containsKey(n)) return rec.get(n) ;
            int val = Fibonacci(n-1) + Fibonacci(n-2) ;
            rec.put(n, val) ;

            return rec.get(n) ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String iStr1 = null ;
        iStr1 = br.readLine() ;

        int n = Integer.parseInt(iStr1) ;
        Solution sol = new Solution() ;
        int fibonacci = sol.Fibonacci(n);

        System.out.println(fibonacci) ;
    }
}
