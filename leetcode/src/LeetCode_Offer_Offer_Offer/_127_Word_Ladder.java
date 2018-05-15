package LeetCode_Offer_Offer_Offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/11/27.
 */
public class _127_Word_Ladder {
    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

     Only one letter can be changed at a time.
     Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     For example,

     Given:
     beginWord = "hit"
     endWord = "cog"
     wordList = ["hot","dot","dog","lot","log","cog"]
     As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     return its length 5.
     */

    public static void main(String[] args) {
        String beginWord = "hit" ;
        String endWord = "cog" ;
        String[] arr = {"hot","dot","dog","lot","log"} ;
        LinkedList<String> l = new LinkedList<>() ;
        for(String s : arr) {
            l.addLast(s);
        }

        _127_Word_Ladder word_ladder = new _127_Word_Ladder();
        int work = word_ladder.work(beginWord, endWord, l);

        System.out.format("work is %d\n", work) ;
    }

    public int work(String beginWord, String endWord, List<String> wordList) {
        int ladders = new Solution().ladderLength(beginWord, endWord, wordList);
        return ladders ;
    }

    class Solution {
        int ans = 0 ;
        HashMap<String, List<String>> parents = new HashMap<>() ;
        HashMap<String, Boolean> isVisited = new HashMap<>() ;

        String beginWord = null ;
        String endWord = null ;

        int ladderLength(String beginWord, String endWord, List<String> wordList) {
            this.beginWord = beginWord ;
            this.endWord = endWord ;

            // use bfs to generate the parents
            LinkedList<String> queue = new LinkedList<>() ;
            queue = new LinkedList<>() ;
            queue.addLast(beginWord);
            boolean isExpand = true ;

            while (isExpand) {
                // from old queue to new queue    (tax ->  tex tad tex)
                LinkedList<String> newQueue = new LinkedList<>() ;
                if(queue.isEmpty()) break ;

                while(!queue.isEmpty()){
                    String s = queue.removeFirst();

                    isVisited.put(s, true) ;

                    for(String candidate : wordList) {
                        if (goByStep(candidate, s) && isVisited.getOrDefault(candidate, false)==false && !queue.contains(candidate)) {
                            if (candidate.equals(endWord)) {
                                isExpand = false;
                            }

                            List<String> ps = parents.getOrDefault(candidate, new LinkedList<>());
                            ps.add(s);
                            parents.put(candidate, ps);

                            if (!queue.contains(candidate) && !newQueue.contains(candidate)) newQueue.addLast(candidate);
                        }
                    }
                }
                queue = newQueue ;
            }

            // get parents
            String node = endWord ;
            ans = 1 ;
            try {
                while(!node.equals(beginWord)) {
                    ans++ ;
                    List<String> strings = parents.get(node);
                    node = strings.get(0) ;
                }
            } catch (Exception e) {
                if (!node.equals(beginWord)) {ans = 0 ;}
                System.out.println(e) ;
            }

            return ans ;
        }

        private boolean goByStep(String s, String t) {
            int count = 0 ;
            for(int i=0; i<s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    count++ ;
                    if (count > 1) return false ;
                }
            }

            if (count == 1) return true ;
            return false ;
        }
    }
}
