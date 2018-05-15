package LeetCode_Offer_Offer_Offer;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/10.
 */
public class _68_Text_Justification {
    /**
     * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
     * <p>
     * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
     * <p>
     * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
     * <p>
     * For the last line of text, it should be left justified and no extra space is inserted between words.
     * <p>
     * For example,
     * words: ["This", "is", "an", "example", "of", "text", "justification."]
     * L: 16.
     * <p>
     * Return the formatted lines as:
     * [
     * "This    is    an",
     * "example  of text",
     * "justification.  "
     * ]
     * Note: Each word is guaranteed not to exceed L in length.
     */

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."} ;
        int maxWidth = 19 ;
//        String[] words = {""} ;
//        int maxWidth = 2 ;
//        String[] words = {"Listen", "to", "many,", "speak", "to", "a", "few."};
//        int maxWidth = 6;
//        String[] words = {"a","b","c","d","e"} ;
//        int maxWidth = 3 ;
//        String[] words = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."} ;
//        int maxWidth = 30 ;

        _68_Text_Justification text_justification = new _68_Text_Justification();
        List<String> work = text_justification.work(words, maxWidth);

        System.out.println("work is: ");
        for (String line : work) {
            System.out.println(line);
        }
    }

    public List<String> work(String[] words, int maxWidth) {
        Solution solution = new Solution();
        List<String> strings = solution.fullJustify(words, maxWidth);

        return strings;
    }


    class Solution {
        private String gapStr = "_" ;
        List<String> ans = new LinkedList<>() ;

        public List<String> fullJustify(String[] words, int maxWidth) {
            int l = 0;
            int r = 0;
            int wordsLine = 0 ;
            while (r < words.length) {
                if (wordsLine == 0) {
                    // first word must be invalid.
                    wordsLine += words[r].length() ;
                    r++ ;
                } else {
                    // next words
                    if (wordsLine + (r-l-1) + 1 + words[r].length() <= maxWidth) {
                        // add
                        wordsLine += words[r].length() ;
                        r++ ;
                    } else {
                        // do old
                        int gapNum = (r-l==1)?(1):(r-l-1) ; // r must be > l
                        int gapLen = (maxWidth - wordsLine) / gapNum ;
                        int restGap = (maxWidth - wordsLine) % gapNum ;
                        StringBuilder gap = new StringBuilder(); for(int i=0; i<gapLen; i++) gap.append(gapStr) ;

                        StringBuilder sb = new StringBuilder() ;
                        int index = l ;
                        while(index <r-1){
                            sb.append(words[index] + gap + (((index-l+1) <= restGap)?(gapStr):(""))) ; // 因为是以字符串作为坐标判断其后面的空格
                            index++ ;
                        } if (index==r-1) {
                            sb.append(words[index] + ((index==l)?(gap):(""))) ;
                        }

                        ans.add(sb.toString()) ;

                        // new start
                        l = r ;
                        r++ ;
                        wordsLine = words[l].length() ;
                    }
                }
            } if (r==words.length){
                int gapNum = (r - l) ; // r must be > l
                int gapLen = 1 ;
                StringBuilder gap = new StringBuilder(); for(int i=0; i<gapLen; i++) gap.append(gapStr) ;
                int lastGapLen = maxWidth - (wordsLine) - (gapLen*(gapNum-1)) ;
                StringBuilder lastGap = new StringBuilder(); for(int i=0; i<lastGapLen; i++) lastGap.append(gapStr) ;

                StringBuilder sb = new StringBuilder() ;
                int index = l ;
                while(index <r-1){ // while() {} if() {}
                    sb.append(words[index] + ((index==r-1)?(lastGap):(gap))) ; // 因为是以字符串作为坐标判断其后面的空格
                    index++ ;
                } if (index==r-1) {
                    sb.append(words[index] + ((index==r-1)?(lastGap):(gap))) ;
                }

                ans.add(sb.toString()) ;

            }
            return ans;
        }
    }
}
