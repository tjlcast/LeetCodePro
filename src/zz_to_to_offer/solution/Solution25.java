package zz_to_to_offer.solution;

import Type.RandomListNode;

import java.util.Random;

/**
 * Created by tangjialiang on 2018/4/24.
 */
public class Solution25 {

    static public class Solution {
        public RandomListNode Clone(RandomListNode pHead)
        {
            if(pHead == null) return null ;
            RandomListNode root = new RandomListNode(-1) ;
            RandomListNode tail = root ;

            RandomListNode node = pHead ;
            while (node != null) {
                RandomListNode tmpNode = new RandomListNode(node.label) ;
                tmpNode.next = node.next ;
                node.next = tmpNode ;

                node = node.next.next ;
            }

            node = pHead;
            while (node != null) {
                if (node.random!=null) node.next.random = node.random.next ;
                node = node.next.next ;
            }

            node = pHead ;
            while (node != null) {
                tail.next = node.next ;
                tail = tail.next ;

                node.next = node.next.next ;
                node = node.next ;
            }

            return root.next ;
        }
    }

    public static RandomListNode generate(int[] arr) {
        RandomListNode[] map = new RandomListNode[arr.length] ;

        RandomListNode root = new RandomListNode(-1) ;
        RandomListNode node = root ;
        for (int i = 0; i < arr.length; i++) {
            RandomListNode randomListNode = new RandomListNode(arr[i]);
            map[i] = randomListNode ;

            node.next = randomListNode ;
            node = node.next ;
        }
        Random random = new Random() ;
        for (int i = 0; i < arr.length; i++) {
            map[i].random = map[Math.abs(random.nextInt()) % arr.length] ;
        }

        return root.next ;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1} ;

        RandomListNode generate = generate(arr);
        RandomListNode node = generate ;
        while(node != null) {
            System.out.println(node.label + " - " + node.random.label + " - " + node.hashCode());
            node = node.next ;
        }

        Solution sol = new Solution() ;
        RandomListNode clone = sol.Clone(generate);

        System.out.println(" ------------- ") ;

        node = clone ;
        while(node != null) {
            System.out.println(node.label + " - " + node.random.label + " - " + node.hashCode());
            node = node.next ;
        }
    }
}
