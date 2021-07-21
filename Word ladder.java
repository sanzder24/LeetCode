class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordList.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
       
        int depth = 0;
      
        while(!queue.isEmpty()) {
            depth ++;
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] wordArr = currWord.toCharArray();
                
                //Generate all possibilites of the current word by replacing each letter
                for(int index = 0; index < wordArr.length; index ++) {
                    
                    for(char alpha = 'a'; alpha <= 'z'; alpha ++) {
                        
                        wordArr[index] = alpha;
                        String word = String.valueOf(wordArr);
                        
                        if(word.equals(currWord))
                            continue;
                        
                        // Since its BFS, we will arrive to the shortest path first
                        // Hence we can return
                        if(word.equals(endWord)) {
                            return depth+1;
                        }
                        
                        if(wordSet.contains(word)) {
                            wordSet.remove(word);
                            queue.offer(word);
                        }
                    }
                    
                    //Replace the character back to its original
                    wordArr[index] = currWord.charAt(index); 
                }
            }
        } //End of while
        
        return 0;
    }
}