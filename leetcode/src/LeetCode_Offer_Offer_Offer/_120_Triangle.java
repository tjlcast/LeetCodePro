package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/11/18.
 */
public class _120_Triangle {

    class Solution {

        public int minimumTotal(List<List<Integer>> triangle) {
            int rows = triangle.size() ;
            if (rows == 0) return 0 ;
            if (rows == 1) return triangle.get(0).get(0) ;

            LinkedList<Integer> dp = new LinkedList<Integer>() ;
            dp.add(triangle.get(0).get(0)) ;

            for(int index=2; index<=rows; index++) {
                List<Integer> curLine = triangle.get(index-1) ;

                LinkedList<Integer> newCount = new LinkedList<Integer>() ;
                for(int j=0; j<curLine.size(); j++) {
                    int a = (j-1>=0) ? (dp.get(j-1)) : (dp.get(0)) ;
                    int b = (j<dp.size()) ? (dp.get(j)) : (dp.get(dp.size()-1)) ;

                    newCount.add(curLine.get(j)+Math.min(a, b)) ;
                }
                dp = (LinkedList)newCount ;
            }

            int ans = Integer.MAX_VALUE ;
            for(Integer n : dp) {
                ans = Math.min(ans, n) ;
            }

            return ans ;
        }
    }
}
