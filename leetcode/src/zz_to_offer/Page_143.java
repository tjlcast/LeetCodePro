package zz_to_offer;

import Type.TreeNode;
import Utils.TreeUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tangjialiang on 2017/8/25.
 */
public class Page_143 {
    /**
     * 输入一颗二叉树和一个整树，打印出二叉树中节点值的和为输入整树的所有路径。根节点到叶子节点的和。
     */

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0} ;
        int sum = 10 ;
        TreeNode treeNode = TreeUtils.buildTreeFromArr(nodes);
        LinkedList<List> work = new Page_143().work(treeNode, sum);
        for(List<TreeNode> level : work) {
            for(TreeNode node : level) {
                System.out.print(node.val + " ") ;
            }
            System.out.println() ;
        }
    }

    public LinkedList<List> work(TreeNode root, int sum) {
        return new MySolution().findPath(root, sum);
    }

    class MySolution {
        // 有关List接口的复制，有两种:构造函数，addAll
        private Stack<TreeNode> stack = new Stack<>() ;
        private LinkedList<List> ans = new LinkedList<>() ;
        private int sum ;

        public LinkedList<List> findPath(TreeNode root, int sum) {
            this.sum = sum ;
            dfs(root, 0) ;
            return ans ;
        }

        private void dfs(TreeNode root, int parentsSum) {
            if (root == null) return ;

            stack.add(root) ;
            int curSum = parentsSum + root.val ;
            if (root.right==null && root.left==null && curSum==sum) {
                // the current node is a leaf and condition is pass
                ans.add(new LinkedList<TreeNode>(stack)) ;
            }
            dfs(root.left, curSum) ;
            dfs(root.right, curSum) ;

            stack.pop() ;
        }
    }
}
