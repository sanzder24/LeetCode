class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] =-1;
            }
        }
        return lcs(text1, text2, 0, 0, dp);
    }
    int lcs( String text1, String text2, int i, int j, int[][] dp){
        if(i==text1.length() || j==text2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
           return dp[i][j] = lcs(text1, text2 , i+1, j+1, dp) +1; 
        }
        else{
            return dp[i][j] =Math.max(lcs(text1, text2, i+1, j, dp), lcs(text1, text2, i, j+1, dp));
        }
    }
}