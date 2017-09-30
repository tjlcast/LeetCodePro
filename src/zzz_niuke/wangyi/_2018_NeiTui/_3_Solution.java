package zzz_niuke.wangyi._2018_NeiTui;

/**
 * Created by tangjialiang on 2017/9/28.
 */
import java.io.* ;

public class _3_Solution{

    private int work(String inputStr) {

        int len = inputStr.length() ;
        if (len <= 1) return len ;

        int curLen = 1 ;
        int maxLen = 1 ;
        int pos = 1 ;
        char lastC = inputStr.charAt(0) ;

        while(pos < len) {
            char c = inputStr.charAt(pos) ;
            if (c==lastC) {
                curLen = 1 ;
            } else {
                curLen = curLen + 1 ;
            }
            lastC = c ;
            maxLen = Math.max(maxLen, curLen) ;
            //System.out.format("pos:%dcurLen:%d ", pos, curLen) ;
            pos++ ;
        }

        return maxLen ;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        String input1 = null ;
        try {
            input1 = br.readLine() ;
        } catch(Exception e) {

        }

        _3_Solution main = new _3_Solution() ;
        int res = main.work(input1) ;

        System.out.println(res) ;

    }
}