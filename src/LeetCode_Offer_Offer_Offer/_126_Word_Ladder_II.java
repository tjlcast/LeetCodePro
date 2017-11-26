package LeetCode_Offer_Offer_Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/11/24.
 */
public class _126_Word_Ladder_II {
    /**
     * 既然是求最短路径，可以考虑动归或广搜。这道题对字典直接进行动归是不现实的，因为字典里的单词非常多。只能选择广搜了。

     思路也非常直观，从start或end开始，不断加入所有可到达的单词，直到最终到达另一端。本质上广度优先遍历图。

     需要注意的是，拓展下一个单词时不能对字典进行枚举，因为字典里的单词太多。幸好单词本身都不长，所以直接枚举单词所有可能的变形，看看在dict中出现没有。

     当然还不止这些，上面的做法仍然会超时，需要添加剪枝策略：

     1. 如果某个单词在以前遍历过了，那么以后都不用再考虑，因为之后遍历到的路径一定不是最短的

     2. 在广搜法拓展下一轮单词时，注意去重

     此外还需要注意的是，不能把每个单词到start或end的路径都保存下来，那样内存会爆掉。所以要压缩保存结果，通常的做法是用一个map保存当前单词下一步是什么单词。例如next[word] = {next_word1, next_word2, next_word3...}。最后从next[start]开始再次使用广度优先搜索法构造出所有解。

     算法不难，但是编码非常容易出错，所以总体上还是挺难的。最后运行时间640ms，还是有挺大优化空间的。
     * @param args
     */

    public static void main(String[] args) {
        String beginWord = "red" ;
        String endWord = "tax" ;
        String[] arr = {"ted","tex","red","tax","tad","den","rex","pee"} ;
        LinkedList<String> l = new LinkedList<>() ;
        for(String s : arr) {
            l.addLast(s);
        }

        _126_Word_Ladder_II word_ladder_ii = new _126_Word_Ladder_II();
        List<List<String>> work = word_ladder_ii.work(beginWord, endWord, l);

        for(List<String> line : work) {
            for(String word : line) {
                System.out.print(word + " ") ;
            }
            System.out.println() ;
        }
    }

    public List<List<String>> work(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ladders = new Solution().findLadders(beginWord, endWord, wordList);
        return ladders ;
    }

    public class Solution {
        List<List<String>> ans = new LinkedList<>() ;
        HashMap<String, List<String>> parents = new HashMap<>() ;
        HashMap<String, Boolean> isVisited = new HashMap<>() ;

        String beginWord = null ;
        String endWord = null ;

        List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            this.beginWord = beginWord ;
            this.endWord = endWord ;

            String roundEnd = "" ;
            LinkedList<String> queue = new LinkedList<>() ;
            queue.addLast(beginWord);
            queue.addLast(roundEnd) ;
            isVisited.put(beginWord, true) ;

            boolean flag = false ; // for bfs --> is find the endWord.

            while (queue.size()!=1) {
                String curStr = queue.removeFirst();
                if (curStr == roundEnd) {
                    if (flag) { System.out.println("end"); break ; }
                    queue.addLast(roundEnd);
                    continue;
                }

                isVisited.put(curStr, true) ;

                for(String candidate : wordList) {
                    if(goByStep(candidate, curStr) && isVisited.getOrDefault(candidate, false)==false) {
                        if (candidate.equals(endWord)) {
                            flag = true ;
                        }

                        List<String> ps = parents.getOrDefault(candidate, new LinkedList<>());
                        if(!isVisited.getOrDefault(candidate, false))ps.add(curStr) ;
                        parents.put(candidate, ps) ;

                        if(!queue.contains(candidate) && !flag)queue.addLast(candidate);
                    }
                }
            }

            // use bfs to generate the parents
            queue = new LinkedList<>() ;
            queue.addLast(beginWord);

            while (true) {
                // from old queue to
            }

            // test
//            for(String key : parents.keySet()) {
//                System.out.print(key + " -> ") ;
//                for(String val : parents.get(key)) {
//                    System.out.print(" " + val) ;
//                }
//                System.out.println() ;
//            }

            // get parents
            try {
                LinkedList<String> strings = new LinkedList<>();
                strings.addLast(endWord);
                dfs(endWord, strings) ;
            } catch (Exception e) {
                System.out.println(e) ;
            }

            return ans ;
        }

        private void dfs(String root, LinkedList<String> strs) {
            // if root == beginWord
            if (root.equals(beginWord)) {
                LinkedList<String> clone = (LinkedList<String>)strs.clone();
                ans.add(clone) ;
                return ;
            }

            // go to generate next round
            List<String> strings = parents.get(root) ;
            for(String word : strings) {
                strs.addFirst(word);
                dfs(word, strs) ;
                strs.removeFirst() ;
            }
        }

        private boolean goByStep(String s, String t) {
            int count = 0 ;
            for(int i=0; i<s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    count++ ;
                }
            }

            if (count == 1) return true ;
            return false ;
        }
    }
}
