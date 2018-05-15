package _test.acm_blogs.yuan_jlj;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tangjialiang on 2018/3/31.
 */
public class Problem_kuohao_1 {

    /**
     * 样例输入
     3
     [(])
     (])
     ([[]()])
     样例输出
     No
     No
     Yes
     */
    static class Solution {
        public boolean isVaildate(String str) {
            Stack ops = new Stack<Character>() ;
            for (int i = 0; i < str.length(); i++) {
                char word = str.charAt(i) ;
                if (word=='(' || word=='[' || word=='{') {
                    ops.push(word) ;
                } else {
                    if (ops.isEmpty()) return false ;

                    Character topW = (Character)ops.peek() ;
                    if (word == ')' && topW!='(') return false ;
                    if (word == ']' && topW!='[') return false ;
                    if (word == '}' && topW!='{') return false ;
                    ops.pop() ;
                }
            }
            return (ops.isEmpty())?(true):(false) ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int cases = sc.nextInt() ;
        sc.nextLine() ;
        for (int i = 0; i < cases; i++) {
            String word = sc.nextLine();
            Solution solution = new Solution();
            boolean vaildate = solution.isVaildate(word);
            System.out.println((vaildate)?("Yes"):("No")) ;
        }
    }
}
