class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String sent = String.join(" ", sentence) + " ";
        int pos = 0, len = sent.length();
        System.out.println(len);
        for(int i=0; i<rows; i++) {
            pos += cols;
            System.out.println(pos);
            while(pos >=0 && sent.charAt(pos%len)!=' '){
                pos--;
                System.out.println("af "+ pos);
            }
            pos++;
        }
        return pos / len;
    }
}