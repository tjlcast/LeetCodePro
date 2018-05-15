package LeetCode_Offer_Offer_Offer;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2018/1/24.
 */
public class _222_Count_Complete_Tree_Nodes {

    public static void main(String[] args) {
        TreeNode root = null ;

        Solution sol = new Solution() ;
        int ans = sol.countNodes(root) ;

        System.out.println("The work is: " + ans) ;
    }

    static class Solution {

        public int countNodes(TreeNode root) {
            if (root == null) return 0 ;

            int h = getHeight(root) ;
            int lastLevelNo = findLastNode(root, 0) ;

            int aboveTotal = ((h==1)?(0):(1<<(h-1)) - 1) ;
            int lastTotal = (lastLevelNo+1) ;
            return aboveTotal + lastTotal ;
        }

        public int findLastNode (TreeNode root, int no) {
            //System.out.println("no : " + no) ;
            if (root.left==null && root.right==null) {
                return no ;
            }

            int lHight = getHeight(root.left) ;
            int rHight = getHeight(root.right) ;

            int nextNo ;
            TreeNode nextNode ;
            if (lHight > rHight) {
                nextNo = (no<<1) ;
                nextNode = root.left ;
            }else {
                nextNo = ((no<<1)+1) ;
                nextNode = root.right ;
            }

            return findLastNode(nextNode, nextNo) ;
        }

        public int getHeight(TreeNode root) {
            if (root == null) return 0 ;

            return 1 + getHeight(root.left) ;
        }
    }
}
