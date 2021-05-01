class Solution {
    public boolean backspaceCompare(String s, String t) {
    String processedS = process(s);
            String processedT = process(t);
            return processedS.equals(processedT);
    }
    private String process(String str) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '#') {
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else {
                    sb.append(str.charAt(i));
                }
            }
            return sb.reverse().toString();
        }
}