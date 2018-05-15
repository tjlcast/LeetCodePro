package Tree;

import Type.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tangjialiang on 2017/6/1.
 *
 */
public class _99_Recover_Binary_Search_Tree {

    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public void work(TreeNode root) {
        new Solution().recoverTree(root);
    }

    public class Solution {
        List<Integer> sb = new ArrayList<Integer>() ;
        int position = 0 ;

        void recoverTree(TreeNode root) {
            // get the sorted string
            inTravel(root);

            // sort the array 
            Collections.sort(sb);
         
            // add the arr to tree
            addArr(root) ;
        }

        private void addArr(TreeNode root) {
        	if (root == null) return ;
        	
        	addArr(root.left) ;
        	if (root.val != sb.get(position)) {
        		root.val = sb.get(position) ;
        	}
        	position+=1 ;
        	addArr(root.right);

        }

        private void inTravel(TreeNode root) {
            if (root == null) return  ;

            inTravel(root.left);
            sb.add(root.val) ;
            inTravel(root.right);

        }

    }
}
