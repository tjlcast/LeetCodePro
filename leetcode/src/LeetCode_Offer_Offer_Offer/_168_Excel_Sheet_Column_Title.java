package LeetCode_Offer_Offer_Offer;

/**
 * Created by tangjialiang on 2017/12/27.
 */
public class _168_Excel_Sheet_Column_Title {
    /**
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
     * 1 -> A
     2 -> B
     3 -> C
     ...
     26 -> Z
     27 -> AA
     28 -> AB
     */
    public static void main(String[] args) {
        int n = 26 ;

        Solution solution = new Solution();
        String s = solution.convertToTitle(n);

        System.out.println("the work is: " + s) ;
    }

    static class Solution {
        public String convertToTitle(int n) {
            StringBuilder sb = new StringBuilder() ;

            while(n != 0) {
                n = convert(n, sb);
            }

            return sb.reverse().toString() ;
        }

        int convert(int n, StringBuilder sb) {
            int c = n % 26 ;
            int v = n / 26 ;

            if (c==0 && v!=0) {
                sb.append("Z") ;
                return v-1 ;
            }

            if (c == 1) {
                sb.append("A") ;
            } else if (c == 2) {
                sb.append("B") ;
            } else if (c == 3) {
                sb.append("C") ;
            } else if (c == 4) {
                sb.append("D") ;
            } else if (c == 5) {
                sb.append("E") ;
            } else if (c == 6) {
                sb.append("F") ;
            } else if (c == 7) {
                sb.append("G") ;
            } else if (c == 8) {
                sb.append("H") ;
            } else if (c == 9) {
                sb.append("I") ;
            } else if (c == 10) {
                sb.append("J") ;
            } else if (c == 11) {
                sb.append("K") ;
            } else if (c == 12) {
                sb.append("L") ;
            } else if (c == 13) {
                sb.append("M") ;
            } else if (c == 14) {
                sb.append("N") ;
            } else if (c == 15) {
                sb.append("O") ;
            } else if (c == 16) {
                sb.append("P") ;
            } else if (c == 17) {
                sb.append("Q") ;
            } else if (c == 18) {
                sb.append("R") ;
            } else if (c == 19) {
                sb.append("S") ;
            } else if (c == 20) {
                sb.append("T") ;
            } else if (c == 21) {
                sb.append("U") ;
            } else if (c == 22) {
                sb.append("V") ;
            } else if (c == 23) {
                sb.append("W") ;
            } else if (c == 24) {
                sb.append("X") ;
            } else if (c == 25) {
                sb.append("Y") ;
            }

            return v ;
        }
    }
}
