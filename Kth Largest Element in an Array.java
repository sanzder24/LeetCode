class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue <Integer> minheap = new PriorityQueue<Integer>();
        for( int i:nums){
        minheap.add(i);
            if(minheap.size()>k){
            minheap.remove();
            }
        }
        return minheap.remove();
    }
}