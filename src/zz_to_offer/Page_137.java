package zz_to_offer;

import Type.TreeNode;
import Utils.TreeUtils;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2017/8/25.
 */
public class Page_137 {
    /**
     * 从上往下打印二叉树
     */
    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0} ;
        TreeNode treeNode = TreeUtils.buildTreeFromArr(nodes);
        new Page_137().work(treeNode); ;
    }

    public void work(TreeNode root) {
        new MySolution().printFromTopToBottom(root);
    }

    class MySolution {
        LinkedList<TreeNode> queue = new LinkedList<>() ;

        public void printFromTopToBottom(TreeNode root) {
            printBFS(root);
        }

        private void printBFS(TreeNode root) {
            if (root == null) throw new NullPointerException("the root of tree is null") ;
            queue.add(root) ;

            while(!queue.isEmpty()) {
                TreeNode pop = queue.pop();

                // do something
                System.out.println(pop.val);

                // next nodes
                if (pop.left!=null) queue.add(pop.left) ;
                if (pop.right!=null) queue.add(pop.right) ;
            }
            return ;
        }
    }
}
