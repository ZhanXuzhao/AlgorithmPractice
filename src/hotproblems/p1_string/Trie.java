package hotproblems.p1_string;

import org.junit.Test;

import java.util.*;

public class Trie {
    private TrieNode mRoot = new TrieNode();

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = mRoot;
        for (int i = 0; i < word.length(); i++) {
            char charAt = word.charAt(i);
//            System.out.println(charAt);
            if (node.containKey(charAt)) {
                node = node.get(charAt);
            } else {
                node.put(charAt, new TrieNode());
                node = node.get(charAt);
            }
        }
        node.setEnd();
    }

    public TrieNode searchPrefixNode(String prefix) {
        TrieNode node = mRoot;
        for (int i = 0; i < prefix.length(); i++) {
            char charAt = prefix.charAt(i);
            node = node.get(charAt);
            if (node == null) {
                break;
            }
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode trieNode = searchPrefixNode(word);
        return trieNode != null && trieNode.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode trieNode = searchPrefixNode(prefix);
        return trieNode != null;
    }

    @Test
    public void test() {
        String word = "hello";
        String word2 = "he";
        String word3 = "eh";
        Trie obj = new Trie();
        obj.insert(word);
        assert obj.search(word);
        assert !obj.search(word2);
        assert obj.startsWith(word2);
        assert !obj.startsWith(word3);
    }

}
