package LeetCode_Offer_Offer_Offer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tangjialiang on 2017/9/11.
 */
public class _71_Simplify_Path {
    /**
     * Given an absolute path for a file (Unix-style), simplify it.

     For example,
     path = "/home/", => "/home"
     path = "/a/./b/../../c/", => "/c"
     */

    public static void main(String[] args) {
        String path  = "/a/./b/../../c/" ;

        _71_Simplify_Path simplify_path = new _71_Simplify_Path();
        String work = simplify_path.work(path);

        System.out.println("work is: " + work) ;
    }

    public String work(String path) {
        Solution solution = new Solution();
        String s = solution.simplifyPath(path);

        return s;
    }

    class Solution {
        private StringBuilder ans = new StringBuilder() ;

        public String simplifyPath(String path) {
            String[] split = path.split("/");

            Stack<String> stack = new Stack<>() ;
            for(String str : split) {
                if (str.trim().equals("") || str.trim().equals(".")) continue;

                if (str.trim().equals("..")) {
                    if (stack.size() != 0) stack.pop() ;
                } else {
                    stack.push(str) ;
                }
            }

            List<String> temp = new LinkedList<>() ;
            while(!stack.isEmpty()) {
                String pop = stack.pop();
                temp.add("/"+pop) ;
            }
            Collections.reverse(temp);

            for(String str : temp) {
                ans.append(str) ;
            }

            if (ans.length()==0) ans.append("/") ;

            return ans.toString() ;
        }
    }
}
