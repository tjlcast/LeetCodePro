package zz_to_to_offer.page;

/**
 * Created by tangjialiang on 2018/2/26.
 */
public class Page44 {

    public String solution(String str) {
        StringBuilder sb = new StringBuilder() ;

        for(int i=0; i<str.length(); i++) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i)) ;
            } else {
                sb.append('0') ;
            }
        }

        return sb.toString() ;
    }

    public static void main(String[] args) {
        String str = "hello world, this is tjlcast" ;

        Page44 page = new Page44() ;
        String solution = page.solution(str);

        System.out.println(solution) ;
    }
}
