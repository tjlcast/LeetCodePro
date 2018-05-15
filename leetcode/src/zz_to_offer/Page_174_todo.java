package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/29.
 */
public class Page_174_todo {
    /**
     * 输入一个整数n,求从1到n这n个整数的十进制表示中1出现的次数。
     * 例如输入12，从1到12这些整数中包含1的数字有1，10，11和12，1一共出现了5次。
     */

    public static void main(String[] args) {
        int n = 12 ;
        int work = new Page_174_todo().work(n);
        System.out.println("work is : " + work) ;
    }

    public int work(int n) {
        int i = new MySolution().numberOf1Between1AndN(n);
        return i ;
    }

    class MySolution {
        public int numberOf1Between1AndN(int n) {

            return -1 ;
        }
    }
}
