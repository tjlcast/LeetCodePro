package zz_to_to_offer.solution;

import Type.TreeNode;

import java.util.ArrayList;

/**
 * Created by tangjialiang on 2018/4/24.
 */
public class Solution24 {

    static public class Solution {
        private ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            dfs(root, target, new ArrayList<>()) ;
            return ans ;
        }

        private void dfs(TreeNode root, int rest, ArrayList<Integer> curState) {
            if (root == null) {
                return ;
            }

            curState.add(root.val) ;
            if (root.left==null && root.right==null && rest==root.val) {
                ans.add(new ArrayList<>(curState)) ;
            }
            dfs(root.left, rest-root.val, curState) ;
            dfs(root.right, rest-root.val, curState) ;
            curState.remove(curState.size()-1) ;
        }
    }

    public static void main(String[] args) {

    }
}
