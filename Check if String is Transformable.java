class Solution {
    public boolean isTransformable(String s, String t) {
        
        ArrayList<Integer>[] idx = new ArrayList[10];   // To store positions of every digit in s.
        // Initialize and store the positions of each digit.
        for(int i=0; i<10; i++) {
            idx[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<s.length(); i++) {
            idx[s.charAt(i) - '0'].add(i);
        }
        
        int[] cnt = new int[10];        // To calculate the frequency of each digit in t.
        for(int i=0; i<t.length(); i++) {
            // The position of `d` in t is position i.
            // We need to check if we can put `d` in s to the position i of s.
            int d = t.charAt(i) - '0';  
            if(cnt[d] >= idx[d].size()) {   // If there has more d than s has, return false.
                return false;               // For example, there have 3 `5`s in string t,
            }                               // and only 2 `5`s in string s, it should return false.
            
            // Then we need to check if we can put digit `d` into the position i of s.
            for(int j=0; j<d; j++) {
                // cnt[j] < idx[j].size(), i.e. there still have extra smaller digit `j` in t we need to consider.
                // idx[j].get(cnt[j]) < idx[d].get(cnt[d]), i.e. (cnt[j])th `j` is in front of (cnt[d])th `d`,
                // and since `j < d`, we cannot swith `j` and `d`, i.e. the i-th position in s must left for digit `j`
                // and we cannot put `d` at position i in s. Therefore, we should return false.
                if(cnt[j] < idx[j].size() && idx[j].get(cnt[j]) < idx[d].get(cnt[d])) {
                    return false;
                }
            }
            cnt[d]++;
        }
        return true;
    }
}
Collect indexes of all characters 0-9 of the source strings in idx. For each characters, we track which indexes we have used in pos.

For each character ch in the target string, check if we have it in idx. If so, verify that there are no smaller characters in front of it. To do that, we check the current idexes of all characters less than ch.

If the character can be moved, mark its index as used by advancing pos[ch].