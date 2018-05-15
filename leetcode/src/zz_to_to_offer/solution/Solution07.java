package zz_to_to_offer.solution;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/3/26.
 */
public class Solution07 {

    public class Solution {
        private HashMap<Integer, Integer> rec = new HashMap<>() ;

        public Solution() {
            rec.put(1, 1) ;
            rec.put(2, 2) ;
        }

        public int JumpFloor(int target) {
            if(rec.containsKey(target)) return rec.get(target) ;
            int val = JumpFloor(target-1) + JumpFloor(target-2) ;
            rec.put(target, val) ;

            return rec.get(target) ;
        }
    }
}
