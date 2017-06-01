package Tree;

import Type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/6/1.
 *
 */
public class _99_Recover_Binary_Search_Tree {

    public static void main(String[] args) {

    }

    public void work(TreeNode root) {
        new Solution().recoverTree(root);
    }

    public class Solution {
        List<Integer> sb = new ArrayList<Integer>() ;

        public void recoverTree(TreeNode root) {
            // get the sorted string
            int pos1 = -1 ;
            int pos2 = -1 ;
            inTravel(root);

            // find the wrong position
            for(int i=0; i<sb.size(); i++) {
                // judge forward
                if (i!=0) {
                    if (sb.get(i-1) - sb.get(i) > 0) {
                        pos1 = sb.get(i) ;
                    }
                }
                // judge backward
                if (i!=sb.size()-1) {
                    if (sb.get(i) - sb.get(i+1) > 0) {
                        pos2 = sb.get(i) ;
                    }
                }
            }



        }

        private void swap(TreeNode root, int oldVal, int newVal) {
            if (root==null) return ;

            swap(root.left) ;

        }

        private void inTravel(TreeNode root) {
            if (root == null) return  ;

            inTravel(root.left);
            sb.add(root.val) ;
            inTravel(root.right);

            return  ;
        }

    }
}
