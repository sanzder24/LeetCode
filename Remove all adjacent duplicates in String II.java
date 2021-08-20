class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < stringBuilder.length(); i++) {
            if (i == 0 || stringBuilder.charAt(i) != stringBuilder.charAt(i - 1)) {
                stack.push(1);
            } else {
                int incrementedCount = stack.pop() + 1;
                if (incrementedCount == k) {
                    stringBuilder.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stack.push(incrementedCount);
                }
            }
        }
        return stringBuilder.toString();
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        int slowIndex = 0;

        for (int fastIndex = 0; fastIndex < s.length(); fastIndex++, slowIndex++) {
            charArray[slowIndex] = charArray[fastIndex];

            if (slowIndex == 0 || charArray[slowIndex] != charArray[slowIndex - 1]) {
                stack.push(1);
            } else {
                int incrementedCount = stack.pop() + 1;
                if (incrementedCount == k) {
                    slowIndex = slowIndex - k;
                } else {
                    stack.push(incrementedCount);
                }
            }
        }
        return new String(charArray, 0, slowIndex);
    }
}