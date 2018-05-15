package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/8/31.
 */
public class _6_ZigZag_Conversion {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

     P   A   H   N
     A P L S I I G
     Y   I   R
     And then read line by line: "PAHNAPLSIIGYIR"
     Write the code that will take a string and make this conversion given a number of rows:

     string convert(string text, int nRows);
     convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     */

    public static void main(String[] args) {
        String s = "PAYPALISHIRING" ;
        int numRows = 3 ;

        _6_ZigZag_Conversion zigZag_conversion = new _6_ZigZag_Conversion();
        String work = zigZag_conversion.work(s, numRows);
        System.out.println("work is: " + work) ;
    }

    public String work(String s, int numRows) {
        Solution solution = new Solution();
        String convert = solution.convert(s, numRows);
        return convert ;
    }

    class Solution {
        /**
         * 操作分为两个阶段。第一个阶段是"竖"的数据，第二个阶段是"斜"的数据。
         * 注意，在第二阶段中数据在numRows<=2时长度为0。
         */
        private String ans = "" ;

        public String convert(String s, int numRows) {
            int step2Line = (numRows<=2) ? (0) : (numRows-2) ;

            StringBuilder[] rows = new StringBuilder[numRows] ;
            for(int i=0; i<rows.length; i++) {
                rows[i] = new StringBuilder() ;
            }

            int pos = 0 ;
            while(pos < s.length()) {
                // step. 1
                int step1Pos = 0 ;
                while(step1Pos < numRows && step1Pos+pos<s.length()) {
                    rows[step1Pos].append(s.charAt(step1Pos+pos)) ;
                    step1Pos += 1 ;
                }

                // step. 2
                step1Pos -= 1 ;
                int step2Pos = 0 ;
                int stepB = pos + (numRows) ;
                while(step2Pos < step2Line && step2Pos+stepB<s.length()) {
                    rows[--step1Pos].append(s.charAt(step2Pos+stepB)) ;
                    step2Pos += 1 ;
                }

                pos = pos + numRows + (step2Line) ;
            }

            for(StringBuilder sb : rows) {
                ans += sb.toString() ;
            }

            return ans ;
        }
    }
}
