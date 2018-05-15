package zzz_niuke.wangyi._2018_NeiTui;

/**
 * Created by tangjialiang on 2017/9/28.
 */
import java.io.* ;
import java.util.* ;

public class _4_Solution {

    private String work(int numsLen, int[] nums) {
        LinkedList<Integer> ll = new LinkedList<>() ;

        if (numsLen <= 2) {
            for(int i=0; i<numsLen; i++) ll.addFirst(nums[i]) ;
            return l2s(ll) ;
        }

        for(int i=1; i<numsLen; i=i+2) {
            int n = nums[i] ;
            ll.addFirst(n) ;
            int n_1 = nums[i-1] ;
            ll.addLast(n_1) ;
        }

        if (numsLen%2!=0) {
            Collections.reverse(ll) ;
            ll.addFirst(nums[numsLen-1]) ;
        }

        return l2s(ll) ;
    }

    private String l2s(LinkedList<Integer> ll) {
        StringBuilder sb = new StringBuilder() ;
        for(Integer i : ll) sb.append(i+" ") ;
        return sb.toString().trim() ;
    }

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        String i1 = br.readLine() ;
        String i2 = br.readLine() ;

        int numsLen = Integer.parseInt(i1) ;
        String[] _i2 = i2.split(" ") ;
        int[] nums = new int[numsLen] ;
        for(int i=0; i<numsLen; i++) nums[i] = Integer.parseInt(_i2[i]) ;

        _4_Solution main = new _4_Solution() ;
        String res = main.work(numsLen, nums) ;

        System.out.println(res) ;
    }
}