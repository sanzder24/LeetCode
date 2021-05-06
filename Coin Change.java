class Solution {
    public int coinChange(int[] coins, int amount) {
  int[] dp = new int[amount +1];
  Arrays.fill(dp, amount+1);
  dp[0]=0;
        for(int i=0; i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                     dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]); //if taking the coin and checking prev value subtracting the coin
                }  //example: 11 -> 5 + 5 + 1 // Dp[2] = min(2,1) from  1 (c) x 2 or 2 (c) x 1 
                
            }
        }
        return dp[amount]>amount ? -1: dp[amount];
}
}