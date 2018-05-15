package zz_to_offer;

import Type.TreeNode;
import Utils.TreeUtils;

/**
 * Created by tangjialiang on 2017/8/26.
 */
public class Page_151 {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中的节点指针的指向。
     * 比如输入二叉搜索树，输出转换之后的排序双向链表。
     */

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5, 6, 7, 8} ;
        int[] arr = {10, 6, 14, 4, 8, 12, 16} ;
        TreeNode treeNode = TreeUtils.buildTreeFromArr(arr);
        TreeNode work = new Page_151().work(treeNode);
        new Page_151().printLinkedListCycle(work);
    }

    public void printLinkedListCycle(TreeNode head) {
        if (head == null) return ;

        TreeNode node = head ;
        do {
            System.out.println(node.val) ;
            node = node.right ;
        } while(node.right != null) ;

        do {
            System.out.println(node.val) ;
            node = node.left ;
        } while(node.left != null) ;
    }

    public TreeNode work(TreeNode root) {
        return new MySolution().convert(root) ;
    }

    /**
     * 维护一个指向链表尾节点的指针。
     */
    class MySolution {

        private TreeNode head = new TreeNode(-1) ;
        private TreeNode parentNode = head ;

        public TreeNode convert(TreeNode root) {
            convertNode(root);
            return head.right ;
        }

        private void convertNode(TreeNode node) {
            if (node == null) return ;

            convertNode(node.left) ;

            System.out.println("node: " + node.val) ;
            parentNode.right = node ;
            node.left = parentNode ;
            parentNode = node ;

            convertNode(node.right) ;
        }
    }


}
