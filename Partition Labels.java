class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] index = new int[26];
        for( int i=0; i<S.length(); i++){
            index[S.charAt(i)-'a']=i;            
        }
        int i=0;
        while(i<S.length()){
            int end = index[S.charAt(i)-'a'];
            int j= i;
            while(j!=end){
                end = Math.max(end, index[S.charAt(j++)-'a']);
            }
            result.add(j-i + 1);
            i=j+1;
        }
        return result;
    }
}