package zz_to_to_offer.solution;

import Type.TreeNode;
import java.util.* ;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by tangjialiang on 2018/3/26.
 */
public class Solution17 {

    static public class Solution {
        public boolean HasSubtree(TreeNode root1, TreeNode root2) {
            if (root1==null || root2==null) return false ;
            if (isSame(root1, root2)) {
                return true ;
            }
            boolean ans1 = HasSubtree(root1.left, root2) ;
            if (ans1) return true ;
            boolean ans2 = HasSubtree(root1.right, root2) ;
            if (ans2) return true ;
            return false ;
        }

        private boolean isSame(TreeNode root1, TreeNode root2) {
            if (root2 == null) return true ;

            if (root1 == null) return false ;
            if (root2.val != root1.val) return false ;

            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right) ;
        }
    }

    public static void main(String[] args) {
        String str1 = "8,8,7,9,3,#,#,#,#,4,7" ;
        String str2 = "8,9,2" ;

        List<Character> ints1 = Arrays.stream(str1.split(",")).map(x -> (Character) x.charAt(0)).collect(Collectors.toList());
        List<Character> ints2 = Arrays.stream(str2.split(",")).map(x -> (Character) x.charAt(0)).collect(Collectors.toList());

        TreeNode root1 = buildTree(ints1, 1) ;
        TreeNode root2 = buildTree(ints2, 1) ;

        Solution sol = new Solution() ;
        boolean b = sol.HasSubtree(root1, root2);

        System.out.println(b) ;
    }

    private static TreeNode buildTree(List<Character> arr, int i) {
        if (i > arr.size() || arr.get(i-1)=='#') return null ;

        int val = arr.get(i-1) - '0' ;
        TreeNode node = new TreeNode(val) ;

        node.left = buildTree(arr, i*2) ;
        node.right = buildTree(arr, i*2+1) ;

        return node ;
    }
}
