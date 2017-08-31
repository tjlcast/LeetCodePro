package Utils;

import Type.TreeNode;

import java.util.LinkedList;

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
        if (pos > len) {
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


    /**
     * 计算树的深度(DFS)
     * @param root
     * @return
     */
    public static int treeDepth(TreeNode root) {
        if (root == null) return 0 ;

        int leftChildDep = treeDepth(root.left);
        int rightChildDep = treeDepth(root.right) ;

        int max = Math.max(leftChildDep, rightChildDep);
        int curD = max + 1 ;
        return curD ;
    }

    /**
     * 计算树的深度(BFS)
     * @param root
     * @return
     */
    public static int treeDepthBFS(TreeNode root) {
        int dep = 0 ;
        LinkedList<TreeNode> queue = new LinkedList<>() ;
        TreeNode end = new TreeNode(-1) ;
        queue.add(root) ;
        queue.add(end) ;

        while(queue.size() != 1) {
            TreeNode pop = queue.pop();

            if (pop == end) {
                // finish a line
                queue.add(pop) ;
                dep += 1 ;
            } else {
                queue.add(pop.left) ;
                queue.add(pop.right) ;
            }
        }
        return dep ;
    }

}
