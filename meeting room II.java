class Solution{
	public int minMeetingRooms( Interval[] intervals){
		if(intervals.length==0 || intervals ==null){
			return 0;
		}
		Arrays.sort(intervals, (a.b)-> a.start -b.start);
		PriorityQueue<Interval> minheap = new PriorityQueue <>((a,b)-> a.end -b.end);
		minheap.add(intervals[0]);
		for(int i =1; i<intervals.length; i++){
			Interval current = intervals[i];
			Interval earliest = minheap.remove();
			if(current.start>=earliest.end){
				earliest.end = current.end;
			}
			else {
				minheap.add(current);
			}
		}
		return minheap.size();
	}
}