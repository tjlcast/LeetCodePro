package zz_to_to_offer.page;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2018/3/5.
 */
public class Page125 {
    public static void main(String[] args) {

    }

    public static TreeNode getTreeImage(TreeNode node) {
        return generateImgNode(node) ;
    }

    private static TreeNode generateImgNode(TreeNode root) {
        if (root == null) return null ;

        TreeNode node = new TreeNode(root.val) ;
        node.left = generateImgNode(root.right) ;
        node.right = generateImgNode(root.left) ;

        return node ;
    }
}
