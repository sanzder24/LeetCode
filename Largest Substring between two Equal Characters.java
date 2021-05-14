class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max =-1;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int lastindex = s.lastIndexOf(c);
            if(lastindex!=i){
                max = Math.max(max, lastindex - i -1);
            }
        }
        return max;
    }
}