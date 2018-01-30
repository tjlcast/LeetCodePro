package TheSmartUtils;

/**
 * Created by tangjialiang on 2018/1/28.
 */
public class FastExponentiation {

    public static void main(String[] args) {
        int a = 2 ;
        int b = 10 ;
        int c = 3 ;

        int ans = FastExponentiation.solution(a, b, c) ;
        System.out.println("The result is: " + ans) ;
    }

    /**
     * a^b mod c = (a^2)^(b/2) mod c , b为偶数
     * a^b mod c = ((a^2)^(b/2)·a) mod c , b为奇数
     *
     * 2^10=(2^2)^5=(2^2)*[(2^2)^2]^2
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int solution(int a, int b, int c) {
        int ans = 1 ;
        for(; b!=0; b=b/2) {
            if (b%2 == 1) {
                ans = (ans * a) % c ;
            }
            a = (a * a) % c ;
        }
        return ans ;
    }
}
