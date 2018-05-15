package LinkedList;

import Type.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _23_Merge_k_Sorted_Lists {
    public static void main(String[] args) {

    }

    ListNode work(ListNode[] lists) {
//        return new Solution().mergeKLists(lists) ;
        return null ;
    }


    class Solution3 {
        ListNode mergeKLists(ListNode[] lists) {
            if(lists==null||lists.length==0)
                return null;
            if(lists.length==1)
                return lists[0];

            PriorityQueue<ListNode> PQ = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            }) ;

            ListNode head=new ListNode(0);
            ListNode phead=head;

            for(ListNode list:lists)
            {
                if(list!=null)
                    PQ.offer(list);
            }

            while(!PQ.isEmpty())
            {
                ListNode temp=PQ.poll();
                phead.next=temp;
                phead=phead.next;

                if(temp.next!=null)
                    PQ.offer(temp.next);
            }

            return head.next ;
        }
    }




    class Solution1 {
        ListNode mergeKLists(ListNode[] lists) {
            ListNode head = new ListNode(-1) ;
            ListNode tail = head ;

            while(!isFinish(lists)) {
                Arrays.sort(lists, new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        if (o1==null) {o1 = new ListNode(Integer.MIN_VALUE) ;}
                        if (o2==null) {o2 = new ListNode(Integer.MIN_VALUE) ;}

                        if (o1.val < o2.val) {
                            return -1 ;
                        } else if (o1.val > o2.val) {
                            return 1 ;
                        } else {
                            return 0 ;
                        }
                    }
                });


                ListNode cmpNode = new ListNode(Integer.MAX_VALUE) ;
                int pos = findMinPos(lists) ;
                cmpNode = lists[pos] ;

                // get the target node
                lists[pos] = lists[pos].next ;

                // add the target to ans array
                cmpNode.next = null ;
                tail.next = cmpNode ;
                tail = tail.next ;
            }

            return head.next ;
        }

        boolean isFinish(ListNode[] lists) {
            for (ListNode node : lists) {
                if (node != null) return false ;
            }
            return true ;
        }

        int findMinPos(ListNode[] lists) {
            int l = 0 ;
            int r = lists.length-1 ;
            if (lists[r] == null) return -1 ;
            if (lists[l] != null) return l ;

            while(true) {
                int mid = (l + r) / 2;
                ListNode target = lists[mid] ;
                if (l==r) break ;

                if (target != null) {
                    r = mid ;
                } else {
                    l = mid + 1 ;
                }
            }

            return l;
        }
    }
}
