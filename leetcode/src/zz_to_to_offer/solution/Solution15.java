package zz_to_to_offer.solution;

import Type.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by tangjialiang on 2018/3/26.
 */
public class Solution15 {

    static public class Solution {
        public ListNode ReverseList(ListNode head) {
            ListNode root = new ListNode(-1) ;
            ListNode node = head ;

            while(node != null) {
                ListNode tmpNode = node ;
                node = node.next ;

                tmpNode.next = root.next ;
                root.next = tmpNode ;
            }
            return root.next ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String iStr1 = null ;
        iStr1 = br.readLine() ;

        int[] ints = Arrays.stream(iStr1.split(" ")).mapToInt(Integer::parseInt).toArray();
        Solution sol = new Solution() ;

        ListNode head = buildList(ints) ;
        head = sol.ReverseList(head) ;

        printList(head) ;
    }

    private static ListNode buildList(int[] ints) {
        ListNode root = new ListNode(-1) ;
        ListNode tail = root ;

        for(Integer num : ints) {
            ListNode node = new ListNode(num) ;
            tail.next = node ;
            tail = tail.next ;
        }

        return root.next;
    }

    private static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ") ;
            head = head.next ;
        }
        System.out.println() ;
    }
}
