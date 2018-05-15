package LeetCode_Offer_Offer_Offer;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/21.
 */
public class _211_Add_and_Search_Word_Data_structure_design {

    public static void main(String[] args) {
        String word = "hello world" ;

        WordDictionary obj = new WordDictionary();
        obj.addWord(word);
        boolean param_2 = obj.search("hello.w.rld");

        System.out.println("The work is: " + param_2) ;
    }

    static class WordDictionary {

        CharNode root = new CharNode(' ') ;

        /** Initialize your data structure here. */
        public WordDictionary() {

        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            CharNode target = root ;
            for(int i=0; i<word.length(); i++) {
                target = target.insertCharInChildren(word.charAt(i)) ;
            }
            target.end = true ;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return wordInTree(word, root) ;
        }

        boolean wordInTree(String word, CharNode node) {
            CharNode target = node ;

            char headChar = word.charAt(0) ;
            if (word.length()==1 ) {
                for(CharNode child : target.children) {
                    if (child.end && (headChar=='.' || headChar==child.c)) return true ;
                }
                return false ;
            }

            for(CharNode child : target.children) {
                if (headChar=='.' || headChar==child.c) {
                    boolean ans = wordInTree(word.substring(1), child) ;
                    if (ans) return ans ;
                }
            }
            return false ;
        }

        class CharNode {
            Character c ;
            Boolean end ;
            List<CharNode> children = new LinkedList<>() ;

            public CharNode(char c) {
                this.c = c ;
                this.end = false ;
            }

            public CharNode findCharInChildren(Character c) {
                CharNode target = null ;
                for(CharNode node : children) {
                    if (node.c.equals(c)) {
                        target = node ;
                        return target ;
                    }
                }
                return target ;
            }

            public CharNode insertCharInChildren(Character c) {
                CharNode target = findCharInChildren(c) ;
                if (target == null) {
                    target = new CharNode(c) ;
                    this.children.add(target) ;
                }
                return target ;
            }
        }
    }
}
