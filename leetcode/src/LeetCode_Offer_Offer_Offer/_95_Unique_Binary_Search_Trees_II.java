package LeetCode_Offer_Offer_Offer;


import Type.TreeNode;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by tangjialiang on 2017/9/21.
 */
public class _95_Unique_Binary_Search_Trees_II {
    /**
     * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

     For example,
     Given n = 3, your program should return all 5 unique BST's shown below.

     1         3     3      2      1
     \       /     /      / \      \
     3     2     1      1   3      2
     /     /       \                 \
     2     1         2                 3
     */

    public static void main(String[] args) {

    }

    public List<TreeNode> work(int n) {
        Solution solution = new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(n);

        return treeNodes ;
    }

    class Solution {
        private List<TreeNode> ans = new LinkedList<>() ;

        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> treeNodes = generateTree(1, n);

            return treeNodes ;
        }

        private List<TreeNode> generateTree(int l, int r) {
            List<TreeNode> trees = new LinkedList<>() ;
            if (l > r) {
                return trees ;
            }
            if (l == r) {
                trees.add(new TreeNode(l)) ;
                return trees ;
            }

            for(int i=l; i<=r; i++) {
                System.out.println("i: " + i) ;

                List<TreeNode> leftTrees = generateTree(l, i-1) ;
                List<TreeNode> rightTrees = generateTree(i+1, r) ;
                TreeNode node = new TreeNode(i) ;

                if (leftTrees.isEmpty()) {
                    for(TreeNode rightNode: rightTrees) {
                        node.left = null ;
                        node.right = rightNode ;

                        trees.add(copyTree(node)) ;
                    }
                } else if(rightTrees.isEmpty()) {
                    for(TreeNode leftNode : leftTrees) {
                        node.left = leftNode ;
                        node.right = null ;

                        trees.add(copyTree(node)) ;
                    }
                } else {
                    for(TreeNode leftNode : leftTrees) {
                        for(TreeNode rightNode: rightTrees) {
                            node.left = leftNode ;
                            node.right = rightNode ;

                            trees.add(copyTree(node)) ;
                        }
                    }
                }
            }

            return trees ;
        }

        private TreeNode copyTree(TreeNode root) {
            if (root == null) return null ;

            TreeNode node = new TreeNode(root.val) ;
            node.left = copyTree(root.left) ;
            node.right = copyTree(root.right) ;

            return node ;
        }
    }
}
