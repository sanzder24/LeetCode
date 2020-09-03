class Solution {
    public int reverse(int x) {
        long target = 0;
        while (x != 0) {
            target = target * 10 + x % 10;
            x = x / 10;
        }
        
        if (target < Integer.MIN_VALUE || target > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)target;
        }
    }
}