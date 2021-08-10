class Node {
    char[] word;
    int index;
    Node(String w, int index) {
        this.word = w.toCharArray();
        this.index = index;
    }
}

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Queue<Node>[] dict = new LinkedList[128];
        int count = 0;
        for (char c = 'a'; c <= 'z'; ++c) {
            dict[c] = new LinkedList<>();
        }
        
        for (int i = 0; i < words.length; ++i) {
            dict[words[i].charAt(0)].add(new Node(words[i], 0));
        }
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            Queue<Node> queue = dict[ch];
            for (int start = queue.size(); start > 0; --start) {
                Node node = queue.poll();
                if (++node.index == node.word.length) {
                    count++;
                } else {
                    dict[node.word[node.index]].add(node);
                }
                
            }
            
        }
        return count;
    }
}
