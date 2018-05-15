package z_Company.book._01;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2018/4/2.
 */
public class Page19 {

    static class Solution {
        public List<Integer> work(int[] arr, int window) {
            int idx = 0 ;
            List<Integer> ans = new LinkedList<>() ;
            LinkedList<Integer> list = new LinkedList<>() ;

            for (int i = 0; i < arr.length; i++) {
                int val = arr[idx++] ;
                while(!list.isEmpty() && list.getLast() < val) {
                    list.removeLast() ;
                }

                while(list.size() >= window) {
                    list.removeFirst();
                }
                list.addLast(val);
                if (i>=window-1 && !list.isEmpty())
                    ans.add(list.getFirst()) ;
            }
            
            return ans ;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7} ;

        Solution sol = new Solution() ;
        List<Integer> work = sol.work(arr, 3);

        for (Integer i :
                work) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
