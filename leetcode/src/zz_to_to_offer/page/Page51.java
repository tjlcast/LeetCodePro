package zz_to_to_offer.page;

import Type.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tangjialiang on 2018/2/26.
 */
public class Page51 {

    public List<Integer> solution(ListNode head) {
        ListNode root = head ;
        Stack<ListNode> stack = new Stack<ListNode>() ;

        while(root != null) {
            stack.push(root) ;
            root = root.next ;
        }

        LinkedList<Integer> ans = new LinkedList<Integer>() ;
        while(!stack.isEmpty()) {
            ListNode pop = stack.pop();
            ans.addLast(pop.getVal());
        }

        return ans ;
    }

    public static void main(String[] args) {
        int[] arrs = {1, 2, 3, 4, 5, 6} ;
        ListNode listNode = Page51.buildList(arrs);

        Page51 page = new Page51() ;
        List<Integer> solution = page.solution(listNode);

        for(Integer num : solution) {
            System.out.print(num + " ") ;
        }
    }

    public static ListNode buildList(int[] arrs) {
        ListNode root = new ListNode(-1) ;
        ListNode node = root ;
        for(Integer num : arrs) {
            ListNode listNode = new ListNode(num);
            node.next = listNode ;
            node = listNode ;
        }
        return root.next ;
    }
}
