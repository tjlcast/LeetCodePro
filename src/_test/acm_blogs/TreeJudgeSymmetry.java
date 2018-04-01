package _test.acm_blogs;

import Type.TreeNode;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/4/1.
 */
public class TreeJudgeSymmetry {

    static class Solution {
        public boolean work(TreeNode root) {
            if (root == null) return true ;

            return isSame(root.left, root.right) ;
        }

        private boolean isSame(TreeNode leftRoot, TreeNode rightRoot) {
            if (rightRoot==null && leftRoot==null) return true ;
            if (!(rightRoot!=null && leftRoot!=null)) return false ;

            if (rightRoot.val != leftRoot.val) return false ;

            if (isSame(leftRoot.left, rightRoot.right) && isSame(leftRoot.right, rightRoot.left)) return true ;
            return false ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int[] nums = new int[n] ;

        for (int i = 0; i <n; i++) {
            nums[i] = sc.nextInt() ;
        }

        TreeNode root = buildTree(nums, 1) ;
        boolean work = new Solution().work(root);

        System.out.println(work) ;
    }

    private static TreeNode buildTree(int[] nums, int idx) {
        if (idx<=0 || idx>nums.length) return null ;

        TreeNode node = new TreeNode(nums[idx-1]) ;
        node.left = buildTree(nums, idx*2) ;
        node.right = buildTree(nums, idx*2+1) ;

        return node ;
    }
}
