package zz_to_to_offer.solution;

import Type.TreeNode;

import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/3/28.
 */
public class Solution18 {
    static public class Solution {
        public void Mirror(TreeNode root) {
            if (root == null) return ;

            TreeNode left = root.left ;
            TreeNode right = root.right ;

            root.left = right ;
            root.right = left ;

            Mirror(root.left);
            Mirror(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int[] arr = new int[n] ;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt() ;
        }

        TreeNode root = buildTree(arr) ;

        Solution sol = new Solution() ;
        sol.Mirror(root);

        printTree(root) ;
    }

    private static void printTree(TreeNode root) {
        if (root == null) return ;
        printTree(root.left);
        System.out.println(root.val) ;
        printTree(root.right);
    }

    private static TreeNode buildTree(int[] arr) {
        return buildTree(arr, 1);
    }

    private static TreeNode buildTree(int[] arr, int i) {
        if (i<1 || i>arr.length) return null ;

        TreeNode node = new TreeNode(arr[i-1]) ;
        node.left = buildTree(arr, i*2) ;
        node.right = buildTree(arr, i*2+1) ;
        return node ;
    }
}
