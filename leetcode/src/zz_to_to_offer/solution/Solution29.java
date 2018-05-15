package zz_to_to_offer.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by tangjialiang on 2018/4/25.
 */
public class Solution29 {

    static public class Solution {

        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            PriorityQueue<Integer> bigHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            }) ;
            ArrayList<Integer> ans = new ArrayList<>() ;
            if (k <= 0) return ans ;

            for (int i = 0; i < Math.min(input.length, k); i++) {
                bigHeap.add(input[i]) ;
            }

            for (int i = Math.min(input.length, k); i < input.length; i++) {
                int curV = input[i] ;
                if (bigHeap.peek() > curV) {
                    bigHeap.poll() ;
                    bigHeap.add(curV) ;
                }
            }

            if (bigHeap.size() != k) return ans ;
            while(!bigHeap.isEmpty()) {
                ans.add(bigHeap.poll()) ;
            }

            return ans ;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8} ;
        int k = 20 ;

        Solution sol = new Solution() ;
        ArrayList<Integer> integers = sol.GetLeastNumbers_Solution(arr, k);

        for (Integer i :
                integers) {
            System.out.print(i + " ") ;
        }
    }
}
