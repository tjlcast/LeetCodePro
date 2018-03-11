package pros;

import Type.TreeNode;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2018/3/11.
 */
public class Page115 {

    public static HashMap<Integer, Integer> recorders = new HashMap<>() ;
    static {
        recorders.put(0, -1) ;
    }
    public static int maxDeep = 0 ;

    public static void main(String[] args) {
        TreeNode root = null ;
        int preSum = 0 ;
        int target = 4 ;
        maxD(root, preSum, target, 1);
    }

    public static void maxD(TreeNode root, int preSum, int target, int level) {
        if (root == null) {
            return ;
        }

        int sum = preSum + root.val ;
        int rest = sum - target ;
        if (recorders.containsKey(rest)) {
            maxDeep = Math.max(maxDeep, level - recorders.get(rest)) ;
        }

        maxD(root.left, sum, target, level+1) ;
        maxD(root.right, sum, target, level+1) ;
    }
}
