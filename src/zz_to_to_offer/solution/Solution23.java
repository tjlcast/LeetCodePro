package zz_to_to_offer.solution;

/**
 * Created by tangjialiang on 2018/4/23.
 */
public class Solution23 {

    static public class Solution {
        public boolean VerifySquenceOfBST(int [] sequence) {
            return isRight(sequence, 0, sequence.length-1) ;
        }

        public boolean isRight(int[] sequence, int l, int r) {
            if (l>=r) return true;

            int val = sequence[r] ;
            int pos = l ;
            while(pos <= r-1) {
                if (sequence[pos] > val) break ;
                pos++ ;
            }

            for(int i=pos; i<r; i++) {
                if (sequence[i] < val) return false ;
            }

            return isRight(sequence, l, pos-1) && isRight(sequence, pos, r-1) ;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1} ;

        Solution sol = new Solution() ;
        boolean b = sol.VerifySquenceOfBST(arr) ;

        System.out.println(b) ;
    }
}
