package z_Company.book._01;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2018/4/2.
 */
public class Page31 {

    static class Solution {

        public int work(int[] arr, int num) {
            LinkedList<Integer> maxList = new LinkedList<>() ;
            LinkedList<Integer> minList = new LinkedList<>() ;
            int ans = 0 ;
            int l=0 ;
            int r=0 ;

            while (r < arr.length && l<=r) {
                if (maxList.size()==0 && minList.size()==0) {
                    if (arr[r] <= num) ans++ ;
                    maxList.add(r) ;
                    minList.add(r) ;
                    r++ ;
                    continue;
                }

                int minV = arr[minList.getFirst()] ;
                int maxV = arr[maxList.getFirst()] ;

                if (maxV + minV <= num) {
                    ans++ ;
                    int lastR = r++ ;
                    while(!maxList.isEmpty() && arr[maxList.getLast()]<=arr[lastR]) maxList.removeLast() ;
                    maxList.addLast(lastR);
                    while(!minList.isEmpty() && arr[minList.getLast()]>=arr[lastR]) minList.removeLast() ;
                    minList.addLast(lastR);
                } else {
                    int lastL = l++ ;
                    while(!maxList.isEmpty() && maxList.getFirst() <= lastL) maxList.removeFirst() ;
                    while(!minList.isEmpty() && minList.getFirst() <= lastL) minList.removeFirst() ;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6} ;
        int num = 3 ;

        Solution sol = new Solution() ;
        int work = sol.work(arr, num);

        System.out.println(work) ;
    }
}
