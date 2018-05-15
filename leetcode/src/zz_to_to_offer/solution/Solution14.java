package zz_to_to_offer.solution;

import Type.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.* ;

/**
 * Created by tangjialiang on 2018/3/26.
 */
public class Solution14 {

    static class Solution {
        public ListNode FindKthToTail(ListNode head, int k) throws Exception {
            if (k == 0) return null ;
            ListNode fast = head ;
            ListNode slow = head ;

            for(int i=1; i<k; i++) {
                if (fast == null) return null ;
                fast = fast.next ;
            }
            if (fast == null) return null ;

            while(fast.next != null) {
                fast = fast.next ;
                slow = slow.next ;
            }

            return slow ;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String iStr1 = null ;
        String iStr2 = null ;
        iStr1 = br.readLine() ;
        iStr2 = br.readLine() ;

        int k = Integer.parseInt(iStr2) ;
        int[] ints = Arrays.stream(iStr1.split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        ListNode head = buildList(ints) ;

        Solution sol = new Solution() ;
        ListNode listNode = sol.FindKthToTail(head, k);

        if (listNode!=null) System.out.println("ans is " + listNode.val) ;
    }

    public static ListNode buildList(int[] arr) {
        ListNode root = new ListNode(-1) ;
        ListNode tail = root ;

        for(Integer num : arr) {
            ListNode node = new ListNode(num) ;
            tail.next = node ;
            tail = tail.next ;
        }

        return root.next ;
    }
}
