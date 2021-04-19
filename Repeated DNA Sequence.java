class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> seen = new HashMap<>();
        List<String> result = new ArrayList<>();
        int i=0;
        while(i + 10 <= s.length()){
            String current = s.substring(i, i++ + 10);
            seen.put(current, seen.getOrDefault(current, 0)+1);
            if(seen.get(current)==2){
                result.add(current);
            }
        }
        return result;
    }
}