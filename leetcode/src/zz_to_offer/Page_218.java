package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/31.
 */
public class Page_218 {
    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
     * 例如输入字符串"I am a student."，则输出"student. a am I"。
     * @param args
     */

    public static void main(String[] args) {
        String words = "I am a Student." ;
        Page_218 page_218 = new Page_218();
        String work = page_218.work(words);

        System.out.println(work) ;
    }

    String work(String str) {
        MySolution mySolution = new MySolution();
        String reverse = mySolution.reverse(str);
        return reverse ;
    }

    class MySolution {
        String reverse(String str) {
            String[] split = str.split(" ");

            StringBuilder sb = new StringBuilder() ;
            for(int i=split.length-1; i>=0; i--) {
                String word = (i == 0) ? (split[i]) : (split[i]+" ") ;
                sb.append(word) ;
            }

            return sb.toString() ;
        }


    }
}
