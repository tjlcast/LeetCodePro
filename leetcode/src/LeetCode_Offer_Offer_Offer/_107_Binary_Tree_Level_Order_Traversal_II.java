package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/10/25.
 */
public class _107_Binary_Tree_Level_Order_Traversal_II {

    public static void main(String[] args) {

    }


    public List<List<Integer>> work(TreeNode root) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrderBottom(root);

        return lists ;
    }


    class Solution {
        private LinkedList<List<Integer>> ans = new LinkedList<>() ;

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            // border
            if (root == null) return ans ;

            LinkedList<TreeNode> queue = new LinkedList<>() ;
            List<Integer> line = new LinkedList<>() ;

            TreeNode end = new TreeNode(-1) ;
            queue.addLast(root); ;
            queue.addLast(end); ;

            while(queue.size()!=1) {
                TreeNode treeNode = queue.removeFirst();

                if (treeNode != end) {
                    line.add(treeNode.val) ;
                    if (treeNode.left != null) queue.addLast(treeNode.left);
                    if (treeNode.right != null) queue.addLast(treeNode.right);
                } else {
                    queue.addLast(treeNode);
                    ans.addFirst(line);
                    line = new LinkedList<>() ;
                }
            }

            if (line.size() != 0) ans.addFirst(line);

            return ans ;
        }
    }
}
