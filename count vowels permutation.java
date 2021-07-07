class Solution {
    
    int[] charValue = new int[26];
    int modulo = ((int) Math.pow(10.0, 9.0)) + 7;
    char[] arr = {'a','i','e','o','u'};
    public int countVowelPermutation(int n) {
        charValue[0] = 0;
        charValue['e'-'a'] = 1;
        charValue['i'-'a'] = 2;
        charValue['o'-'a'] = 3;
        charValue['u'-'a'] = 4;
        Integer[][] dp = new Integer[n+1][5];
        int count = 0;
        for(char ch : arr){
            count += dfs(dp, n-1, ch);
            count %= modulo;
        }
        return count;
    }
    
    public int dfs(Integer[][] dp, int remain, char prev){
        if(remain == 0)
            return 1;
        
        if(dp[remain][charValue[prev-'a']] != null)
            return dp[remain][charValue[prev-'a']];
        
        int count = 0;
        if(prev == 'a'){
            count = dfs(dp, remain-1, 'e');
        }else if(prev == 'e'){
            count += dfs(dp, remain-1, 'a');
            count %= modulo;
            count += dfs(dp, remain-1, 'i');
        }else if(prev == 'i'){
            for(char ch : arr){
                if(ch == 'i')
                    continue;
                count += dfs(dp, remain-1, ch);
                count %= modulo;
            }
        }else if(prev == 'o'){
            count += dfs(dp, remain-1, 'u');
            count %= modulo;
            count += dfs(dp, remain-1, 'i');
        }else{
            count = dfs(dp, remain-1, 'a');
        }
        count %= modulo;
        dp[remain][charValue[prev-'a']] = count;
        return count;
        
    }
}