package z_Company.jingdong;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/4/9.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        String str = sc.nextLine() ;

        char[] chars = str.toCharArray() ;
    }

    private static int work(char[] chars, int l, int r) {
        if (l == r) return 0 ;
        if (r-l==1) {
            if (chars[l] == chars[r]) return 3 ;
            else { return 2; }
        }
        return -1 ;
    }

    private static boolean isSy(char[] chars, int l1, int r1, int l2, int r2) {
        for(int k=0; l1+k<=r1; k++) {
            if (chars[l1+k] != chars[r2-k]) return false ;
        }
        return true ;
    }
}
