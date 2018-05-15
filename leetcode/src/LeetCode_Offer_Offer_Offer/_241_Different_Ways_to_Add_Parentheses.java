package LeetCode_Offer_Offer_Offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tangjialiang on 2018/1/31.
 */
public class _241_Different_Ways_to_Add_Parentheses {
    public static void main(String[] args) {
        String input = "2*3-4*5" ;

        Solution sol = new Solution() ;
        List<Integer> integers = sol.diffWaysToCompute(input);

        System.out.println("The work is: ") ;
        Stream.of(integers).forEach(System.out::println);
    }

    static class Solution {

        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> res = new LinkedList<>() ;
            for(int i=0; i<input.length(); i++) {
                char ch = input.charAt(i) ;
                if ('0'<=ch && ch<='9') continue ;

                List<Integer> left = diffWaysToCompute(input.substring(0, i)) ;
                List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length())) ;

                for(int a: left){
                    for(int b: right) {
                        switch (ch) {
                            case '+':
                                res.add(a+b) ;
                                break ;
                            case '-':
                                res.add(a-b) ;
                                break ;
                            case '*':
                                res.add(a*b) ;
                                break ;
                            case '/':
                                res.add(a/b) ;
                                break ;
                        }
                    }
                }
            }

            if (res.size() == 0) res.add(Integer.valueOf(input)) ;
            return res ;
        }
    }
}
