package Type;

/**
 * Created by tangjialiang on 2017/12/3.
 *  * Definition for undirected graph.
 */

import java.util.ArrayList;
import java.util.List;


public class UndirectedGraphNode {
     public int label;
     public List<UndirectedGraphNode> neighbors;
     public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}