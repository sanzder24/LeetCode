class Solution{
	public int connectSticks( int[] sticks){

		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		for( int i: sticks){
			minheap.add(i);
		}
		int cost =0;
		while(minheap.size()>1){
			int sum = minheap.remove() + minheap.remove(); //new cost of combining and removing old ones
			cost += sum; // adding to find total cost
			minheap.add(cost); 
		}	
		return cost;
	}
}