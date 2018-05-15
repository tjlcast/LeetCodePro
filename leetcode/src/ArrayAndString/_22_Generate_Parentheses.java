package ArrayAndString;


import java.util.LinkedList;
import java.util.List;


public class _22_Generate_Parentheses {

    public static void main(String[] args) {
        int n = 3 ;
        List<String> work = new _22_Generate_Parentheses().work(n) ;
        System.out.print(work);
    }

    public List<String> work(int n) {
        return new Solution().generateParenthesis(n) ;
    }

    public class Solution {
        int[] arr = null ;
        List<String> ans = new LinkedList<>() ;

        List<String> generateParenthesis(int n) {
            arr = new int[n*2] ;
            tb(0, n*2, 0);
            return ans ;
        }

        void tb(int pos, int len, int count) {
            // border condition
            if (pos == len) {
                if (count == 0) {
                    ans.add(parseInteger(arr)) ;
                }
                return ;
            }
            if (len-pos<count) {
                return ;
            }

            // recursion
            if (count>0) {
                arr[pos] = -1;
                tb(pos + 1, len, count + arr[pos]);
                arr[pos] = 0;
            }
            arr[pos] = 1;
            tb(pos + 1, len, count + arr[pos]);
            arr[pos] = 0;
        }

        String parseInteger(int[] nums) {
            StringBuilder sb = new StringBuilder() ;
            for(int n : nums) {
                if (n == 1) {
                    sb.append("(") ;
                } else if (n==-1) {
                    sb.append(")") ;
                }
            }
            return sb.toString() ;
        }
    }
}
