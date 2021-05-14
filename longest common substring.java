class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()][text2.length()];
        if(text1.length()==0 || text2.length()==0) return 0;
        String out = "";
        for(int i =0; i<text1.length(); i++){
            for(int j=0; j<text2.length();j++){
            if(text1.charAt(i)==text2.charAt(j)){
                if(i==0 || j==0){
                    cache[i][j]=1;
                }
                else {
                cache[i][j] = cache[i-1][j-1]+1;
               }
                if(cache[i][j]>out.length()){
                out = text1.substring(i - cache[i][j] +1, i+1);
              }
             }
            }
        }
        return out;
    }
}