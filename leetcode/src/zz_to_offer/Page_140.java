package zz_to_offer;

/**
 * Created by tangjialiang on 2017/8/25.
 */
public class Page_140 {
    /**
     * 输入一个整数，判断该数组是不是某二叉搜索树的后序遍历的结果。
     */

    public static void main(String[] args) {
        int[] nums = {5, 6, 6, 9, 11, 10, 8} ;

        boolean work = new Page_140().work(nums);
        System.out.println("work is: " + work) ;
    }

    public boolean work(int[] nums) {
        boolean b = new MySolution().verifySquenceOfBST(nums, nums.length);
        return b ;
    }

    class MySolution {
        public boolean verifySquenceOfBST(int[] sequence, int len) {
            return judge(sequence, 0, sequence.length) ;
        }

        private boolean judge(int[] sequence, int begin, int len) {
            if (len==1 || len==0) return true ;

            int nodeVal = sequence[begin + len - 1] ;
            int pos = begin ; // for bigger is closure
            while (pos<begin+len-1-1 && sequence[pos]<nodeVal) {
                pos++ ;
            }

            int flag = pos ;

            while(pos < begin+len-1-1) {
                if (sequence[pos] < nodeVal) return false ;
                pos++ ;
            }

            return judge(sequence, begin, flag-begin+1) & judge(sequence, flag, len - flag + begin - 1) ;

        }
    }
}
