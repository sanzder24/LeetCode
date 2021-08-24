class AutocompleteSystem {
    private Trie root;
    private Trie curNode;
    private StringBuilder curChars;
    private Map<String, Integer> sentence_freq;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        // assume that all parametes input are valid
        this.root = new Trie();
        this.curNode = root;
        this.curChars = new StringBuilder();
        sentence_freq = new HashMap<>();
        
        for (int i = 0; i < sentences.length; i++) {
            sentence_freq.put(sentences[i], times[i]);
        }
        
        for (String sentence : sentences) {
            buildTrie(sentence);
        } 
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            String sentence = curChars.toString();
            sentence_freq.put(sentence, sentence_freq.getOrDefault(sentence, 0)+1);
            buildTrie(sentence);
            
            this.curNode = root;
            this.curChars = new StringBuilder();
            return new ArrayList<>();
        } else {
            curChars.append(c);
            if (curNode!=null) {
                curNode = curNode.children[c == ' ' ? 26 : c-'a'];
            }
            return curNode!=null ? curNode.topThree : new ArrayList<>();
        }
    }
    
    private void buildTrie(String sentence) {
        Trie node = root;
        int freq = sentence_freq.get(sentence);
        
        for (char c : sentence.toCharArray()) {
            if (c == '#') break;
            int index = c == ' ' ? 26 : c-'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
            
            List<String> topThree = node.topThree;
            topThree.remove(sentence);
            
            for (int i = 0; i<3; i++) {
                if (i==topThree.size()) {
                    topThree.add(sentence);
                    break;
                }
                String preSentence = topThree.get(i);
                int preFreq = sentence_freq.get(preSentence);
                
                if (preFreq<freq || preFreq==freq && sentence.compareTo(preSentence)<0) {
                    topThree.add(i, sentence);
                    break;
                }
            }
            if (topThree.size()>3) topThree.remove(3);
        }
    }
}

class Trie {
    List<String> topThree;
    Trie[] children;
    public Trie() {
        this.topThree = new ArrayList<>();
        children = new Trie[27];//Trie[26] is for empty char ' '
    }
}