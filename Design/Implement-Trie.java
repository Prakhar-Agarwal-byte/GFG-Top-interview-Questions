class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = getNewNode('/');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch: word.toCharArray()) {
            if (cur.children[ch-'a'] == null) {
                TrieNode node = getNewNode(ch);
                cur.children[ch-'a'] = node;
            }
            cur = cur.children[ch-'a'];
        }
        cur.isEndOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch: word.toCharArray()) {
            if (cur.children[ch-'a'] == null) {
                return false;
            }
            cur = cur.children[ch-'a'];
        }
        return cur.isEndOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch: prefix.toCharArray()) {
            if (cur.children[ch-'a'] == null) return false;
            cur = cur.children[ch-'a'];
        }
        return true;
    }

    private TrieNode getNewNode(char val) {
        TrieNode newNode = new TrieNode();
        newNode.val = val;
        newNode.children = new TrieNode[26];
        return newNode;
    }

    class TrieNode {
        char val;
        boolean isEndOfWord;
        TrieNode[] children;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
