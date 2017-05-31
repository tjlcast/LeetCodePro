package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tangjialiang on 2017/5/31.
 */
public class _47_Permutations_II {
    public static void main(String[] args) {
        int[] nums = {1,1,2} ;
        List<List<Integer>> work = new _47_Permutations_II().work(nums);
        System.out.println("work: " + work) ;
    }

    public List<List<Integer>> work(int[] nums) {
        return new Solution().permuteUnique(nums) ;
    }



    public class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            Arrays.sort(nums);
            dfs(res, visited, nums, new ArrayList<>());
            return res;
        }

        public void dfs(List<List<Integer>> res, boolean[] visited, int[] nums, List<Integer> tempList) {
            if (tempList.size() == nums.length) {
                res.add(tempList);
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (i != 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
                    if (!visited[i]) {
                        visited[i] = true;
                        tempList.add(nums[i]);
                        dfs(res, visited, nums, new ArrayList<>(tempList));
                        tempList.remove(tempList.size() - 1);
                        visited[i] = false;
                    }
                }
            }
        }
    }











}
