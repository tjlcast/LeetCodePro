package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/31.
 */
public class _257_Binary_Tree_Paths {

    public static void main(String[] args) {

    }

    static class Solution {
        List<String> ans = new LinkedList<>() ;

        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) return ans ;

            dfs(root, root.val+"") ;
            return ans ;
        }

        private void dfs(TreeNode root, String path) {
            if (root == null) return ;

            if (root.left==null && root.right==null) {
                ans.add(path) ;
                return ;
            }

            if (root.left!=null)dfs(root.left, path +"->"+ root.left.val) ;
            if (root.right!=null)dfs(root.right, path +"->"+ root.right.val) ;

            return ;
        }
    }
}
