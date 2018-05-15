package zz_to_to_offer.solution;

import Type.ListNode;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/3/26.
 */
public class Solution01 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>() ;

        ListNode node = listNode ;
        while(node != null) {
            ans.add(node.val) ;
            node = node.next ;
        }

        Collections.reverse(ans);
        return ans ;
    }

    public static void main(String[] args) {

    }
}