class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Random ran = new Random();
        ArrayList<String> possibles = new ArrayList<>();
        for (String word : wordlist){
            possibles.add(word);
        }
        int trials = 0;
        while (trials < 10){
            int index = ran.nextInt(possibles.size());
            String testWord = possibles.get(index);
            int matches = master.guess(testWord);
            System.out.println("testWord :" + testWord);
            if (matches == 6){
                
            return;
            }
                
            ArrayList<String> newPossibles = new ArrayList<>();
            for (String word : possibles){
                System.out.println("Testword :"+ testWord + " word :"+ word);
                if (countMatches(testWord, word) == matches){
                    System.out.println("Matched ");
                    newPossibles.add(word);
                }
            }
            possibles = newPossibles;
            trials++;
        }
    }
    
    private int countMatches(String word1, String word2){
        int m = 0;
        for (int i = 0, j = 0; i < 6 && j < 6; ++i, ++j){
            if (word1.charAt(i) == word2.charAt(j)){
                m++;
            }
        }
        return m;
    }
}