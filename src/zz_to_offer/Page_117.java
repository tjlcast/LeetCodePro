package zz_to_offer;

import Type.TreeNode;
import Utils.TreeUtils;

/**
 * Created by tangjialiang on 2017/8/24.
 */
public class Page_117 {
    /**
     * 输入两个二叉树A和B，判断B是不是A的子结构
     * @param args
     */
    public static void main(String[] args) {
        int[] treeA = {1, 2, 3, 4, 5, 6} ;
        int[] treeB = {4, 5} ;


        TreeNode treeNodeA = TreeUtils.buildTreeFromArr(treeA);
        TreeNode treeNodeB = TreeUtils.buildTreeFromArr(treeB);

        boolean work = new Page_117().work(treeNodeA, treeNodeB);
        System.out.println("work is: " + work) ;
    }

    public boolean work(TreeNode tree1, TreeNode tree2) {
        return new MySolution().doesTree1HaveTree2(tree1, tree2) ;
    }

    class MySolution {
        boolean doesTree1HaveTree2(TreeNode tree1, TreeNode tree2) {
            // travel all nodes of tree1 and judge trees are same.
            if (tree1==null && tree2==null) return true ;
            if (tree1==null && tree2!=null) return false ;

            if (isSameTree(tree1, tree2)) return true ;

            return doesTree1HaveTree2(tree1.left, tree2) | doesTree1HaveTree2(tree1.right, tree2) ;
        }

        private boolean isSameTree(TreeNode rootA, TreeNode rootB) {
            if (rootA==null && rootB==null) return true ;
            if (rootA==null || rootB==null) return false ;

            if (rootA.val != rootB.val) return false ;

            return  isSameTree(rootA.left, rootB.left) & isSameTree(rootA.right, rootB.right) ;
        }
    }
}
