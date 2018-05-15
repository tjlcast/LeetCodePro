package zz_to_to_offer.solution;

import java.io.* ;
import java.util.* ;

/**
 * Created by tangjialiang on 2018/3/26.
 */
public class Solution13 {

    static public class Solution {
        public void reOrderArray(int [] array) {
            if (array==null || array.length==0) return ;

            int len = array.length ;
            int idx = 0 ;
            Queue<Integer> odds = new LinkedList<>() ;
            Queue<Integer> evens = new LinkedList<>() ;

            for(Integer num : array) {
                if (isOdd(num)) {
                    odds.add(num);
                } else {
                    evens.add(num);
                }
            }

            while(!odds.isEmpty()) {
                array[idx++] = odds.poll() ;
            }
            while(!evens.isEmpty()) {
                array[idx++] = evens.poll() ;
            }

        }

        private boolean isOdd(int num) {
            return num%2==1 ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String iStr1 = null ;
        iStr1 = br.readLine() ;

        int[] ints = Arrays.stream(iStr1.split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        Solution sol = new Solution() ;
        sol.reOrderArray(ints);

        Arrays.stream(ints).forEach(System.out::println);
    }
}
