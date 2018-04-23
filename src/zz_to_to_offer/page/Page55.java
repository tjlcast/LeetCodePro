package zz_to_to_offer.page;


import Type.TreeNode;

/**
 * Created by tangjialiang on 2018/2/26.
 */
public class Page55 {
    /*输入二叉树的前序和中序的遍历结果，重建该二叉树*/

    public static TreeNode solution(int[] preList, int[] midList) {
        int len = preList.length ;
        if (len == 0) {
            return null ;
        }
        TreeNode treeNode = new TreeNode(preList[0]);
        if (len == 1) {
            return treeNode ;
        }

        int val = preList[0] ;
        int pos = 0 ;
        while(midList[pos] != val) {pos++; }

        int len1 = pos ;
        int len2 = len - len1 - 1 ;

        treeNode.left = solution(subArr(preList, 1, len1), subArr(midList, 0, len1)) ;
        treeNode.right = solution(subArr(preList, 1+len1, len2), subArr(midList, 1+len1, len2)) ;

        return treeNode ;
    }

    public static int[] subArr(int[] arr, int pos, int len) {
        int[] ans = new int[len] ;

        for(int i=0; i<len; i++) {
            ans[i] = arr[pos+i] ;
        }

        return ans ;
    }

    public static void main(String[] args) {
        int[] preList = {1, 2, 4, 7, 3, 5, 6, 8} ;
        int[] midList = {4, 7, 2, 1, 5, 3, 8, 6} ;

        Page55 page = new Page55() ;
        TreeNode solution = Page55.solution(preList, midList);

        Page55.preTravel(solution);
    }

    public static void preTravel(TreeNode root) {
        if (root != null) {
            System.out.println(root.val) ;
            preTravel(root.left) ;
            preTravel(root.right) ;
        }
    }

    public static void midTravel(TreeNode root) {
        if (root != null) {
            midTravel(root.left) ;
            System.out.println(root.val) ;
            midTravel(root.right) ;
        }
    }
}
