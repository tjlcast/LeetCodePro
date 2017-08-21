package Utils;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2017/8/21.
 */
public class TreeUtils {

    /**
    *
    * create bTree from a array
    * by: tjlcast
    *
    * */
    public static TreeNode buildTreeFromArr(int[] arr) {
        TreeNode treeNode = createTreeNode(arr, 1);
        return treeNode ;
    }

    public static TreeNode createTreeNode(int[] arr, int pos) {
        int len = arr.length ;
        if (pos >= len) {
            return null ;
        }

        TreeNode treeNode = new TreeNode();
        treeNode.val = arr[pos - 1] ;

        treeNode.left = createTreeNode(arr, pos*2) ;
        treeNode.right = createTreeNode(arr, pos*2 + 1) ;

        return treeNode ;
    }

    /**
     *
     *  树的先序遍历
     *  by: tjlcast
     *
     */
    public static void preTravel(TreeNode node) {
        if (node != null) {
            System.out.println(node.val) ;
            preTravel(node.left);
            preTravel(node.right);
        }
    }


    /**
     *
     *  树的中序遍历
     *  by: tjlcast
     *
     * */
    public static void inTravel(TreeNode node) {
        if (node != null) {
            inTravel(node.left);
            System.out.println(node.val) ;
            inTravel(node.right);
        }
    }


    /**
     *
     *  树的后序遍历
     *  by: tjlcast
     *
     * */
    public static void afterTravel(TreeNode node) {
        if (node != null) {
            afterTravel(node.left);
            afterTravel(node.right);
            System.out.println(node.val) ;
        }
    }
}
