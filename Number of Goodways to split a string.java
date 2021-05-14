class Solution {
    public int numSplits(String s) {
        int[] right = new  int[26];
        int[] left = new int[26];
        int goodsplit =0;
        for( int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            right[ c - 'a']++;
        }
        for( int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            left[ c - 'a']++;
            right[ c - 'a']--;
            
            int left_check= get_distinct(left);
            int right_check= get_distinct(right);
            
            if(left_check == right_check){
            goodsplit++;
            }
        }
        return goodsplit;
    }
    int get_distinct(int[] num){
        int c=0;
        for(int i: num){
            if(i!=0){
                c++;
            }
        }
        return c;
    }
}