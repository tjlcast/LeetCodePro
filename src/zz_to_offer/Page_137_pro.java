package zz_to_offer;

import Type.TreeNode;
import Utils.TreeUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/8/25.
 */
public class Page_137_pro {
    /**
     * 把二叉树的每层节点存入数组中
     */

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0} ;
        TreeNode treeNode = TreeUtils.buildTreeFromArr(nodes);

        LinkedList<List> work = new Page_137_pro().work(treeNode);
        for(List<TreeNode> level : work) {
            for (TreeNode node : level)
                System.out.print(node.val + " ");
            System.out.println() ;
        }
    }

    public LinkedList<List> work(TreeNode root) {
        return new MySolution().printBFS(root) ;
    }

    class MySolution {
        LinkedList<TreeNode> queue = new LinkedList<>() ;
        LinkedList<List> levels = new LinkedList<>() ;

        private LinkedList<List> printBFS(TreeNode root) {
            if (root == null) throw new NullPointerException("tree is null") ;
            queue.clear();

            LinkedList<TreeNode> curLevel = new LinkedList<>() ;
            levels.add(curLevel) ;
            queue.add(root) ;
            queue.add(new TreeNode(-1)) ; // for end flag of every level

            while(true) {
                TreeNode pop = queue.pop();
                if (pop.val == -1) {
                    // end for a level
                    if (queue.isEmpty()) break ;
                    curLevel = new LinkedList<>() ;
                    levels.add(curLevel) ;

                    queue.add(pop) ;
                } else {
                    curLevel.add(pop) ;
                    if(pop.left != null)queue.add(pop.left) ;
                    if(pop.right != null) queue.add(pop.right) ;
                }
            }
            return levels;
        }

    }
}
