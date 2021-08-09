class Solution {
    public boolean isValid(String s) {
        char[] str = new char[s.length()];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                str[k] = ']';
                k++;
            } else if (c == '(') {
                str[k] = ')';
                k++;
            } else if (c == '{') {
                str[k] = '}';
                k++;
            } else {
                k--;
                if (k < 0 || str[k] != c) {
                    return false;
                }
            }
        }
        
        return k == 0;
    }
}