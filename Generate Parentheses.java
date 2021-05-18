class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    public void generate(List<String> ans, StringBuilder cur, int open, int close, int max){
        if(cur.length()==max*2){
            ans.add(cur.toString());
            return;
        }
        if(open < max){
            cur.append("(");
            generate(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if(close < open){ //less than open
            cur.append(")");
            generate(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}