package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/29.
 */
public class Page_177 {
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印拼接出的最小一个。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3, 32, 321} ;

        int work = new Page_177().work(nums);
        System.out.println("work is: " + work) ;
    }

    public int work(int[] nums) {
        return new MySollution().computeMinNumber(nums) ;
    }

    class MySollution {
        public int computeMinNumber(int[] numbers) {
            // convert int 2 string
            String[] nums = new String[numbers.length] ;
            for(int i=0; i<numbers.length; i++) {
                nums[i] = numbers[i]+"" ;
            }

            sort(nums);

            StringBuilder sb = new StringBuilder() ;
            for(String s: nums) {
                sb.append(s) ;
                System.out.println(s) ;
            }

            int i = Integer.parseInt(sb.toString());
            return i ;
        }

        private void sort(String[] nums) {
            for(int i=0; i<nums.length; i++) {
                for(int j = i+1; j<nums.length; j++) {
                    if (compare(nums[i], nums[j]) > 0) {
                        String swap = nums[i] ;
                        nums[i] = nums[j] ;
                        nums[j] = swap ;
                    }
                }
            }
        }

        private int compare(String a, String b) {
            String ab = a + b ;
            String ba = b + a ;

            return ab.compareTo(ba) ;
        }
    }
}
