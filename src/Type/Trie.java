package Type;

import java.util.Collection;

/**
 * Created by tangjialiang on 2018/1/22.
 */
public class Trie {

    public CharNode root = new CharNode() ;

    public Trie() {}

    public Trie(Collection<String> words) {
        for(String word : words) {
            insertWord(word);
        }
    }

    public Trie(String[] words) {
        this.insertWords(words);
    }

    public void buildTrie(String word) {
        this.insertWord(word);
    }

    public void buildTrie(String[] words) {
        this.insertWords(words);
    }

    public void insertWords(String[] words) {
        for(String word : words) {
            this.insertWord(word);
        }
    }

    /**
     * 根据传入的word在字典树上进行遍历
     * @param word
     * @return null or word最后一个字符所在的节点
     */
    private CharNode check(String word) {
        CharNode target = root ;
        for(Character c : word.toCharArray()) {
            int pos = c - 'a' ;
            target = target.children[pos] ;
            if (target == null) return target ;
        }
        return target ;
    }

    /**
     * 判断传入的字符串是否是字典树的前缀
     * @param word
     * @return true or false
     */
    public boolean startsWith(String word) {
        CharNode charNode = check(word) ;

        if (charNode == null) return false ;
        return true ;
    }

    /**
     * 判断字典树中是否存在传入的字符串
     * @param word
     * @return true or false
     */
    public boolean search(String word) {
        CharNode charNode = check(word) ;

        if (charNode!=null && charNode.word.equals(word)) return true ;
        return false ;
    }

    /**
     * 为字典树添加一个字符串
     * @param word
     */
    public void insertWord(String word) {
        CharNode target = root ;
        for(Character c : word.toCharArray()) {
            int pos = c - 'a' ;
            target = target.children[pos] == null ? (target.children[pos] = new CharNode()) : (target.children[pos]);
        }
        target.word = word ;
    }

    public class CharNode {
        public String word ;
        public CharNode[] children = new CharNode[26] ;

        public CharNode() {} ;
    }
}
