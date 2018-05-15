package zz_to_offer;

import Type.TreeNode;
import Utils.TreeUtils;

/**
 * Created by tangjialiang on 2017/8/30.
 */
public class Page_207 {
    /**
     * 输入一颗二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根节点／叶节点）
     * 形成树的一条路径，最长路径的长度为树的深度。
     */

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} ;
        TreeNode treeNode = TreeUtils.buildTreeFromArr(nodes);

        Page_207 page_207 = new Page_207();
        int work = page_207.work(treeNode);
        System.out.println("work is: " + work) ;
    }

    public int work(TreeNode root) {
        MySolution mySolution = new MySolution();
        int i = mySolution.treeDepth(root);
        return i ;
    }

    class MySolution {
        private int maxDepth = Integer.MIN_VALUE ;

        public int treeDepth(TreeNode root) {
            dfs(root, 0);
            return this.maxDepth ;
        }

        private void dfs(TreeNode root, int depth) {
            if (root == null) {
                return ;
            }

            int curDepth = depth + 1 ;
            if (root.left==null && root.right==null) {
                maxDepth = (maxDepth < curDepth) ? (curDepth) : (maxDepth) ;
            }

            dfs(root.left, curDepth);
            dfs(root.right, curDepth);
        }
    }
}
