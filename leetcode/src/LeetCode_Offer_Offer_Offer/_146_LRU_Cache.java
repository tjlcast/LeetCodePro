package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2017/12/10.
 */
public class _146_LRU_Cache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        int i = cache.get(1);// returns 1
        cache.put(3, 3);    // evicts key 2
        int i1 = cache.get(2);// returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        int i2 = cache.get(1);// returns -1 (not found)
        int i3 = cache.get(3);// returns 3
        int i4 = cache.get(4);// returns 4
    }

    static class LRUCache {

        /**
         * tips: 一个双向链表 + 一个hashMap
         *
         * 双向链表
         * 1、双向链表的节点保存key和val，key是为了在快速【O（1）】中在HashMap中定位。
         * 2、双向链表的实现使用Head + Tail的形式。
         *
         * HashMap
         * 1、为key到双向链表节点的映射。
         */

        private Node head = new Node(-1,-1) ;
        private Node tail = new Node(-1,-1) ;
        private HashMap<Integer, Node> recorder = new HashMap<>() ;
        private int capacity ;

        public LRUCache(int capacity) {
            this.capacity = capacity ;
            head.back = tail ;
            tail.front = head ;
        }

        public int get(int key) {
            if(recorder.containsKey(key)) {
                Node node = recorder.get(key);
                hit(node) ;
                return node.val ;
            } else {
                return -1 ;
            }
        }

        public void put(int key, int value) {
            if (recorder.containsKey(key)) {
                Node node = recorder.get(key);
                node.val = value ;
                hit(node) ;
            } else {
                Node node = new Node(key, value) ;
                if (recorder.keySet().size() == this.capacity && this.capacity!=0) {
                    // remove tail
                    int removeKey = tail.front.key;
                    removeNode(tail.front);
                    // remove recorder
                    recorder.remove(removeKey) ;
                }
                // add node root
                addHead(node);
                // add recorder
                recorder.put(key, node) ;
            }
        }

        private void hit(Node node) {
            // move the node to the head.
            if (node == null) return ;
            removeNode(node);
            addHead(node);
        }

        private void removeNode(Node node) {
            if (node == null) return ;

            Node front = node.front ;
            Node back = node.back ;

            front.back = back ;
            back.front = front ;
        }

        private void addHead(Node node) {
            if (node == null) return ;

            node.front = head ;
            node.back = head.back ;

            head.back.front = node ;
            head.back = node ;
        }

        private void addTail(Node node) {
            if (node == null) return ;

            node.front = tail.front ;
            node.back = tail ;

            tail.front.back = node ;
            tail.front = node ;
        }

        private class Node {
            int key ;
            int val ;
            Node front ;
            Node back ;
            Node(int key, int val) {this.val = val; this.key=key; }
        }
    }
}
