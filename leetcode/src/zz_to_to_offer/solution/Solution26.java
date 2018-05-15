package zz_to_to_offer.solution;

import Type.TreeNode;

/**
 * Created by tangjialiang on 2018/4/25.
 */
public class Solution26 {

    static public class Solution {
        TreeNode head = new TreeNode(-1) ;
        TreeNode lastNode = head ;

        public TreeNode Convert(TreeNode pRootOfTree) {
            afterT(pRootOfTree);
            if (head.right != null) head.right.left = null ;
            return head.right ;
        }

        public void afterT(TreeNode root) {
            if (root == null) return ;

            afterT(root.left);
            root.left = lastNode ;
            lastNode.right = root ;

            lastNode = root ;
            afterT(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5} ;
        TreeNode root = generateTree(arr, 0) ;

        Solution sol = new Solution() ;
        TreeNode convert = sol.Convert(root);

        TreeNode node = convert ;
        while(node != null) {
            System.out.println(node.val) ;
            node = node.right ;
        }
    }

    private static TreeNode generateTree(int[] arr, int pos) {
        if (pos<0 || pos>=arr.length) return null ;

        TreeNode treeNode = new TreeNode(arr[pos]);
        treeNode.left = generateTree(arr, (pos+1)*2-1) ;
        treeNode.right = generateTree(arr, (pos+1)*2) ;

        return treeNode ;
    }

}
