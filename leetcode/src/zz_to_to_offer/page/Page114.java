package zz_to_to_offer.page;

import Type.ListNode;

/**
 * Created by tangjialiang on 2018/2/27.
 */
public class Page114 {

    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1==null && list2==null) return null ;
        if (list1==null && list2!=null) return list2 ;
        if (list1!=null && list2==null) return list1 ;

        if (list1.val <= list2.val) {
            ListNode node = list1 ;
            node.next = merge(list1.next, list2) ;
            return node ;
        } else {
            ListNode node = list2 ;
            node.next = merge(list1, list2.next) ;
            return node ;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 3, 3, 4} ;
        int[] nums2 = {1, 1, 2, 3, 4, 4} ;

        ListNode list1 = Page51.buildList(nums1) ;
        ListNode list2 = Page51.buildList(nums2) ;

        ListNode merge = merge(list1, list2);
        while(merge != null) {
            System.out.print(merge.val + " ") ;
            merge = merge.next ;
        }
    }
}
