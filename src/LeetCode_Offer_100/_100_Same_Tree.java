package LeetCode_Offer_100;

import Type.TreeNode;
import static java.lang.Math.max ;
import static java.lang.Math.min ;

/**
 * Created by tangjialiang on 2018/4/10.
 */
public class _100_Same_Tree {

    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p==null && q==null) return true ;
            if (p==null || q==null) return false ;

            if (p.val != q.val) return false ;

            if (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)) return false ;

            return true ;
        }
    }
}
