import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Trie trieDS = new Trie();
        trieDS.insertWord("dog");
        trieDS.insertWord("deer");
        trieDS.insertWord("deal");
        trieDS.print();
        System.out.println(trieDS.advanceSearch("de"));
    }
}

class TrieNode {
    TrieNode[] children;
    char ch;
    int endWord;

    public TrieNode(char ch) {
        this.ch = ch;
        children = new TrieNode[26];
        this.endWord = 0;
    }
}
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('/');
    }
    public void insertWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode(word.charAt(i));
            }
            cur = cur.children[index];
        }
        cur.endWord++;
    }

    public List<String> advanceSearch(String prefix) {
        List<String> autoComplete = new ArrayList<>();
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            cur = cur.children[prefix.charAt(i)-'a'];
            if (cur == null) return autoComplete;
        }
        search(cur, prefix, autoComplete);
        return autoComplete;
    }

    private void search (TrieNode node, String word, List<String> list) {
        if (node == null) {
            return;
        }
        if (node.endWord > 0) {
            list.add(word);
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] == null) continue;
            search(node.children[i], word + node.children[i].ch, list);
        }
    }

    public void print() {
        dfs(root, "");
    }
    private void dfs(TrieNode cur, String word) {
        if (cur == null) return;
        if (cur.endWord>0) System.out.println(word);
        for (int i = 0; i < 26; i++) {
            if (cur.children[i] == null) continue;
            dfs(cur.children[i], word + cur.children[i].ch);
        }
    }
}
