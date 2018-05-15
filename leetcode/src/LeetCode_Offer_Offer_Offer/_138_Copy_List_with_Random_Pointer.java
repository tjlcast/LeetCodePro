package LeetCode_Offer_Offer_Offer;

import Type.RandomListNode;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/12/5.
 */
public class _138_Copy_List_with_Random_Pointer {
    /**
     * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

     Return a deep copy of the list.
     */

    public static void main(String[] args) {
        
    }

    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            HashMap<RandomListNode, RandomListNode> recorder = new HashMap<>() ;
            RandomListNode node = head ;

            RandomListNode newHead = null ;
            RandomListNode newNode = null ;
            // step.1
            while(node != null) {
                RandomListNode tmpNode = new RandomListNode(node.label) ;
                recorder.put(node, tmpNode) ;
                if (newHead == null) {
                    newHead = tmpNode ;
                    newNode = tmpNode ;
                }
                else {
                    newNode.next = tmpNode ;
                    newNode = tmpNode ;
                }
                node = node.next ;
            }

            // step.2
            newNode = newHead ;
            node = head ;
            while(newNode != null) {
                newNode.random = recorder.get(node.random) ;

                newNode = newNode.next ;
                node = node.next ;
            }

            return newHead ;
        }
    }
}
