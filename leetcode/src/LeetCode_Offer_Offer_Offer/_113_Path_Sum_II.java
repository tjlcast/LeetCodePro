package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/11/18.
 */
public class _113_Path_Sum_II {

    class Solution {
        private LinkedList<Integer> stack = new LinkedList<Integer>() ;
        private LinkedList<List<Integer>> set = new LinkedList<List<Integer>>() ;

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) {
                return set ;
            }
            findSum(root, sum) ;
            return set ;
        }

        private void findSum(TreeNode root, int rest) {
            if (root.left==null && root.right==null) {
                stack.addLast(root.val) ;
                if (root.val==rest) {
                    set.add((List<Integer>)stack.clone()) ;
                }
                stack.removeLast() ;
            }

            stack.addLast(root.val) ;

            if (root.left!=null) {
                findSum(root.left, rest-root.val) ;
            }
            if (root.right != null) {
                findSum(root.right, rest-root.val) ;
            }

            stack.removeLast() ;
        }
    }
}
