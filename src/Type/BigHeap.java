package Type;


/**
 * Created by tangjialiang on 2018/1/23.
 */
public class BigHeap {
    private static int DEFAULT_CAPACITY = 5000 ;

    int capacity ;
    int length ;
    HeapElement[] eles ;

    public BigHeap() {
        this(DEFAULT_CAPACITY) ;
    }

    public BigHeap(int capacity) {
        this.capacity = capacity ;
        this.length = 0 ;
        this.eles = new HeapElement[capacity+1] ;
    }

    public void addElement(HeapElement ele) throws Exception {
        if (this.length+1 >= this.capacity) {
            throw new Exception("") ;
        }

        this.eles[length+1] = ele ;
        this.length++ ;

        int curPos = length ;
        this.eles[0] = ele ;
        while(true) {
            int parentPos = curPos / 2 ;
            if (curPos == 1) {
                eles[curPos].setValue(eles[0].getValue());
                break ;
            }

            if (eles[parentPos].getValue() < eles[0].getValue()) {
                eles[curPos].setValue(eles[parentPos].getValue()) ;
                curPos = parentPos ;
            } else {
                eles[curPos].setValue(eles[0].getValue());
                break ;
            }
        }
    }

    public int removeFromTop() throws Exception {
        int ans = eles[1].getValue() ;

        eles[1].setValue(eles[length].getValue());
        length -= 1 ;

        adjuestDown(1);

        return ans ;
    }

    public void adjuestDown(int pos) throws Exception {
        if (pos<0 || pos>length) {
            throw new Exception("") ;
        }

        this.eles[0] = this.eles[pos] ;
        int curPos = pos ;
        for(int childPos=pos*2; childPos<=this.length; childPos*=2) {
            if (childPos<this.length && this.eles[childPos].getValue()<this.eles[childPos+1].getValue()) childPos++ ;

            if (this.eles[0].getValue() < this.eles[childPos].getValue()) {
                this.eles[curPos].setValue(this.eles[childPos].getValue());
                curPos = childPos ;
            } else {
                this.eles[curPos] = this.eles[0] ;
                break ;
            }
        }
    }


    public interface HeapElement {
        public int getValue() ;
        public void setValue(int v) ;
    }
}
