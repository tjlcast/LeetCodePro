package zz_to_offer;

import Type.ListNode;
import Utils.LinkedListUtils;

import java.util.*;

/**
 * Created by tangjialiang on 2017/8/21.
 */
public class Page_51 {
    /**
    * 链表：从尾到头打印链表
    * */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8} ;
        ListNode listNode = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(nums);
        new Page_51().work(listNode);
    }

    public void work(ListNode root) {
        List<Integer> nodeFromHead = new MySolution().getNodeFromHead(root);
        new MySolution().printListNode(nodeFromHead);
    }

    class MySolution{
        List<Integer> getNodeFromHead(ListNode root) {
            LinkedList<Integer> ans = new LinkedList<>() ;

            Stack<Integer> tempCollection = new Stack<>() ;
            ListNode ptr = root ;
            while(ptr != null) {
                tempCollection.push(ptr.val) ;
                ptr = ptr.next ;
            }

            while(!tempCollection.empty()) {
                ans.add(tempCollection.pop()) ;
            }

            return ans ;
        }

        void printListNode(List nums) {
            System.out.println("ans is : ") ;
            Iterator iterator = nums.iterator();
            while(iterator.hasNext()) {
                Object next = iterator.next();
                System.out.println((Integer)next) ;
            }
        }
    }
}
