package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/12/3.
 */
public class _134_Gas_Station {

    public static void main(String[] args) {
        /**
         *
         [6,1,4,3,5]
         [3,8,2,4,2]

         {1, 1, 4}
         {2, 3, 1}

         {4}
         {5}
         */
        int[] gas = {10} ;
        int[] cost = {5} ;



        int i = new Solution().canCompleteCircuit(gas, cost);

        System.out.println("work is: " + i) ;
    }

    static public class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int[] val = new int[gas.length] ;

            for(int i=0; i<gas.length; i++) {
                val[i] = gas[i] - cost[i] ;
            }

            int begin = 0 ;
            int pos = 0 ;
            int count = 0 ;
            int len = 0 ;
            int step = 0 ;
            while(len != gas.length) {
                if (step==gas.length * 2) return -1 ;

                if (val[pos] < 0) {
                    if (count + val[pos] < 0) {
                        count = 0 ;
                        len = 0 ;
                        begin = pos+1 ;
                    } else {
                        count += val[pos] ;
                        len += 1;
                    }
                } else {
                    count += val[pos] ;
                    len += 1 ;
                }

                pos = (pos+1)%gas.length ;
                step++ ;
            }

            return begin ;
        }
    }
}
