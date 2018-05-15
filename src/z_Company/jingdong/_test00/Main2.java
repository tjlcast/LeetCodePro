package z_Company.jingdong._test00;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/5/12.
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        String line ;
        Trie trie = new Trie();

        int m, n ;
        while(sc.hasNext()) {
            line = sc.nextLine() ;
            if (line.equals("")) continue;
            String[] split = line.split(" ");
            m = Integer.parseInt(split[0]) ;
            n = Integer.parseInt(split[1]) ;

            String[] words = new String[m] ;
            for (int i = 0; i < m; i++) {
                words[i] = sc.nextLine() ;
                trie.insert(words[i]);
            }

            String[] querys = new String[n] ;
            for (int i = 0; i < n; i++) {
                querys[i] = sc.nextLine() ;
                boolean b = trie.hasPrefix(querys[i]);
                if (b) System.out.println(1) ;
                else System.out.println(-1);
            }
            System.out.println() ;
        }

    }
}

class Trie {

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

    public boolean hasPrefix(String str) {
        CharNode target = root ;
        for (int i=0; i<str.length() && target!=null; i++) {
            char word = str.charAt(i) ;
            if (target.end) return true ;
            target = target.findCharInChildren(word);
        }
        return false ;
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
