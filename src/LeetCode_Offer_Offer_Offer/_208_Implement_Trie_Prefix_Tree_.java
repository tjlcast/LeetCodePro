package LeetCode_Offer_Offer_Offer;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/20.
 */
public class _208_Implement_Trie_Prefix_Tree_ {

    public static void main(String[] args) {
        String word = "helloworld" ;
        Trie obj = new Trie() ;
        obj.insert(word);
        boolean param_2 = obj.search("heloworld") ;
        System.out.println("The work is: " + param_2) ;
        boolean param_3 = obj.startsWith("hello") ;
        System.out.println("The work is: " + param_3) ;
    }

    static class Trie {

        CharNode root = new CharNode(null) ;

        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            CharNode target = root ;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i) ;
                target = target.insertACharNode(c) ;
            }
            target.end = true ;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            CharNode target = root ;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                target = target.findCharInChildren(c);
                if (target == null) return false ;
            }
            return target.end == true ;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            CharNode target = root ;
            for(int i=0; i<prefix.length(); i++) {
                char word = prefix.charAt(i) ;
                target = target.findCharInChildren(word) ;
                if (target == null) return false ;
            }
            return true ;
        }

        class CharNode {
            Character c ;
            boolean isRoot ;
            boolean end ;
            List<CharNode> children = new LinkedList<CharNode>() ;

            public CharNode(Character c) {
                if (c == null) isRoot = true ;
                else isRoot = false ;

                this.end = false ;
                this.c = c ;
            }

            public CharNode findCharInChildren(char c) {
                CharNode target = null ;
                for(CharNode child : children) {
                    if (child.c.equals(c)) {
                        target = child ;
                        return target ;
                    }
                }
                return target ;
            }

            public CharNode insertACharNode(char c) {
                CharNode target = this.findCharInChildren(c) ;
                if (target != null) return target ;

                target = new CharNode(c) ;
                children.add(target) ;
                return target ;
            }
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
