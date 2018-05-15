package zz_to_to_offer.page;

import Type.TreeNode;

import java.util.LinkedList;

/**
 * Created by tangjialiang on 2018/2/26.
 */
public class Page54 {
    /*
    * 树遍历相关
    *
    * 先序，中序，后序，宽度
    * */

    public static void preTravel(TreeNode root) {
        if (root != null) {
            System.out.println(root.val) ;
            preTravel(root.left) ;
            preTravel(root.right) ;
        }
    }

    public static void midTravel(TreeNode root) {
        if (root != null) {
            midTravel(root.left) ;
            System.out.println(root) ;
            midTravel(root.right) ;
        }
    }

    public static void afterTravel(TreeNode root) {
        if (root != null) {
            afterTravel(root.left) ;
            afterTravel(root.right) ;
            System.out.println(root.val) ;
        }
    }

    public static void bfs(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>() ;

        if (root != null) queue.addLast(root);

        while(!queue.isEmpty()) {
            TreeNode remove = queue.remove();
            if (remove==null) continue;

            System.out.println(remove.val) ;

            if (remove.left != null) queue.addLast(remove.left);
            if (remove.right != null) queue.addLast(remove.right);
        }
    }
}
