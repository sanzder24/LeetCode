class Solution {
    public int maxLength(List<String> arr) {
        int[] result = new int[1];
        maxcheck(arr, 0, "", result);
        return result[0];
    }
    public void maxcheck( List<String> arr, int index, String current, int[] result){
        if(index==arr.size() && uniquecheck(current)>result[0]){
            result[0]= current.length();
            return;
        }
        if(index ==arr.size()){
            return;
        }
        maxcheck(arr, index + 1, current, result);
        maxcheck(arr, index + 1, current + arr.get(index), result);
    }
    public int uniquecheck(String s){
        int[] counts = new int[26];
        for( char c: s.toCharArray()){
            if(counts[c-'a']++ > 0){
                return -1;
            }
        }
        return s.length();
    }
}