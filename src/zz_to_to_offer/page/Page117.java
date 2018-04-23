package zz_to_to_offer.page;

import Type.TreeNode;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by tangjialiang on 2018/2/27.
 */
public class Page117 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> Tmapper = new HashMap<>() ;
        Hashtable<Integer, Integer> Hmapper = new Hashtable<>() ;
    }

    public static boolean isInnerTree(TreeNode rootA, TreeNode rootB) {
        if (rootA == null) {
            if (rootB == null) return false ;
            return true ;
        }

        if (isSmall(rootA, rootB)) return true ;
        return isInnerTree(rootA.left, rootB) || isInnerTree(rootA.right, rootB);

    }

    private static boolean isSmall(TreeNode rootA, TreeNode rootB) {
        if (rootB == null) return true ;
        if (rootA == null) return false ;

        if (rootA.val != rootB.val) return false ;
        return isSmall(rootA.left, rootB.left) && isSmall(rootA.right, rootB.right) ;
    }
}
