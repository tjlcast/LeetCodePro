package Type;

/**
 * Created by tangjialiang on 2018/1/22.
 */
public class SegmentTree {

    public SegmentTree() {}

    public Node build(int start, int end) {
        if (start > end) return null ;

        Node node = new Node(start, end) ;
        if (start == end) return node ;

        int mid = (start + end) >> 1 ;
        node.left = build(start, mid) ;
        node.right = build(mid+1, end) ;

        return node ;
    }

    public int query(Node root, int start, int end) {
        if (root==null || start>end) return 0 ;

        if (root.start==start && root.end==end) {
            return root.value ;
        }

        int mid = (root.start + root.end) >> 1 ;
        if (mid < start) {
            return query(root.right, start, mid) ;
        }
        if (mid > end) {
            return query(root.left, start, end) ;
        }

        int leftSum = query(root.left, start, mid) ;
        int rightSum = query(root.right, mid+1, end) ;
        return leftSum + rightSum ;
    }

    class Node {
        int start ;
        int end ;
        int value ;
        Node left ;
        Node right ;

        public Node(int start, int end) {
            this.start = start ;
            this.end = end ;
        }
    }
}
