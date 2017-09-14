package zz_to_offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/8/30.
 */
public class Page_209 {
    /**
     * 输入一颗二叉树的根节点，判断该树是不是平衡二叉树。
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么他就是一颗
     * 平衡二叉树。
     */
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        MySolution mySolution = new MySolution();
        boolean balanced = mySolution.isBalanced(root);
        return balanced ;
    }

    class MySolution {
        private boolean isBalanced = true ;

        public boolean isBalanced(TreeNode root) {
            dfs(root) ;
            return isBalanced ;
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0 ;
            if (isBalanced==false) return 0 ;

            int l = dfs(root.left);
            int r = dfs(root.right);
            if (Math.abs(l-r)>1) {
                isBalanced = false ;
            }

            int cur = Math.max(l, r) + 1;
            return cur ;
        }
    }
}
