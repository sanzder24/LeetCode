class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> que =new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int i =0; i<nums.length; i++){
         map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        que.addAll(map.keySet());
        int[] arr = new int[k];
        for( int i=0; i<k; i++){
            arr[i]=que.remove();
        }
        return arr;
    }
}