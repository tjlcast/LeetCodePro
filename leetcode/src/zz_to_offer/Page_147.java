package zz_to_offer;

import Type.ComplexListNode;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/8/25.
 */
public class Page_147 {
    /**
     * 复制一个复杂链表，在复杂链表中，每逢节点除了有一个next指针指向下一个节点外，还有一个silbing指向链表中的任意节点或者null
     */

    class MySolution1 {
        /**
         * 使用空间换时间的方法，在建立链表骨架的时候记录新旧节点的对应关系。根据这个关系来建立silbing关系
         * 优点： 不改变旧链表的的结构
         */
        HashMap<ComplexListNode, ComplexListNode> nodePair = new HashMap<>() ;

        public ComplexListNode cloneNodes(ComplexListNode head){
            // the linkedlist doesn't have a head node
            if (head == null) return head ;

            return cloneNodeByNode(head) ;
        }

        private ComplexListNode cloneNodeByNode(ComplexListNode head) {
            ComplexListNode workNode = head ;
            ComplexListNode newHead = new ComplexListNode(-1) ;
            ComplexListNode newTail = newHead ;

            // build the linkedlist structure
            while(workNode != null) {
                ComplexListNode node = new ComplexListNode(workNode.val) ;
                nodePair.put(workNode, node) ;
                newTail.next = node ;
                newTail = newTail.next ;
                workNode = workNode.next ;
            }

            // rebuild to complete slibing of nodes
            workNode = head ;
            newTail = newHead.next ;
            while(workNode != null) {
                newTail.sibling = nodePair.get(workNode.sibling) ;
                workNode = workNode.next ;
                newTail = newTail.next ;
            }

            return newHead.next ;
        }
    }

    class MySolution2 {
        /**
         * 在原链表的每个节点后面加入各个节点的备份节点。使用：每个节点的后面一个节点是该节点的备份节点的对应关系，来建立silbing关系
         * 缺点： 可能改变原链表的结构。
         */

        public ComplexListNode cloneNodes(ComplexListNode head){
            // the linkedlist doesn't have a head node
            if (head == null) return head ;

            return cloneNodeByNode(head) ;
        }

        private ComplexListNode cloneNodeByNode(ComplexListNode head) {
            // step.1 add new nodes behind old nodes
            ComplexListNode oldWorkNode = head ;

            while(oldWorkNode != null) {
                ComplexListNode curNode = oldWorkNode ;
                oldWorkNode = oldWorkNode.next ;

                ComplexListNode tmpNewNode = new ComplexListNode(curNode.val) ;
                tmpNewNode.next = oldWorkNode ;
                curNode.next = curNode ;
            }

            buildSilbingStructure(head);

            // get out new nodes from list
            ComplexListNode ans = new ComplexListNode(-1) ;
            ComplexListNode ansTail = ans ;
            oldWorkNode = head ;
            while(oldWorkNode != null) {
                ComplexListNode tmp = oldWorkNode.next ;
                oldWorkNode = oldWorkNode.next.next ;

                tmp.next = ansTail.next ;
                ansTail.next = tmp ;
            }

            return ans.next ;
        }

        private void buildSilbingStructure(ComplexListNode head) {
            ComplexListNode workNode = head ;

            while(workNode != null) {
                workNode.next.sibling = workNode.sibling.next ;
                workNode = workNode.next.next ;
            }
            return ;
        }
    }
}
