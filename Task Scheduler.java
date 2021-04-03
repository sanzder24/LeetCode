class Solution {
    public int leastInterval(char[] tasks, int n) {
       HashMap<Character, Integer> map = new HashMap<>();
        for( char c: tasks){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int cycles =0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->b-a);
        maxheap.addAll(map.values());
    
        while(!maxheap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for( int i=0; i<n+1; i++){
                if(!maxheap.isEmpty())
                {
                  temp.add(maxheap.remove());  
                }      
            }
            for( int i: temp){
                if(--i>0){
                    maxheap.add(i);
                }
            }
            cycles += maxheap.isEmpty()? temp.size() : n+1 ;
        }
        return cycles;
    }
}