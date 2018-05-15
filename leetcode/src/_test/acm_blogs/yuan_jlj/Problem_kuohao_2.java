package _test.acm_blogs.yuan_jlj;

import java.util.Scanner;
import java.util.Stack ;

/**
 * Created by tangjialiang on 2018/3/31.
 */
public class Problem_kuohao_2 {

    static class Solution {
        public int work(String words) {
            int count = 0 ;
            Stack<Character> stack = new Stack() ;

            for (int i = 0; i < words.length(); i++) {
                char curWord = words.charAt(i) ;
                if (curWord=='{' || curWord=='[' || curWord=='(') stack.push(curWord) ;
                else {
                    if (stack.isEmpty()) count++ ;
                    else {
                        Character topWord = stack.peek();
                        if (topWord=='(' && curWord==')') {
                            stack.pop() ;
                            continue;
                        }
                        if (topWord=='[' && curWord==']') {
                            stack.pop() ;
                            continue;
                        }
                        if (topWord=='{' && curWord=='}') {
                            stack.pop() ;
                            continue;
                        }
                        count++ ;
                    }
                }
            }
            return count + stack.size() ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        sc.nextLine() ;

        Solution sol = new Solution() ;

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine() ;
            int work = sol.work(str);

            System.out.println(work) ;
        }
    }
}
