package LeetCode_Offer_Offer_Offer;

import Type.ListNode;

import java.util.*;

/**
 * Created by tangjialiang on 2017/9/2.
 */
public class _23_Merge_k_Sorted_Lists {
    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     */

    public static void main(String[] args) {

    }

    public ListNode work(ListNode[] lists) {
        Solution solution = new Solution();
        ListNode listNode = solution.mergeKLists(lists);
        return listNode ;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    class Solution {
        private PriorityQueue<ListNode> queue = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        int val1 = (o1==null) ? (9999) : (o1.val) ;
                        int val2 = (o2==null) ? (9999) : (o2.val) ;
                        return val1 - val2;
                    }
                }
        ) ;
        private ListNode root = new ListNode(-1) ;
        private ListNode tail = root ;

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists==null || lists.length==0) return root.next ;

            for(ListNode node : lists) if (node!=null) queue.add(node) ;

            while(queue.size() != 0) {
                ListNode node = queue.poll();

                if (node.next != null) queue.add(node.next) ;

                node.next = tail.next ;
                tail.next = node ;
                tail = tail.next ;
            }

            return root.next ;
        }
    }

    class Solution3 {
        private ListNode root = new ListNode(-1) ;
        private ListNode tail = root ;
        private Vector<ListNode> nodes = new Vector<>() ;

        class ListNodeComparator implements Comparator<ListNode>{
            @Override
            public int compare(ListNode o1, ListNode o2) {
                int val1 = (o1==null) ? (9999) : (o1.val) ;
                int val2 = (o2==null) ? (9999) : (o2.val) ;
                return val1 - val2;
            }
        }
        private ListNodeComparator comp = new ListNodeComparator() ;

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists==null || lists.length==0) return root.next ;

            for(ListNode node : lists) if (node!=null) nodes.add(node) ;

            while(nodes.size()!=0) {
                nodes.sort(comp);

                ListNode node = nodes.get(0) ;
                if (node.next != null) {
                    nodes.set(0, node.next) ;
                } else {
                    nodes.remove(0) ;
                }

                node.next = tail.next ;
                tail.next = node ;
                tail = tail.next ;
            }

            return root.next ;
        }
    }

    class Solution2 {
        private ListNode root = new ListNode(-1) ;
        private ListNode tail = root ;

        class ListNodeComparator implements Comparator<ListNode>{
            @Override
            public int compare(ListNode o1, ListNode o2) {
                int val1 = (o1==null) ? (9999) : (o1.val) ;
                int val2 = (o2==null) ? (9999) : (o2.val) ;
                return val1 - val2;
            }
        }
        private ListNodeComparator comp = new ListNodeComparator() ;

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists==null || lists.length==0) return root.next ;

            while(true) {
                Arrays.sort(lists, comp);
                if (lists[0] == null) break ;

                ListNode node = lists[0] ;
                lists[0] = lists[0].next ;

                node.next = tail.next ;
                tail.next = node ;
                tail = tail.next ;
            }

            return root.next ;
        }
    }

    class Solution1 {
        private ListNode root = new ListNode(-1) ;
        private ListNode tail = root ;

        public ListNode mergeKLists(ListNode[] lists) {

            while(true) {
                int minVal = Integer.MAX_VALUE ;
                int minPos = -1 ;
                for(int i=0; i<lists.length; i++) {
                    if (lists[i] != null && minVal > lists[i].val) {
                        minVal = lists[i].val ;
                        minPos = i ;
                    }
                }

                if (minVal == Integer.MAX_VALUE) break ;

                ListNode minNode = lists[minPos] ;
                lists[minPos] = lists[minPos].next ;

                minNode.next = tail.next ;
                tail.next = minNode ;
                tail = tail.next ;
            }

            return root.next ;
        }
    }
}
