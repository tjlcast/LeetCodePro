package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/11/18.
 */
public class _118_Pascal_s_Triangle {

    class Solution {
        private LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>() ;

        public List<List<Integer>> generate(int numRows) {
            for(int i=1; i<=numRows; i++) {
                gLine(i) ;
            }

            return ans ;
        }

        private void gLine(int num) {
            if (num==1) {
                LinkedList<Integer> line = new LinkedList<Integer>() ;
                line.add(1) ;
                ans.add(line) ;
                return ;
            }

            // assumption: the lesser than num line have been generated.
            LinkedList<Integer> line = new LinkedList<Integer>() ;
            LinkedList<Integer> lastLine = (LinkedList<Integer>)ans.get(num-2) ;

            int lastNum = 0 ;
            for(int i=0; i<lastLine.size(); i++) {
                line.add(lastLine.get(i)+lastNum) ;
                lastNum = lastLine.get(i) ;
            }
            line.add(1) ;

            ans.add(line) ;
        }

    }
}
