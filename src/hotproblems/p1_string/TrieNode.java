package hotproblems.p1_string;

public class TrieNode {
    private static int R = 26;
    private TrieNode[] links = new TrieNode[R];
    private boolean isEnd = false;

    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    public boolean containKey(char c) {
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}
