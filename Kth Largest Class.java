class KthLargest {
    // practice
    private Queue<Integer> minHeap = new PriorityQueue<>();
    private int K = 0;
    public KthLargest(int k, int[] nums) {
        this.K = k;
        for (int val : nums) {
            add(val);
        }
     }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > K) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
    
    
}
