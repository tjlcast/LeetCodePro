package _test;

/**
 * Created by tangjialiang on 2018/1/29.
 */
public class SegmentTest {

    class Lamps {

        Node root ;

        public Lamps(int num) {
        }

        public void openRange(int start, int end) {
            // todo
            return ;
        }

        public void closeRange(int start, int end) {
            // todo
            return ;
        }

        private Node build(int start, int end) {
            if (start > end) return null ;

            Node node = new Node(start, end) ;
            if(start == end) return node ;

            int mid = (start + end) >> 1 ;
            node.left = build(start, mid) ;
            node.right = build(mid+1, end) ;
            return node ;
        }

        private int query(Node node, int start, int end) {
            if (start > end) return -1 ;

            // query range must be in node's range.
            // [node.start <= start && end <= node.end]
            if (node.start==start && node.end==end) return node.val ;

            int mid = (node.start + node.end) >> 1 ;
            if (end <= mid) {
                return query(node.left, start, end) ;
            } else if (start >= mid+1) {
                return query(node.right, start, end) ;
            } else {
                return query(node.left, start, mid) + query(node.right, mid+1, end) ;
            }
        }

        private int update(Node node, int start, int end, int newVal) {
            if (start > end) return -1 ; // ----> error
            if (start==end) {
                node.val = newVal ;
                return node.val ;
            }



            return -1 ;
        }

        class Node {
            int val ;
            int start ;
            int end ;

            Node left ;
            Node right ;

            public Node(int start, int end) {
                this.start = start ;
                this.end = end ;
            }
        }
    }
}
