class Solution {
       public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0 ; i < indexes.length; i++) sorted.add(new int[]{indexes[i], i});
        Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
        for (int[] ind: sorted) {
            int i = ind[0], j = ind[1];
            String s = sources[j], t = targets[j];
            if (S.substring(i, i + s.length()).equals(s)) S = S.substring(0, i) + t + S.substring(i + s.length());
        }
        return S;
    }
}
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int[] matches = new int[n];
        Arrays.fill(matches, -1);

        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (s.substring(index, index+ sources[i].length()).equals(sources[i])) {
                matches[index] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < n) {
            if (matches[index] >= 0) {
                result.append(targets[matches[index]]);
                index += sources[matches[index]].length();
            } else {
                result.append(s.charAt(index++));
            }
        }

        return result.toString();
    }
}