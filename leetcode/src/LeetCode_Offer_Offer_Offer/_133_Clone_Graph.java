package LeetCode_Offer_Offer_Offer;

import Type.UndirectedGraphNode;

import java.util.HashMap;
import java.util.List;

/**
 * Created by tangjialiang on 2017/12/3.
 */
public class _133_Clone_Graph {

    static class Solution {

        HashMap<Integer, UndirectedGraphNode> recorder = new HashMap<>() ;

        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null) return node ;

            UndirectedGraphNode undirectedGraphNode = dfs_BuildNode(node);
            return undirectedGraphNode ;
        }

        UndirectedGraphNode dfs_BuildNode(UndirectedGraphNode node) {
            UndirectedGraphNode newNode ;
            if (recorder.containsKey(node.label)) {
                newNode = recorder.get(node.label) ;
                return newNode ;
            } else {
                newNode = new UndirectedGraphNode(node.label) ;
                recorder.put(newNode.label, newNode) ;
            }

            List<UndirectedGraphNode> neighbors = node.neighbors;
            for(UndirectedGraphNode neighbor : neighbors) {
                newNode.neighbors.add(dfs_BuildNode(neighbor)) ;
            }

            return newNode ;
        }
    }
}
