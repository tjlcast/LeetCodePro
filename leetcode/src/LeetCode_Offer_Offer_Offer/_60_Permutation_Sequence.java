package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by tangjialiang on 2017/9/10.
 */
public class _60_Permutation_Sequence {
    /**
     * The set [1,2,3,…,n] contains a total of n! unique permutations.

     By listing and labeling all of the permutations in order,
     We get the following sequence (ie, for n = 3):

     "123"
     "132"
     "213"
     "231"
     "312"
     "321"
     Given n and k, return the kth permutation sequence.

     Note: Given n will be between 1 and 9 inclusive.
     */

    public static void main(String[] args) {
        int n = 3 ;
        int k = 4 ;

        _60_Permutation_Sequence permutation_sequence = new _60_Permutation_Sequence();
        String work = permutation_sequence.work(n, k);

        System.out.println("work is: " + work)  ;
    }

    public String work(int n, int k) {
        Solution solution = new Solution();
        String permutation = solution.getPermutation(n, k);

        return permutation ;
    }

    class Solution {
        public String getPermutation(int n, int k) {
            Character[] words = new Character[n] ;
            for(int i=0; i<n; i++) {
                words[i] = (char)((char)i + '1') ;
            }

            for(int i=1; i<k; i++) {
                permutation(words);
            }

            StringBuilder sb = new StringBuilder() ;
            for(Character c : words) sb.append(c) ;

            return sb.toString() ;
        }

        private void permutation(Character[] words) {
            if (words.length <= 1) return ;

            int pos = words.length-2 ;
            while(pos>=0 && words[pos]>=words[pos+1]) {
                pos-- ;
            }

            if (pos < 0) {
                // return the beginning strign
                int l=0, r=words.length-1;
                while(l < r) {
                    Character word = words[l];
                    words[l] = words[r] ;
                    words[r] = word ;
                    l++; r--;
                }
                return ;
            }

            // else pos is the position we find
            int minPos = pos+1 ;
            for(int i=pos+1; i<words.length; i++) {
                if (words[i] > words[pos] && words[minPos] > words[i]) {
                    minPos = i ;
                }
            }

            // swap minPos and pos
            Character word = words[minPos];
            words[minPos] = words[pos] ;
            words[pos] = word ;

            Arrays.sort(words, pos+1, words.length);
        }
    }
}
