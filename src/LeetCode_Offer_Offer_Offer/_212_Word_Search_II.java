package LeetCode_Offer_Offer_Offer;

import Type.Trie;
import Type.Trie.CharNode ;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/21.
 */
public class _212_Word_Search_II {
    /**
     * Given a 2D board and a list of words from the dictionary,
     * find all words in the board.

     Each word must be constructed from letters of sequentially adjacent cell,
     where "adjacent" cells are those horizontally or vertically neighboring.
     The same letter cell may not be used more than once in a word.

     For example,
     Given words = ["oath","pea","eat","rain"] and board =

     [
     ['o','a','a','n'],
     ['e','t','a','e'],
     ['i','h','k','r'],
     ['i','f','l','v']
     ]
     Return ["eat","oath"].
     */

    public static void main(String[] args) {
        String[] words = {"oath","pea","eat","rain"} ;
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        } ;

        Solution solution = new Solution();
        List<String> words1 = solution.findWords(board, words);

        System.out.println("The work is: " ) ;
        for(String ans : words1) {
            System.out.println(ans) ;
        }
    }

    static class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>() ;
            Trie trie = new Trie(words) ;
            CharNode cNode = trie.root ;

            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[0].length; j++) {
                    dfs(board, i, j, cNode, res) ;
                }
            }

            return res ;
        }

        public void dfs(char[][] board, int row, int col, CharNode cNode,  List<String> res) {
            char c = board[row][col] ;
            int pos = c - 'a' ;
            if (c=='#' && cNode.children[pos]==null) return ;

            // has
            cNode = cNode.children[pos] ;
            if (cNode.word != null) {
                res.add(cNode.word) ;
                cNode.word = null ; // avoid duplicate
            }

            // go on
            board[row][col] = '#' ;
            if (row > 0) dfs(board, row-1, col, cNode, res) ;
            if (col > 0) dfs(board, row, col-1, cNode, res) ;
            if (row < board.length-1) dfs(board, row+1, col, cNode, res) ;
            if (col < board.length-1) dfs(board, row, col+1, cNode, res) ;
            board[row][col] = c ;
        }
    }

    static class Solution1 {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            TrieNode root = buildTrie(words);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs (board, i, j, root, res);
                }
            }
            return res;
        }

        public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
            char c = board[i][j];
            if (c == '#' || p.next[c - 'a'] == null) return;
            p = p.next[c - 'a'];
            if (p.word != null) {   // found one
                res.add(p.word);
                p.word = null;     // de-duplicate
            }

            board[i][j] = '#';
            if (i > 0) dfs(board, i - 1, j ,p, res);
            if (j > 0) dfs(board, i, j - 1, p, res);
            if (i < board.length - 1) dfs(board, i + 1, j, p, res);
            if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
            board[i][j] = c;
        }

        public TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();
            for (String w : words) {
                TrieNode p = root;
                for (char c : w.toCharArray()) {
                    int i = c - 'a';
                    if (p.next[i] == null) p.next[i] = new TrieNode();
                    p = p.next[i];
                }
                p.word = w;
            }
            return root;
        }

        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            String word;
        }
    }
}
