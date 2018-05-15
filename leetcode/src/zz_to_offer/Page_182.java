package zz_to_offer;

import java.util.Vector;

/**
 * Created by tangjialiang on 2017/8/29.
 */
public class Page_182 {
    /**
     * 我们把只包含因子2／3和5的数称作丑数（ugly number），求按从小到大的顺序的第1500个丑数。
     * 例如6／8都是丑数，单14不是，因为它包含因子7。习惯上我们把1当作第一个丑数。
     * @param args
     */
    public static void main(String[] args) {
        int index = 19 ;
        Page_182 page_182 = new Page_182();
        int work = page_182.work(index);
        System.out.println("work: " + work) ;

    }

    public int work(int index) {
        MySolution mySolution = new MySolution();
        int uglyNumber = mySolution.getUglyNumber(index);
        mySolution.showDatas();
        return uglyNumber ;
    }

    class MySolution {
        private Vector<Integer> uNums = new Vector<>() ;
        private int curMaxNum = Integer.MIN_VALUE ;

        public MySolution() {
            uNums.add(2) ;
            uNums.add(3) ;
            uNums.add(5) ;
            curMaxNum = 5 ;
        }

        public int getUglyNumber(int index) {
            if (index <= 3) {
                return uNums.get(index-1) ;
            }

            while(uNums.size() != index) {
                int addNum = Integer.MAX_VALUE ;
                // add next ugly number

                // for 2
                for(Integer i: uNums) {
                    int num = i * 2 ;
                    if (num > curMaxNum && addNum>num) {
                        addNum = num ;
                    }
                }
                // for 3
                for(Integer i: uNums) {
                    int num = i * 3 ;
                    if (num > curMaxNum && addNum>num) {
                        addNum = num ;
                    }
                }
                // for 5
                for(Integer i: uNums) {
                    int num = i * 5 ;
                    if (num > curMaxNum && addNum>num) {
                        addNum = num ;
                    }
                }

                uNums.add(addNum) ;
                curMaxNum = addNum ;
            }

            return uNums.get(uNums.size()-1) ;
        }

        public void showDatas() {
            for(int i: uNums) {
                System.out.print(i + " ") ;
            }
            System.out.println() ;
        }
    }
}
