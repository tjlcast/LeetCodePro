package DivideAndConquer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/6/1.
 *
 */
public class _241_Different_Ways_to_Add_Parentheses {
    public static void main(String[] args) {
        String input = "2*3-4*5" ;
        List<Integer> work = new _241_Different_Ways_to_Add_Parentheses().work(input);
        System.out.println("work:" + work) ;
    }

    public List<Integer> work(String input) {
        return new Solution().diffWaysToCompute(input) ;
    }

    public class Solution {
        List<Integer> ans = new ArrayList<Integer>() ;
        String str = null ;

        public List<Integer> diffWaysToCompute(String input) {
            // border condition
            if (input.equals("")) {
                ans.add(0) ;
                return ans ;
            }
            if (input.length()==1) {
                ans.add(input.charAt(0)-'0') ;
                return ans ;
            }

            str = input ;
            // get position of operations => opera
            int[] opera = new int[(input.length()-1)/2] ;
            int[] nums = new int[input.length()] ;
            int operaPos = 0 ;
            for (int i=0; i<str.length(); i++) {
                if (str.charAt(i)<'0' || str.charAt(i)>'9') {
                    opera[operaPos++] = i ;
                } else {
                    nums[i] = str.charAt(i) - '0' ;
                }
            }

            // travel to opera, and recur to ;
            for (int i=0; i<opera.length; i++) {
                int pos = opera[i] ;

                List<Integer> leftSet = computeRange(0, pos, opera, nums);
                List<Integer> rightSet = computeRange(pos + 1, input.length(), opera, nums);
                ans.addAll(merge(leftSet, rightSet, str.charAt(pos))) ;
            }
            return ans ;
        }

        private List<Integer> computeRange(int begin, int end, int[] opera, int[] nums) {
            List<Integer> set = new LinkedList<>() ;

            if (end - begin == 1) {
                set.add(str.charAt(begin)-'0') ;
                return set ;
            }

            for(int i=0; i<opera.length; i++) {
                if (opera[i]>=begin && opera[i] <end) {
                    int pos = opera[i] ;
                    List<Integer> leftSet = computeRange(begin, pos, opera, nums);
                    List<Integer> rightSet = computeRange(pos + 1, end, opera, nums);

                    set.addAll(merge(leftSet, rightSet, str.charAt(pos))) ;
                }
            }
            return set ;
        }

        private List<Integer> merge(List<Integer> nums1, List<Integer> nums2, char oper) {
            List<Integer> set = new LinkedList<Integer>() ;

            for(Integer num1: nums1) {
                for(Integer num2: nums2) {
                    switch (oper) {
                        case '+':
                            set.add(num1 + num2) ;
                            continue;
                        case '-':
                            set.add(num1 - num2) ;
                            continue;
                        case '*':
                            set.add(num1 * num2) ;
                            continue;
                        case '/':
                            set.add(num1 / num2) ;
                            continue;
                    }
                }
            }

            return set ;
        }
    }
}
