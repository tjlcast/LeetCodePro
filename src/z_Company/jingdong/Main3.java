package z_Company.jingdong;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/4/9.
 */
public class Main3 {

    public static boolean work(char[] chars) {
        if (chars.length==1) return false ;

        LinkedList<Character> stack = new LinkedList<>() ;
        int flag1 = 0 ;
        int flag2 = 0 ;
        for(Character c : chars) {
            if (!isOp(c)) continue;
            if (c == '(') {
                flag1++ ;
                stack.addLast(c);
            } else {
                flag2++ ;
                if (!stack.isEmpty() && stack.getLast()=='(') stack.removeLast() ;
                else stack.add(c) ;
            }
        }

        if (stack.size()==0 && flag1>=2) return true ;
        return (stack.size()==1 && flag1==flag2) ? (true) : (false) ;
    }

    private static boolean isOp(char c) {
        if (c == '(') return true ;
        if (c == ')') return true ;
        return false ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        int t = sc.nextInt() ;
        sc.nextLine() ;
        for(int i=0; i<t; i++) {
            String s = sc.nextLine();
            boolean work = work(s.toCharArray());
            System.out.println((work) ? ("Yes") : ("No"));
        }
    }
}