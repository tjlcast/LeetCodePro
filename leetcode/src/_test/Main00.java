package _test;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/4/5.
 */
class Main00 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            long n = sc.nextInt();
            long m = sc.nextInt();
            long times = n / m / 2;
            long sum = 0;
            for(long i = 1;i <= 2 * m;i++) {
                if(i <= m) {
                    sum -= i;
                }else {
                    sum += i;
                }
            }
            System.out.println(times * sum);
        }
        sc.close();
    }
}