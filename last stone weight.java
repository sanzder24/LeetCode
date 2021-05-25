class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)-> b-a);
        for(int i: stones){
        maxheap.add(i);
        }
        while(maxheap.size()>1){
            int last_max = maxheap.remove();
            int last_prev = maxheap.remove();
            if(last_max > last_prev){
                maxheap.add(last_max - last_prev);
            } else if(last_max == last_prev) {
                continue;
            }
        }
        return maxheap.size() ==1 ? maxheap.remove() : 0;
        
    }
}