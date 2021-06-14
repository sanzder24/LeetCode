class Solution {
    public int totalFruit(int[] tree) {
        if( tree ==null || tree.length ==0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int j=0, i=0;
        
        int max =1;
        while( j<tree.length ) {
            if(map.size() <=2) {
                map.put(tree[j], j++); //j for pointer to locate last occurence
            }
            if(map.size()>2) {
                int min =tree.length-1; //initial high value
                for( int value: map.values()) {     
                min = Math.min(min, value);
                }
            i = min+1;
            map.remove(tree[min]);
            }
            max = Math.max(max, j-i);
        }
        return max;
    }
}