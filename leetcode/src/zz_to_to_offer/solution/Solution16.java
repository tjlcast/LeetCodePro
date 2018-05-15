package zz_to_to_offer.solution;

import Type.ListNode;

import java.util.* ;
import java.io.* ;

/**
 * Created by tangjialiang on 2018/3/26.
 */
public class Solution16 {

    static public class Solution {
        public ListNode Merge(ListNode list1, ListNode list2) {
            ListNode root = new ListNode(-1) ;
            ListNode tail = root ;

            while(true) {
                ListNode node = null ;
                int val1 = (list1==null) ? (Integer.MAX_VALUE) : (list1.val) ;
                int val2 = (list2==null) ? (Integer.MAX_VALUE) : (list2.val) ;

                if (list1==null && list2==null) break ;
                if (val2 < val1) {
                    node = list2 ;
                    list2 = list2.next ;
                } else {
                    node = list1 ;
                    list1 = list1.next ;
                }

                node.next = null ;
                tail.next = node ;
                tail = node ;
            }

            return root.next ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String iStr1 = null ;
        String iStr2 = null ;

        iStr1 = br.readLine() ;
        iStr2 = br.readLine() ;

        int[] ints1 = Arrays.stream(iStr1.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ints2 = Arrays.stream(iStr2.split(" ")).mapToInt(Integer::parseInt).toArray();

        ListNode head1 = bulidList(ints1) ;
        ListNode head2 = bulidList(ints2) ;

        Solution sol = new Solution() ;
        ListNode merge = sol.Merge(head1, head2);

        printList(merge) ;
    }

    private static void printList(ListNode merge) {
        while(merge != null) {
            System.out.print(merge.val + " ") ;
            merge = merge.next ;
        }
        System.out.println() ;
    }

    public static ListNode bulidList(int[] arr) {
        ListNode root = new ListNode(-1) ;
        ListNode tail = root ;

        for(Integer num : arr) {
            ListNode node = new ListNode(num) ;
            tail.next = node ;
            tail = node ;
        }

        return root.next ;
    }
}
