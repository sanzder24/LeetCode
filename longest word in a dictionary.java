class Solution {
    TrieNode root;
    class TrieNode {
        String word;
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    public String longestWord(String[] words) {
        // use Trie
        root = new TrieNode();
        
        for (String word : words) {
            insert(word);
        }
        return findLongestWord(root);
    }
    
    private void insert(String s) {
        TrieNode cur = root;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = s;
    }
    
    private String findLongestWord(TrieNode root) {
        String res = root.word == null ? "" : root.word;
        for (TrieNode child : root.children) {
            if (child == null || child.word == null) {
                continue;
            }
            String s = findLongestWord(child);
            if (s.length() > res.length()) {
                res = s;
            }
        }
        return res;
    }
}