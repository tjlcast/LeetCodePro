package _test.acm_blogs;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/4/1.
 */
public class GenerateKuohao {

    static class Solution {
        List<String> ans = null ;
        int n ;

        public List<String> countStr(int n) {
            this.n = n ;
            ans = new LinkedList<String>() ;
            char[] words = new char[n*2] ;
            generate(words, 0, 0, 0);
            return ans ;
        }

        private void generate(char[] words, int pos, int leftOpNum, int rightOpNum) {
            if (leftOpNum < rightOpNum) return ;

            if (leftOpNum==n && rightOpNum==n) {
                ans.add(new String(words)) ;
                return ;
            }

            if (leftOpNum < n) {
                words[pos] = '(' ;
                generate(words, pos+1, leftOpNum+1, rightOpNum);
            }
            if (leftOpNum > rightOpNum) {
                words[pos] = ')' ;
                generate(words, pos+1, leftOpNum, rightOpNum+1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution() ;
        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;
        List<String> strings = sol.countStr(n);

        for (String str :
                strings) {
            System.out.println(str) ;
        }
    }
}
