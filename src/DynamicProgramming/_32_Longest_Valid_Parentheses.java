package DynamicProgramming;

import java.util.Stack;

/**
 * Created by tangjialiang on 17/5/11.
 * left 从left位置开始可能出现合法的括号匹配，多余的的'（'可能被后面出现的'）'匹配掉，而'）'不会。
 *
 * 嵌套匹配括号最外：需要可能与已经匹配括号相连
 *
 * 嵌套匹配括号内部：根据stack-top的下一个位置判断
 *
 */
public class _32_Longest_Valid_Parentheses {
    public static void main(String[] args) {
        String s = "()(())" ;
        int work = new _32_Longest_Valid_Parentheses().work(s);
        System.out.println(work) ;
    }

    public int work(String s) {
        return new Solution().longestValidParentheses(s) ;
    }

    class Solution {
        int ans = 0 ;

        int longestValidParentheses(String s) {
            if (s.length()==0) return 0 ;

            Stack<Integer> stack = new Stack<>() ;
            int left = 0 ;

            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i) ;
                if (c == '(') {
                    stack.push(i) ;
                } else {
                    if (stack.empty()) left = i + 1 ;
                    else {
                        stack.pop() ;
                        if (stack.empty()) {
                            ans = Integer.max(ans, i - left + 1) ;
                        } else {
                            ans = Integer.max(ans, i - stack.peek()) ;
                        }
                    }
                }
            }

            return ans ;
        }
    }
}
