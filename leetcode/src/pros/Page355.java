package pros;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2018/3/11.
 */
public class Page355 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3} ;
        int k = 6 ;

        Page355 page = new Page355() ;
        int maxLen = page.getMaxLen(arr, k);

        System.out.println("maxLen is: " + maxLen) ;
    }

    public static int getMaxLen(int[] arr, int target) {
        HashMap<Integer, Integer> recorders = new HashMap<>() ;
        recorders.put(0, -1) ; // 很重要
        int maxLen = 0 ;
        int sum = 0 ;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i] ;

            int rest = sum - target ;
            if (recorders.containsKey(rest)) {
                maxLen = Math.max(maxLen, i-recorders.get(rest)) ;
            } else {
                recorders.put(sum, i) ;
            }
        }

        return maxLen ;
    }
}
