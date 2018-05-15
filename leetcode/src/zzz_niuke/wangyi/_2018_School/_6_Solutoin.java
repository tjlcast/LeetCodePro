package zzz_niuke.wangyi._2018_School;

import java.io.* ;
import java.util.* ;

/**
 * Created by tangjialiang on 2017/10/10.
 */
public class _6_Solutoin {
    /**
     *
     排行榜
     求职
     讨论区
     搜索
     APP
     28消息

     6/8 01:40:40
     [编程题] 最长公共子括号序列
     时间限制：1秒
     空间限制：100768K
     一个合法的括号匹配序列被定义为:
     1. 空串""是合法的括号序列
     2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
     3. 如果"X"是一个合法的序列,那么"(X)"也是一个合法的括号序列
     4. 每个合法的括号序列都可以由上面的规则生成
     例如"", "()", "()()()", "(()())", "(((()))"都是合法的。
     从一个字符串S中移除零个或者多个字符得到的序列称为S的子序列。
     例如"abcde"的子序列有"abe","","abcde"等。
     定义LCS(S,T)为字符串S和字符串T最长公共子序列的长度,即一个最长的序列W既是S的子序列也是T的子序列的长度。
     小易给出一个合法的括号匹配序列s,小易希望你能找出具有以下特征的括号序列t:
     1、t跟s不同,但是长度相同
     2、t也是一个合法的括号匹配序列
     3、LCS(s, t)是满足上述两个条件的t中最大的
     因为这样的t可能存在多个,小易需要你计算出满足条件的t有多少个。

     如样例所示: s = "(())()",跟字符串s长度相同的合法括号匹配序列有:
     "()(())", "((()))", "()()()", "(()())",其中LCS( "(())()", "()(())" )为4,其他三个都为5,所以输出3.
     输入描述:
     输入包括字符串s(4 ≤ |s| ≤ 50,|s|表示字符串长度),保证s是一个合法的括号匹配序列。


     输出描述:
     输出一个正整数,满足条件的t的个数。

     输入例子1:
     (())()

     输出例子1:
     3
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String _l1 = br.readLine() ;

        _6_Solutoin sol = new _6_Solutoin() ;
        String ans = sol.work(_l1) ;

        System.out.println(ans) ;
    }

    private LinkedList<String> genaretedStr = new LinkedList<>() ;

    public String work(String s) {
        // tips: 因为判断的字符串的长度相同长度并且两个字符串的长度不相同，猜想最长公共子序列的长度为判断字符串的长度-1。

        // coding: 由s生成t时，可以通过在s中删除一个字符c，把c插入s的其他位置中。
        int total = 0 ;
        genaretedStr.add(s) ;

        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<s.length(); j++) {
                // insert i from j and i!=j
                if (i==j) continue;
                StringBuilder sb = new StringBuilder(s) ;
                insertSb(sb, i, j);
                if (!genaretedStr.contains(sb.toString()) && validate(sb.toString())) {
                    total += 1 ;
                    genaretedStr.add(sb.toString()) ;
                }
            }
        }
        return total+"" ;
    }

    private void insertSb(StringBuilder sb, int i, int j) {
        // i != j
        char c = sb.charAt(j) ;

        if (i < j) {
            int pos = j ;
            while(pos != i) {
                sb.setCharAt(pos, sb.charAt(pos-1));
                pos-- ;
            }
            sb.setCharAt(pos, c);
        } else { // i > j
            int pos = j ;
            while(pos != i) {
                sb.setCharAt(pos, sb.charAt(pos+1));
                pos++ ;
            }
            sb.setCharAt(pos, c);
        }
    }

    private boolean validate(String s) {
        Stack<Character> stack = new Stack<>() ;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i) ;
            if (c == '(') {
                stack.add('(') ;
            } else {
                if (stack.isEmpty()) return false ;
                else stack.pop() ;
            }
        }
        if (!stack.isEmpty()) return false ;

        return true ;
    }

}
