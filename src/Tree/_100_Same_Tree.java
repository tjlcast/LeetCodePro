package Tree;


import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/5/31.
 */
public class _100_Same_Tree {

    public static void main(String[] args) {

    }

    public boolean work(TreeNode p, TreeNode q) {
        return new Solution().isSameTree(p, q) ;
    }


    public class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p==null && q==null) return true ;

            if (p!=null && q!=null && p.val == q.val){
                boolean ans = isSameTree(p.left, q.left) && isSameTree(p.right, q.right) ;
                return ans ;
            }

            return false ;
        }
    }
}
