package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/28.
 */
public class _102_Binary_Tree_Level_Order_Traversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> work(TreeNode root) {
        Solution sol = new Solution() ;
        return sol.levelOrder(root) ;
    }

    class Solution {

        private List<List<Integer>> ans = new ArrayList<List<Integer>>() ;

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return ans ;

            bfs(root) ;
            return ans ;
        }

        private void bfs(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>() ;
            TreeNode endLineNode = new TreeNode(-1) ;
            LinkedList<Integer> line = new LinkedList<Integer>() ;

            queue.add(root) ;
            queue.add(endLineNode) ;

            while(queue.size() != 1) {
                TreeNode node = queue.pop() ;
                System.out.println("val: " + node.val) ;

                if (node.left!=null) queue.add(node.left) ;
                if (node.right!=null) queue.add(node.right) ;

                if (node != endLineNode) {
                    line.add(node.val) ;
                } else {
                    queue.add(node) ;

                    ans.add((List)line) ;
                    line = new LinkedList<Integer>() ;
                }
            }

            if(line.size()!=0) ans.add((List)line) ;
            return ;
        }
    }
}
