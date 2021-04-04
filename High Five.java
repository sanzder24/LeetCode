class Solution{
	public int[][]highFive( int [][] items){
		TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap();
		for (int item: items){
			int id= item[0];
			int score = item[1];
			if(map.containsKey(id)){
				PriorityQueue<Integer> heap = map.get(id);
				heap.offer(score);
				if(heap.size()>5){
					heap.poll();
				}
				map.put(id, heap);
			}
			else {
				PriorityQueue<Integer> heap = new PriorityQueue();
				heap.offer(score);
				map.put(id, heap);
			}

		}
		int[][] result = new int[map.size()][2];
		for( int id: map.KeySet()){
			PriorityQueue<Integer> heap = map.get(id);
			int sum=0; 
			while(!heap.isEmpty()){
				sum += heap.poll();
			}
			result[id-1][0]=id;
			result[id-1][1]=sum/5;
		}
		return result;
	}
}