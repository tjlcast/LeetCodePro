package LeetCode_Offer_Offer_Offer;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/25.
 */
public class _224_Basic_Calculator {

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)" ;

        Solution sol = new Solution() ;
        int ans = sol.calculate(s) ;

        System.out.println("The work is: " + ans) ;
    }

    static class Solution {
        public int calculate(String s) {
            StringBuilder sb = new StringBuilder();
            LinkedList<Integer> queue = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    queue.addLast(sb.length());
                    sb.append(c);
                } else if (c == ')') {
                    Integer poll = queue.removeLast();
                    String substring = sb.substring(poll+1);
                    int i1 = countSimpleFormula(substring);

                    if (poll-1 >=0 && sb.charAt(poll-1)=='-' && i1<0) {
                        sb.replace(poll-1, sb.length(), "+"+(i1*-1) + "");
                    } else {
                        sb.replace(poll, sb.length(), i1 + "");
                    }
                } else if (c == ' ') {
                } else {
                    sb.append(c);
                }
            }

            String ans = sb.toString();


            return Integer.valueOf(countSimpleFormula(ans));
        }

        public int countSimpleFormula(String s) {
            int total = 0;
            StringBuilder sb = new StringBuilder(s);

            char op = '+';
            int num = 0;

            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == '+' || c == '-') {

                    if (op == '+') {
                        total += num;
                    } else if (op == '-') {
                        total -= num;
                    } else {
                    }
                    op = c;
                    num = 0;
                } else if (c >= '0' && c <= '9') {
                    num = num * 10 + (c - '0');
                }
            }
            if (op == '+') {
                total += num;
            } else if (op == '-') {
                total -= num;
            } else {
            }
            return total;
        }
    }
}
