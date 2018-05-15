package zz_to_to_offer.solution;

/**
 * Created by tangjialiang on 2018/4/26.
 */
public class Solution35 {
    static public class Solution {
        public int InversePairs(int [] array) {
            int[] ints = new int[array.length];
            long ans = divide(array, ints, 0, array.length-1) ;
            return (int)(ans % 1000000007) ;
        }

        public long merge(int[] array, int[] backend, int s, int mid, int e) {
            long ans = 0 ;

            int i = mid, j = e, k=e-s ;
            while (i>=s && j>=mid+1) {
                if (array[i] > array[j]) {
                    backend[k--] = array[i--] ;
                    ans += (j - mid) ;
                } else {
                    backend[k--] = array[j--] ;
                }
            }
            while (i >= s) backend[k--] = array[i--] ;
            while (j >= mid+1) backend[k--] = array[j--] ;

            for (int t = e-s; t >= 0; t--) {
                array[s+t] = backend[t] ;
            }
            return ans ;
        }

        public long divide(int[] array, int[] backend, int s, int e) {
            long ans = 0 ;
            if (s < e) {
                int mid = (s + e) / 2 ;
                ans += divide(array, backend, s, mid) ;
                ans += divide(array, backend, mid+1, e) ;
                ans += merge(array, backend, s, mid, e) ;
            }
            return ans ;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0} ;

        Solution sol = new Solution() ;
        int i = sol.InversePairs(arr) ;

        System.out.println(i) ;
    }
}
