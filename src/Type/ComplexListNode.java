package Type;

/**
 * Created by tangjialiang on 2017/8/25.
 */
public class ComplexListNode {
    public int val ;
    public ComplexListNode next ;
    public ComplexListNode sibling ;

    public ComplexListNode(int val) {
        this.val = val ;
        next = null ;
        sibling = null ;
    }

    @Override
    public String toString() {
        return "ComplexListNode{" +
                "val=" + val +
                ", next=" + next +
                ", sibling=" + sibling +
                '}';
    }
}
