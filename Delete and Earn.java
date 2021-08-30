class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] dp=new int[10001];
        int use=0,avoid=0,prev=-1;
        
        for(int n:nums)
            dp[n]++;
        
        for(int i=0;i<=10000;i++){
            if(dp[i]>0){
                int m=Math.max(avoid,use);
                if(i-1!=prev){
                    use=i*dp[i]+m;
                    avoid=m;
                }
                else{
                    use=i*dp[i]+avoid;
                    avoid=m; 
                }
                prev=i;
            }
        }
        return Math.max(avoid,use);
    }
}