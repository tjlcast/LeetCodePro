package LeetCode_Offer_Offer_Offer;

import Type.ListNode;
import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/29.
 */
public class _234_Palindrome_Linked_List {

    public static void main(String[] args) {
        Solution sol = new Solution() ;
        boolean ans = sol.isPalindrome(null) ;

        System.out.println("ans is: " + ans) ;
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            Stack<ListNode> stack = new Stack<>() ;

            for(ListNode curNode=head; curNode!=null; curNode=curNode.next) {
                stack.push(curNode) ;
            }

            for(ListNode curNode=head; curNode!=null; curNode=curNode.next) {
                ListNode node = stack.pop() ;
                if (node.val != curNode.val) return false ;
            }

            return true ;
        }
    }
}
