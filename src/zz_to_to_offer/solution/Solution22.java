package zz_to_to_offer.solution;

import Type.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by tangjialiang on 2018/4/23.
 */
public class Solution22 {

    static public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> ans = new ArrayList<>() ;
            LinkedList<TreeNode> queue = new LinkedList<>() ;

            if (root != null) queue.addLast(root);
            while(!queue.isEmpty()) {
                TreeNode node = queue.removeFirst();
                ans.add(node.val) ;

                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            return ans ;
        }
    }

    public static void main(String[] args) {

    }
}
