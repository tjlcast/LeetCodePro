package zz_to_offer;

import Type.TreeNode;
import Utils.TreeUtils;

/**
 * Created by tangjialiang on 2017/8/24.
 */
public class Page_126 {
    /**
     * 输入一个二叉树，输出树的镜像。[镜像：交换每个节点的子节点的位子]
     * @param args
     */
    public static void main(String[] args) {
        int[] tree = {1, 2, 3, 4, 5, 6, 7} ;
        TreeNode treeNode = TreeUtils.buildTreeFromArr(tree);
        TreeNode work = new Page_126().work(treeNode);

        TreeUtils.preTravel(work);
    }

    public TreeNode work(TreeNode node) {
        return new MySolution().mirrorRecursively(node) ;
    }

    class MySolution{
        public TreeNode mirrorRecursively(TreeNode node) {
            // change children positions node by node
            if (node == null) return null ;

            // swap children
            TreeNode tmp = node.left ;
            node.left = node.right ;
            node.right = tmp ;

            node.left = mirrorRecursively(node.left) ;
            node.right = mirrorRecursively(node.right) ;

            return node ;
        }

    }
}
