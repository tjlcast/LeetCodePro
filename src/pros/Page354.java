package pros;

/**
 * Created by tangjialiang on 2018/3/11.
 */
public class Page354 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1} ;
        int k = 3 ;

        Page354 page = new Page354() ;
        int ans = page.getMaxLen(arr, k) ;

        System.out.println("The ans is: " + ans) ;
    }

    public int getMaxLen(int[] arr, int target) {
        int maxLen = 0 ;
        int left = 0, right = 0 ;
        int total = 0 ;
        int curLen = 0 ;

        while(right < arr.length) {
            if (total == target) {
                maxLen = Math.max(maxLen, curLen) ;
                total -= arr[left++] ;
                curLen-- ;
            } else if (total < target) {
                total += arr[right++] ;
                curLen++ ;
            } else if (total > target) {
                total -= arr[left++] ;
                curLen-- ;
            } else {

            }
        }
        maxLen = Math.max(maxLen, right-left) ;

        return maxLen ;
    }
}
