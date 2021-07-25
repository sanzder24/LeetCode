class Solution {
    public int minNumberOperations(int[] target) {
    if (target == null || target.length == 0) return 0;
    int result = target[0];
    for (int i = 1; i < target.length; ++i) {
        if (target[i - 1] < target[i]) {
            result += target[i] - target[i - 1];
        }
    }
    return result;
}
}