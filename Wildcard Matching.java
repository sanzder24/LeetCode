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


class Solution {
    public boolean isMatch(String s, String p) {
        
        // the key is to deal with the "*", keey two variables lastStar tracks the last position of "*" encountered
        // lastmatch records the index in string s that matches character in p after the most recent "*" is encountered, 
        // initially lastMatch index in s = lastPosition of "*" in p
        
        int lastMatch = -1;
        
        int lastStart = -1;
        
        
        int p1 = 0;
        
        int p2 = 0;
        
        while (p1 < s.length()) {
            if (p2 < p.length() && (s.charAt(p1) == p.charAt(p2) || p.charAt(p2) == '?')) {
                p1++;
                p2++;
            }
            
            else if (p2 < p.length() && p.charAt(p2) == '*') {
                lastMatch = p1;
                
                lastStart = p2;
                
                p2++;
                
                // do not increase p1-> treat "*" as empty at the beginning, try to let "*" match from zero character in s to maximum possible
                // number of chars in s
            }
            
            // note that here else includes a mismatch of characters in s and p or p has reached the end while s has not consumed all its characters
            // if pattern string reaches the end and string s has not reached the end, all the remaining characters in s must be matched with
            
            // pattern string's "*"
            
            else {
                if (lastStart != -1) {
                    
                    // put the last matched characters to match with "*" instead
                    p1 = lastMatch+1;
                    
                    lastMatch = p1;
                    
                    // reset the pointer in pattern string
                    p2 = lastStart+1;
                }
                else {
                    return false;
                }
            }
            
        
       }
        
        
        // we use p1 < s.length() so that if the while loop ends, we know all the characters in s must have been consumed
        
        
        // after the while loop breaks, check if there are trailing "*" in pattern string
        
        while (p2 < p.length() && p.charAt(p2) == '*') {
            p2++;
        }
        
        return p2 == p.length();
    }
}