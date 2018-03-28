package zz_to_to_offer.solution;

/**
 * Created by tangjialiang on 2018/3/26.
 */

import java.util.* ;
import java.io.* ;

public class Solution05 {

    static public class Solution {

        public int minNumberInRotateArray(int [] array) {
            if (array==null || array.length==0) return 0 ;
            return rotataFind(array, 0, array.length-1) ;
        }

        private int rotataFind(int[] arr, int start, int end) {
            int mid = ((end - start) >>1) + start ;
            System.out.format("start: %d end: %d mid: %d\n", start, end, mid) ;
            int sVal = arr[start] ;
            int eVal = arr[end] ;
            int mVal = arr[mid] ;

            if (sVal < eVal || start == end) {
                return sVal ;
            }

            if (mVal > sVal) {
                return rotataFind(arr, mid+1, end) ;
            } else if (mVal < sVal) {
                return rotataFind(arr, start, mid) ;
            } else {
                return Math.min(rotataFind(arr, start, mid), rotataFind(arr, mid+1, end)) ;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String iStr1 ;

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        iStr1 = br.readLine() ;

        // convert
        int[] ints = Arrays.stream(iStr1.split(",")).mapToInt(x -> Integer.parseInt(x)).toArray();

        // work
        Solution sol = new Solution() ;
        int i = sol.minNumberInRotateArray(ints);

        System.out.println("the work is " + i) ;
    }
}
