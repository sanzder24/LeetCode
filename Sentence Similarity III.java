class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String shorter = sentence1.length() < sentence2.length() ? sentence1 : sentence2;
            String longer = shorter.equals(sentence1) ? sentence2 : sentence1;
            String[] shortWords = shorter.split(" ");
            String[] longWords = longer.split(" ");
            int breaks = 0;
            int j = 0;
            int i = 0;
            for (; i < shortWords.length && j < longWords.length; ) {
                if (shortWords[i].equals(longWords[j])) {
                    j++;
                    i++;
                } else {
                    breaks++;
                    if (breaks > 1) {
                        break;
                    }
                    while (j < longWords.length && !longWords[j].equals(shortWords[i])) {
                        j++;
                    }
                }
            }
            if ((breaks == 1 && i == shortWords.length && j == longWords.length) || (i == shortWords.length && breaks == 0)) {
                return true;
            }
            //we'll check from the left side and move towards the right side
            breaks = 0;
            i = shortWords.length -1;
            j = longWords.length -1;
            for(; j>=0 && i>=0;){
                if(shortWords[i].equals(longWords[j])){
                    j--;
                    i--;
                } else {
                    breaks++;
                    if(breaks>1){
                        break;
                    }
                    while(j>=0 && !longWords[j].equals(shortWords[i])){
                        j--;
                    }
                }
            }
            return (j==-1 && i==-1 && breaks ==1) || (i==-1 && breaks ==0);
        }
    }