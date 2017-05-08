package LinkedList;

import Type.ListNode;

public class _21_Merge_Two_Sorted_Lists {
    public static void main(String[] args) {

    }

    public ListNode work(ListNode l1, ListNode l2) {
        return new Solution().mergeTwoLists(l1, l2) ;
    }

    public class Solution {
            ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(-1) ;
            ListNode tail = root ;

            ListNode flag1 = l1 ;
            ListNode flag2 = l2 ;

            while(flag1!=null || flag2!=null) {

                ListNode num1 = (flag1==null) ? (new ListNode(Integer.MAX_VALUE)) : (flag1) ;
                ListNode num2 = (flag2==null) ? (new ListNode(Integer.MAX_VALUE)) : (flag2) ;

                if (num1.val > num2.val) {
                    ListNode swap = num1 ;
                    num1 = num2 ;
                    num2 = swap ;
                    if (flag2!=null) {
                        flag2 = flag2.next ;
                    }
                } else {
                    if (flag1!=null) {
                        flag1 = flag1.next ;
                    }
                }

                tail.next = num1 ;
                tail = tail.next ;
                tail.next = null ;
            }

            return root.next ;
        }
    }
}
