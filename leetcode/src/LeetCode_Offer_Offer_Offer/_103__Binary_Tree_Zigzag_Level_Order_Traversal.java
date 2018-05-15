package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

import java.util.* ;

/**
 * Created by tangjialiang on 2017/10/17.
 */
public class _103__Binary_Tree_Zigzag_Level_Order_Traversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> work(TreeNode root) {
        Solution sol = new Solution() ;
        List<List<Integer>> lists = sol.zigzagLevelOrder(root);

        return lists ;
    }

    class Solution {
        private List<List<Integer>> ans = new LinkedList<>() ;

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) return ans ;

            bfs(root) ;
            return ans ;
        }

        private void bfs(TreeNode root) {
            int step = 0 ;
            TreeNode endLineNode = new TreeNode(-1) ;
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>() ;
            LinkedList<Integer> line = new LinkedList<Integer>() ;

            queue.add(root) ;
            queue.add(endLineNode) ;

            while(queue.size() != 1) {
                TreeNode node = queue.pop() ;

                if(node.left!=null) queue.add(node.left) ;
                if(node.right!=null) queue.add(node.right) ;

                if (node != endLineNode) {
                    line.add(node.val) ;
                } else {
                    queue.add(node) ;
                    if (step % 2 ==1) {
                        Collections.reverse(line) ;
                    }
                    ans.add(line) ;
                    step++ ;
                    line = new LinkedList<Integer>() ;
                }
            }

            if (line.size()!=0) {
                if (step % 2 ==1) {
                    Collections.reverse(line) ;
                }
                ans.add(line) ;
            }
        }
    }
}
