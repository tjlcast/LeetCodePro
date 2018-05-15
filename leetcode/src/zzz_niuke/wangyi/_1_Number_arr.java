package zzz_niuke.wangyi;

/**
 * Created by tangjialiang on 2017/10/11.
 */

import java.io.* ;
import java.util.* ;

public class _1_Number_arr{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String _i1 ;
        String _i2 ;
        while((_i1=br.readLine()) != null) {
            _i2 = br.readLine() ;

            int n = Integer.parseInt(_i1) ;
            String[] _i2l = _i2.split(" ") ;

            int[] nums = new int[n] ;
            for(int i=0; i<nums.length; i++) {
                nums[i] = Integer.parseInt(_i2l[i]) ;
            }

            _1_Number_arr sol = new _1_Number_arr() ;
            String ans = sol.work(n, nums) ;

            System.out.println(ans) ;
        }
    }

    public String work(int n, int[] nums) {
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                String a = nums[i] + "" ;
                String b = nums[j] + "" ;
                if ((a+b).compareTo(b+a) < 0) {
                    int temp = nums[i] ;
                    nums[i] = nums[j] ;
                    nums[j] = temp ;
                }
            }
        }

        StringBuilder sb = new StringBuilder() ;
        for(Integer i : nums) {
            sb.append(i) ;
        }

        return sb.toString() ;
    }
}
