package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/9/1.
 */
public class _13_Roman_to_Integer {
    /**
     * Given a roman numeral, convert it to an integer.

     Input is guaranteed to be within the range from 1 to 3999.
     */

    public static void main(String[] args) {
        String s = "MCMLXXX" ;
        _13_Roman_to_Integer roman_to_integer = new _13_Roman_to_Integer();
        int work = roman_to_integer.work(s);

        System.out.println("work is: " + work) ;
    }

    public int work(String s) {
        Solution solution = new Solution();
        int i = solution.romanToInt(s);
        return i ;
    }

    class Solution {

        public int romanToInt(String s) {
            HashMap<Character,Integer> map = new HashMap<Character,Integer>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            int value = map.get(s.charAt(0));
            for(int i=1;i<s.length();i++){
                if( map.get(s.charAt(i))>map.get(s.charAt(i-1))){
                    value = value + map.get(s.charAt(i))- 2*map.get(s.charAt(i-1)); //
                }
                else{
                    value = value + map.get(s.charAt(i));
                }
            }
            return value;
        }
    }
}
