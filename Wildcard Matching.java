class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        int[][] dp = new int[s.length()][p.length()];
        return helper(0, 0, s, p, dp);

    }
    private static boolean helper(int i, int j, String s, String p, int[][] dp) {
        if (i >= s.length() && j >= p.length()) return true;
        if (i >= s.length() || j >= p.length()) {
            if ((i < s.length() && s.charAt(i) == '*')) {
                return helper(i + 1, j, s, p, dp);
            }
            if ((j < p.length() && p.charAt(j) == '*')) {
                return helper(i, j + 1, s, p, dp);
            }
            return false;
        }
        char a = s.charAt(i);
        char b = p.charAt(j);
        if (dp[i][j] != 0) return dp[i][j] == 1;
        boolean res;
        if (a == '*' || b == '*') res = helper(i + 1, j, s, p, dp) ||
                helper(i + 1, j + 1, s, p, dp) || helper(i, j + 1, s, p, dp);
        else if (a == '?' || b == '?') res = helper(i + 1, j + 1, s, p, dp);
        else res = (a == b) && helper(i + 1, j + 1, s, p, dp);
        dp[i][j] = res ? 1: -1;
        return res;
    }

}